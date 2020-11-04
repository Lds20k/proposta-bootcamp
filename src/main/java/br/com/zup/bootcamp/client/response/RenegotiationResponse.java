package br.com.zup.bootcamp.client.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

// Carga intrínseca = 0/7
public class RenegotiationResponse {
    private final String id;

    private final Integer quantidade;

    private final BigDecimal valor;

    private final LocalDateTime dataDeCriacao;

    public RenegotiationResponse(String id, Integer quantidade, BigDecimal valor, LocalDateTime dataDeCriacao) {
        this.id = id;
        this.quantidade = quantidade;
        this.valor = valor;
        this.dataDeCriacao = dataDeCriacao;
    }
}
