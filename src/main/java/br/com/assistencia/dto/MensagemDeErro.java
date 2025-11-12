package br.com.assistencia.dto;

import org.springframework.http.HttpStatus;

public record MensagemDeErro(HttpStatus status, String mensagem) {
}
