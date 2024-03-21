package br.com.cryslefundes.javendas.vendaservice.domain;

public enum StatusVenda {
    INICIADA("iniciada"),
    CONCLUIDA("concluida"),
    CANCELADA("cancelada");

    private String status;

    StatusVenda(String status) {
        this.status = status;
    }

    public static StatusVenda getByName(String status) {
        for (StatusVenda s: StatusVenda.values()) {
            if (s.status.equalsIgnoreCase(status)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + status);
    }
}
