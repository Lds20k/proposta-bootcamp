package br.com.zup.bootcamp.entity;

import java.time.LocalDateTime;

// Carga intrínseca = 1/7
public class PasswordRecover {

    private final String id;
    private final LocalDateTime date;
    private final String ip;
    private final String userAgent;
    private final Proposal proposal;

    public PasswordRecover(String ip, String userAgent, Proposal proposal) {
        this.id = null;
        this.date = null;
        this.ip = ip;
        this.userAgent = userAgent;
        this.proposal = proposal;
    }

    public PasswordRecover(String id, LocalDateTime date, String ip, String userAgent, Proposal proposal) {
        this.id = id;
        this.date = date;
        this.ip = ip;
        this.userAgent = userAgent;
        this.proposal = proposal;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
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
