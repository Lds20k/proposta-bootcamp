package br.com.zup.bootcamp.gateway;

import br.com.zup.bootcamp.entity.Proposal;

public interface ProposalDocumentAlreadyPersistedGateway {

    Boolean execute(Proposal proposal);
}
