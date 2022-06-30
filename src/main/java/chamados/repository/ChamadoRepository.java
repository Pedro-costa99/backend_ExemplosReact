package chamados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import chamados.model.Chamado;

@Repository
public interface ChamadoRepository extends JpaRepository<Chamado, Long>{

}