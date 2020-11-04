package br.com.zup.bootcamp.client.response;

import java.time.LocalDateTime;

// Carga intrínseca = 0/7
public class DueDateResponse {
    private final String id;

    private final Integer dia;

    private final LocalDateTime dataDeCriacao;

    public DueDateResponse(String id, Integer dia, LocalDateTime dataDeCriacao) {
        this.id = id;
        this.dia = dia;
        this.dataDeCriacao = dataDeCriacao;
    }

    public String getId() {
        return id;
    }

    public Integer getDia() {
        return dia;
    }

    public LocalDateTime getDataDeCriacao() {
        return dataDeCriacao;
    }
}
