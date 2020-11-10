package br.com.zup.bootcamp.gateway.implementation;

import br.com.zup.bootcamp.client.CardClient;
import br.com.zup.bootcamp.client.response.LockResponse;
import br.com.zup.bootcamp.entity.LockedCard;
import br.com.zup.bootcamp.gateway.LockCardGateway;
import br.com.zup.bootcamp.gateway.database.model.LockedCardDBDomain;
import br.com.zup.bootcamp.gateway.database.model.ProposalDBDomain;
import br.com.zup.bootcamp.gateway.database.repository.ProposalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

// Carga intrínseca = 5/7
@Service
public class LockCardGatewayImpl implements LockCardGateway {

    @Autowired
    private ProposalRepository proposalRepository;

    @Autowired
    private CardClient cardClient;

    /**
     * Persiste um bloqueio de um cartão
     * @param cardToLock Objeto que representa o cartão bloqueado á ser persistido
     * @return Objeto que representa o cartão bloqueado que foi persistido
     */
    @Override
    public LockedCard execute(LockedCard cardToLock) {
        ProposalDBDomain proposalDBDomain = new ProposalDBDomain(cardToLock.getProposal());
        LockedCardDBDomain lockedCardDBDomain = new LockedCardDBDomain(
                cardToLock.getCard(),
                cardToLock.getClientIp(),
                cardToLock.getUserAgent(),
                proposalDBDomain
        );
        proposalDBDomain.setLockedCard(lockedCardDBDomain);

        Map<String, String> request = new HashMap<>();
        request.put("sistemaResponsavel", "proposta");

        ResponseEntity<LockResponse> response = cardClient.lockCard(cardToLock.getCard(), request);
        proposalDBDomain.setEligibility(response.getBody().toEligibility());
        proposalRepository.save(proposalDBDomain);

        return lockedCardDBDomain.toEntity();
    }
}
