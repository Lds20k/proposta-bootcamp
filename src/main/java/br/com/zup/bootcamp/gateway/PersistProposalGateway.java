package br.com.zup.bootcamp.gateway;

import br.com.zup.bootcamp.entity.Proposal;

public interface PersistProposalGateway {

    /**
     * Persiste um Objeto do tipo proposta
     * @param proposal Objeto que representa a proposta a ser persistida
     * @return Objeto que representa a proposta que foi persistida
     */
    Proposal execute(Proposal proposal);

}
