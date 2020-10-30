package br.com.zup.bootcamp.gateway;

import br.com.zup.bootcamp.entity.Proposal;

public interface ProposalDocumentAllReadyPersistedGateway {

    Boolean execute(Proposal proposal);
}
