package br.com.zup.bootcamp.gateway;

import br.com.zup.bootcamp.entity.Proposal;

import java.util.Optional;

public interface ConsultProposalByCardGateway {

    /**
     * Busca uma proposta persistida pela id
     * @param card String do identificador do cartão associado a proposta
     * @return Objeto que representa a proposta persistida
     */
    Optional<Proposal> execute(String card);
}
