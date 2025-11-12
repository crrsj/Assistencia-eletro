package br.com.assistencia.exceptions;

public class EletroNaoEncontrado extends RuntimeException {

    public EletroNaoEncontrado(String mensagem){
        super(mensagem);
    }

    public EletroNaoEncontrado(){
        super();
    }
}
