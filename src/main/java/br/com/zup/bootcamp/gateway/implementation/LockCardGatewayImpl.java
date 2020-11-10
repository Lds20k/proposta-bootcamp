package br.com.zup.bootcamp.gateway.implementation;

import br.com.zup.bootcamp.entity.LockedCard;
import br.com.zup.bootcamp.gateway.LockCardGateway;
import br.com.zup.bootcamp.gateway.database.model.LockedCardDBDomain;
import br.com.zup.bootcamp.gateway.database.model.ProposalDBDomain;
import br.com.zup.bootcamp.gateway.database.repository.LockedCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LockCardGatewayImpl implements LockCardGateway {

    @Autowired
    private LockedCardRepository lockedCardRepository;

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

        lockedCardRepository.save(lockedCardDBDomain);
        return lockedCardDBDomain.toEntity();
    }
}
