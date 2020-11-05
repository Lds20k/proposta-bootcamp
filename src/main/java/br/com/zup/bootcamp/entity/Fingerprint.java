package br.com.zup.bootcamp.entity;

import java.time.LocalDate;

public class Fingerprint {
    private final String id;

    private final String fingerprintBase64;

    private final LocalDate addedDate;

    private final Proposal proposal;

    public Fingerprint(String fingerprintBase64, Proposal proposal) {
        this.id = null;
        this.fingerprintBase64 = fingerprintBase64;
        this.proposal = proposal;
        this.addedDate = null;
    }

    public Fingerprint(String id, String fingerprintBase64, LocalDate addedDate, Proposal proposal) {
        this.id = id;
        this.fingerprintBase64 = fingerprintBase64;
        this.proposal = proposal;
        this.addedDate = addedDate;
    }

    public String getId() {
        return id;
    }

    public String getFingerprintBase64() {
        return fingerprintBase64;
    }

    public Proposal getProposal() {
        return proposal;
    }
}
