package br.com.assistencia.exceptions;

public class ClienteNaoEncontrado extends RuntimeException{
    public ClienteNaoEncontrado(String mensagem){
        super(mensagem);
    }

    public ClienteNaoEncontrado(){
        super();
    }
}
