package sl.contactos.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sl.contactos.modelo.Contacto;
import sl.contactos.repositorio.ContactoRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class ContactoServicio implements IContactoRepositorio{
    @Autowired
    private ContactoRepositorio contactoRepositorio;

    @Override
    public List<Contacto> mostrarContactos() {
        return contactoRepositorio.findAll();
    }

    @Override
    public Contacto buscarContactoPorID(Integer id) {
        Contacto contacto = contactoRepositorio.findById(id).orElse(null);
        return contacto;
    }

    @Override
    public void guardarContacto(Contacto contacto) {
        contactoRepositorio.save(contacto);
    }

    @Override
    public void eliminarContacto(Contacto contacto) {
    contactoRepositorio.delete(contacto);
    }

}
