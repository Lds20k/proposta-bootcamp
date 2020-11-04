package br.com.zup.bootcamp.gateway;

import br.com.zup.bootcamp.entity.Proposal;

import java.util.Optional;

public interface ConsultProposalGateway {

    /**
     * Busca uma proposta persistida pela id
     * @param id String do UUID da proposta
     * @return Objeto que representa a proposta persistida
     */
    Optional<Proposal> execute(String id);
}
