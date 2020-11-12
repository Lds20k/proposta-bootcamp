package br.com.zup.bootcamp.entity;

import java.time.LocalDate;

// Carga intrínseca = 1/7
public class AdviseTrip {

    private final String id;

    private final String card;

    private final String destiny;

    private final LocalDate ending;

    private final LocalDate saveDate;

    private final String ip;

    private final String userAgent;

    private final Proposal proposal;

    public AdviseTrip(String card, String destiny, LocalDate ending, String ip, String userAgent, Proposal proposal) {
        this.id = null;
        this.card = card;
        this.destiny = destiny;
        this.ending = ending;
        this.ip = ip;
        this.userAgent = userAgent;
        this.saveDate = null;
        this.proposal = proposal;
    }

    public AdviseTrip(String id, String card, String destiny, LocalDate ending, LocalDate saveDate, String ip, String userAgent, Proposal proposal) {
        this.id = id;
        this.card = card;
        this.destiny = destiny;
        this.ending = ending;
        this.saveDate = saveDate;
        this.ip = ip;
        this.userAgent = userAgent;
        this.proposal = proposal;
    }

    public String getId() {
        return id;
    }

    public String getCard() {
        return card;
    }

    public String getDestiny() {
        return destiny;
    }

    public LocalDate getEnding() {
        return ending;
    }

    public LocalDate getSaveDate() {
        return saveDate;
    }

    public String getIp() {
        return ip;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public Proposal getProposal() {
        return proposal;
    }
}
