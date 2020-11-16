package br.com.zup.bootcamp.gateway.implementation;

import br.com.zup.bootcamp.entity.Proposal;
import br.com.zup.bootcamp.entity.Wallet;
import br.com.zup.bootcamp.gateway.ConsultWalletByProposalGateway;
import br.com.zup.bootcamp.gateway.database.model.ProposalDBDomain;
import br.com.zup.bootcamp.gateway.database.model.WalletDBDomain;
import br.com.zup.bootcamp.gateway.database.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

// Carga intrínseca = 6/7
@Service
public class ConsultWalletByProposalGatewayImpl implements ConsultWalletByProposalGateway {

    @Autowired
    private WalletRepository walletRepository;

    /**
     * Consulta uma carteira que já esteja persistida, procurando pela campo proposta
     * @param proposal Objeto que representa a proposta que sera usada na pesquisa
     * @return Objeto que representa a carteira
     */
    @Override
    public Optional<Wallet> execute(Proposal proposal) {
        ProposalDBDomain proposalDBDomain = new ProposalDBDomain(proposal);
        Optional<WalletDBDomain> walletDBDomain = walletRepository.findByProposal(proposalDBDomain);
        if(walletDBDomain.isEmpty())
            return Optional.empty();
        return Optional.of(walletDBDomain.get().toEntity());
    }
}
