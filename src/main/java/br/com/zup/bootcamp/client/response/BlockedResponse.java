package br.com.zup.bootcamp.client.response;

import java.time.LocalDateTime;

// Carga intrínseca = 0/7
public class BlockedResponse {
    private final String id;

    private final LocalDateTime bloqueadoEm;

    private final String sistemaResponsavel;

    private final Boolean ativo;

    public BlockedResponse(String id, LocalDateTime bloqueadoEm, String sistemaResponsavel, Boolean ativo) {
        this.id = id;
        this.bloqueadoEm = bloqueadoEm;
        this.sistemaResponsavel = sistemaResponsavel;
        this.ativo = ativo;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getBloqueadoEm() {
        return bloqueadoEm;
    }

    public String getSistemaResponsavel() {
        return sistemaResponsavel;
    }

    public Boolean getAtivo() {
        return ativo;
    }
}
