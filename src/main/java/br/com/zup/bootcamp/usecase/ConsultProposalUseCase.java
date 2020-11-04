package br.com.zup.bootcamp.usecase;

import br.com.zup.bootcamp.entity.Proposal;
import br.com.zup.bootcamp.gateway.ConsultProposalGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

// Carga intrínseca = 2/7
@Service
public class ConsultProposalUseCase {

    @Autowired
    private ConsultProposalGateway consultProposalGateway;

    /**
     * Busca uma proposta persistida pela id
     * @param id String do UUID da proposta
     * @return Objeto que representa a proposta persistida
     */
    public Optional<Proposal> execute(String id){
        return consultProposalGateway.execute(id);
    }
}
