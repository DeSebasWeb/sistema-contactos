package sl.contactos.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import sl.contactos.modelo.Contacto;
import sl.contactos.servicio.ContactoServicio;

import java.util.List;

@Controller
public class ContactoControlador {
    private static final Logger logger = LoggerFactory.getLogger(ContactoControlador.class);

    @Autowired
    private ContactoServicio contactoServicio;

//    Notacion para procesar url
    @GetMapping("/")
    public String iniciar(ModelMap modelo){
        List<Contacto> contactos = contactoServicio.mostrarContactos();
        contactos.forEach((contacto) -> logger.info(contacto.toString()));
//     Compartir datos desde el backend al frontend
        modelo.put("contactos", contactos);
        return "index";//index.html
    }

    @GetMapping("/agregar")
    public String mostrarAgregar(){
        return "agregar";//agregar html
    }

}
