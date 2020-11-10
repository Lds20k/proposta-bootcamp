package br.com.zup.bootcamp.usecase;

import br.com.zup.bootcamp.entity.Proposal;
import br.com.zup.bootcamp.gateway.ConsultProposalByCardGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConsultProposalByCardUseCase {

    @Autowired
    private ConsultProposalByCardGateway consultProposalByCardGateway;

    /**
     * Busca uma proposta persistida pelo cartão
     * @param card String do identificador do cartão associado a proposta
     * @return Objeto que representa a proposta persistida
     */
    public Optional<Proposal> execute(String card){
        return consultProposalByCardGateway.execute(card);
    }
}
