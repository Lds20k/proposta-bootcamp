package br.com.zup.bootcamp.client.response;

import java.math.BigDecimal;

// Carga intrínseca = 0/7
public class PortionResponse {
    private final String id;

    private final Integer quantidade;

    private final BigDecimal valor;

    public PortionResponse(String id, Integer quantidade, BigDecimal valor) {
        this.id = id;
        this.quantidade = quantidade;
        this.valor = valor;
    }
}