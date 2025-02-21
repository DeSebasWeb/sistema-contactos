package sl.contactos.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/agregar")
    public String agregarContacto(@ModelAttribute("contactoFormulario") Contacto contacto){
        logger.info("Contacto a guardar "+contacto.toString());
        contactoServicio.guardarContacto(contacto);
        return "redirect:/";//Redirigir al index o al controlador el path "/"
    }

    @GetMapping("/editar/{id}")
    public String mostrarEditar(@PathVariable(value = "id") int idContacto, ModelMap modelo){//La definicion de estas varables hace que se determine el id pasado en la peticion
        Contacto contacto = contactoServicio.buscarContactoPorID(idContacto);

        logger.info("Contacto a modificar: "+contacto.toString());
        modelo.put("contacto", contacto);
        return "editar";
    }

    @PostMapping("/editar")
    public String editarContacto(@ModelAttribute("contacto") Contacto contacto){
        contactoServicio.guardarContacto(contacto);
        logger.info("Contacto modificado: "+contacto.toString());
        return "redirect:/";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarContacto(@PathVariable(value = "id") int idContacto){
        Contacto contacto = new Contacto();
        contacto.setId(idContacto);
        logger.info("Contacto eliminado: "+ contacto.toString());
        contactoServicio.eliminarContacto(contacto);
        return "redirect:/";
    }
}
