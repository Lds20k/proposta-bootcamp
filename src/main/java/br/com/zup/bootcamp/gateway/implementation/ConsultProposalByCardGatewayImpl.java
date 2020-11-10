package br.com.zup.bootcamp.gateway.implementation;

import br.com.zup.bootcamp.entity.Proposal;
import br.com.zup.bootcamp.gateway.ConsultProposalByCardGateway;
import br.com.zup.bootcamp.gateway.database.model.ProposalDBDomain;
import br.com.zup.bootcamp.gateway.database.repository.ProposalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

// Carga intrínseca = 4/7
@Service
public class ConsultProposalByCardGatewayImpl implements ConsultProposalByCardGateway {

    @Autowired
    private ProposalRepository proposalRepository;

    /**
     * Busca uma proposta persistida pela id
     * @param card String do identificador do cartão associado a proposta
     * @return Objeto que representa a proposta persistida
     */
    @Override
    public Optional<Proposal> execute(String card) {
        Optional<ProposalDBDomain> proposalDBDomain = proposalRepository.findByCard(card);
        if(proposalDBDomain.isEmpty()) return Optional.empty();
        return Optional.of(proposalDBDomain.get().toEntity());
    }
}
