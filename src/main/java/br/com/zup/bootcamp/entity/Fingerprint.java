package br.com.zup.bootcamp.entity;

public class Fingerprint {
    private final String id;
    private final String fingerprintBase64;
    private final Proposal proposal;

    public Fingerprint(String fingerprintBase64, Proposal proposal) {
        this.id = null;
        this.fingerprintBase64 = fingerprintBase64;
        this.proposal = proposal;
    }

    public Fingerprint(String id, String fingerprintBase64, Proposal proposal) {
        this.id = id;
        this.fingerprintBase64 = fingerprintBase64;
        this.proposal = proposal;
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
