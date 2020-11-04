package br.com.zup.bootcamp.client.response;

import java.time.LocalDate;

// Carga intrínseca = 0/7
public class WarningResponse {
    private final LocalDate validoAte;

    private final String destino;

    public WarningResponse(LocalDate validoAte, String destino) {
        this.validoAte = validoAte;
        this.destino = destino;
    }
}
