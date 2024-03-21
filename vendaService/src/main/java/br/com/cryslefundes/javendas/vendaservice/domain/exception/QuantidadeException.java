package br.com.cryslefundes.javendas.vendaservice.domain.exception;

public class QuantidadeException extends RuntimeException {
    public QuantidadeException(String message) {
        super(message);
    }

    public QuantidadeException(String message, Throwable cause) {
        super(message, cause);
    }
}
