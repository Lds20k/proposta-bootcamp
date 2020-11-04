package br.com.zup.bootcamp.resource.dto.response;

import br.com.zup.bootcamp.enumerate.Eligibility;

public class ProposalResponse {
    private final Eligibility eligibility;

    public ProposalResponse(Eligibility eligibility) {
        this.eligibility = eligibility;
    }

    public Eligibility getEligibility() {
        return eligibility;
    }
}
