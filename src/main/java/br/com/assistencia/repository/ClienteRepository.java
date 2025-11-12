package br.com.assistencia.repository;

import br.com.assistencia.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import javax.swing.*;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    Optional<Cliente>findByCpf(@Param("cpf") String cpf);
}
