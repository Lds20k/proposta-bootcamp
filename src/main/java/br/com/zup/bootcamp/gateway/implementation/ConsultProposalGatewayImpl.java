package br.com.zup.bootcamp.gateway.implementation;

import br.com.zup.bootcamp.entity.Proposal;
import br.com.zup.bootcamp.gateway.ConsultProposalGateway;
import br.com.zup.bootcamp.gateway.database.model.ProposalDBDomain;
import br.com.zup.bootcamp.gateway.database.repository.ProposalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

// Carga intrínseca = 4/7
@Service
public class ConsultProposalGatewayImpl implements ConsultProposalGateway {

    @Autowired
    private ProposalRepository proposalRepository;

    /**
     * Busca uma proposta persistida pela id
     * @param id String do UUID da proposta
     * @return Objeto que representa a proposta persistida
     */
    @Override
    public Optional<Proposal> execute(String id) {
        Optional<ProposalDBDomain> proposalDBDomain = proposalRepository.findById(id);
        if (proposalDBDomain.isEmpty()) return Optional.empty();
        return Optional.of(proposalDBDomain.get().toEntity());
    }
}
