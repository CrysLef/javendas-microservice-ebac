package br.com.cryslefundes.javendas.vendaservice.service.validation;

public interface Validation<T extends Record> {
    void valida(T dto);
}
