package br.com.assistencia.repository;

import br.com.assistencia.entity.EletroDomestico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EletroDomesticoRepository extends JpaRepository<EletroDomestico,Long> {
    Optional<EletroDomestico> findByOrdemServico(@Param("ordemServico") Integer ordemServico);
}
