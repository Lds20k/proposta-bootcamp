package br.com.zup.bootcamp.client.response;

import java.time.LocalDateTime;

// Carga intrínseca = 0/7
public class WalletResponse {
    private final String id;

    private final String email;

    private final LocalDateTime associadaEm;

    private final String emissor;

    public WalletResponse(String id, String email, LocalDateTime associadaEm, String emissor) {
        this.id = id;
        this.email = email;
        this.associadaEm = associadaEm;
        this.emissor = emissor;
    }
}
