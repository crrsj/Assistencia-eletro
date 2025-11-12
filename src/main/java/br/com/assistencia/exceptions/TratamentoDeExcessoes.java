package br.com.assistencia.exceptions;

import br.com.assistencia.dto.MensagemDeErro;
import br.com.assistencia.dto.ValidarCampos;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TratamentoDeExcessoes {

    @ExceptionHandler(ClienteNaoEncontrado.class)
    public ResponseEntity<MensagemDeErro>idClienteNaoEncontrado(){
        var msg = new MensagemDeErro(HttpStatus.NOT_FOUND,"Cliente não encontrado !");
        return ResponseEntity.ok().body(msg);
    }

    @ExceptionHandler(EletroNaoEncontrado.class)
    public ResponseEntity<MensagemDeErro>idEletroNaoEncontrado(){
        var msg = new MensagemDeErro(HttpStatus.NOT_FOUND,"Eletro não encontrado !");
        return ResponseEntity.ok().body(msg);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?>ValidandoCampos(MethodArgumentNotValidException exception){
        var erros = exception.getFieldErrors();
        return ResponseEntity.badRequest().body(erros.stream().map(ValidarCampos::new).toList());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<MensagemDeErro>erroNoCpf(){
        var msg = new MensagemDeErro(HttpStatus.BAD_REQUEST,"CPF inválido");
        return ResponseEntity.badRequest().body(msg);
    }

   }
