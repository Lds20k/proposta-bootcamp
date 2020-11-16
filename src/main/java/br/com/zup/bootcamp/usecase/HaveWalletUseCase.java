package br.com.zup.bootcamp.usecase;

import br.com.zup.bootcamp.entity.Proposal;
import br.com.zup.bootcamp.gateway.ConsultWalletByProposalGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Carga intrínseca = 2/7
@Service
public class HaveWalletUseCase {

    @Autowired
    private ConsultWalletByProposalGateway consultWalletByProposalGateway;

    /**
     * Verifica se uma proposta já esta associada a uma companhia/carteira
     * @param proposal Objeto que representa a proposta
     * @return True caso a proposta já esteja associada a uma companhia/carteira
     */
    public boolean execute(Proposal proposal) {
        return consultWalletByProposalGateway.execute(proposal).isPresent();
    }
}
