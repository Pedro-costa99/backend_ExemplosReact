package chamados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import chamados.model.Perfil;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long>{

}
