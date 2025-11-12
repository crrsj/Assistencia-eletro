package br.com.assistencia.exceptions;

import br.com.assistencia.components.UnicoCpf;
import br.com.assistencia.repository.ClienteRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import br.com.assistencia.dto.ClienteDTO;

@Component
@RequiredArgsConstructor
public class ValidarCpf implements ConstraintValidator<UnicoCpf,String> {

    private final ClienteRepository clienteRepository;
    @Override
    public boolean isValid(String cpf, ConstraintValidatorContext context) {
        if(cpf == null || cpf.trim().isEmpty()){
            return true;
        }
        return !clienteRepository.existsByCpf(cpf);
    }
}
