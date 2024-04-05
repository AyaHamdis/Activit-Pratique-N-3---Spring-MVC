package ma.hamdis.tp3_springmvc.repository;

import ma.hamdis.tp3_springmvc.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
}
