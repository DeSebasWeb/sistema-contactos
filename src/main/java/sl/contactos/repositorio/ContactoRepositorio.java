package sl.contactos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import sl.contactos.modelo.Contacto;

public interface ContactoRepositorio extends JpaRepository<Contacto, Integer> {
}
