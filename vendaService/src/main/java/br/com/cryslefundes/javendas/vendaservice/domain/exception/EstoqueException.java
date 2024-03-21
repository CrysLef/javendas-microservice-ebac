package br.com.cryslefundes.javendas.vendaservice.domain.exception;

public class EstoqueException extends RuntimeException {
    public EstoqueException(String message) {
        super(message);
    }

    public EstoqueException(String message, Throwable cause) {
        super(message, cause);
    }
}
