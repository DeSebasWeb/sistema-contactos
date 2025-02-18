package sl.contactos.servicio;

import sl.contactos.modelo.Contacto;

import java.util.List;

public interface IContactoRepositorio {
    public List<Contacto> mostrarContactos();

    public Contacto buscarContactoPorID(Integer id);

    public void guardarContacto(Contacto contacto);

    public void eliminarContacto(Contacto contacto);
}
