package br.com.zup.bootcamp.entity;

import java.time.LocalDateTime;

// Carga intrínseca = 1/7
public class LockedCard {

    private final String id;

    private final String card;

    private final String clientIp;

    private final String userAgent;

    private final LocalDateTime date;

    private final Proposal proposal;

    public LockedCard(String card, String clientIp, String userAgent, Proposal proposal) {
        this.id = "";
        this.card = card;
        this.clientIp = clientIp;
        this.userAgent = userAgent;
        this.date = null;
        this.proposal = proposal;
    }

    public LockedCard(String id, String card, String clientIp, String userAgent, LocalDateTime date, Proposal proposal) {
        this.id = id;
        this.card = card;
        this.clientIp = clientIp;
        this.userAgent = userAgent;
        this.date = date;
        this.proposal = proposal;
    }

    public String getId() {
        return id;
    }

    public String getCard() {
        return card;
    }

    public String getClientIp() {
        return clientIp;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Proposal getProposal() {
        return proposal;
    }
}
