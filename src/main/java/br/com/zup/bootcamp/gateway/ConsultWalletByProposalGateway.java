package br.com.zup.bootcamp.gateway;

import br.com.zup.bootcamp.entity.Proposal;
import br.com.zup.bootcamp.entity.Wallet;

import java.util.Optional;

public interface ConsultWalletByProposalGateway {

    /**
     * Consulta uma carteira que já esteja persistida, procurando pela campo proposta
     * @param proposal Objeto que representa a proposta que sera usada na pesquisa
     * @return Objeto que representa a carteira
     */
    Optional<Wallet> execute(Proposal proposal);
}
