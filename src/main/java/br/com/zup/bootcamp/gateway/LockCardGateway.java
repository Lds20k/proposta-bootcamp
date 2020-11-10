package br.com.zup.bootcamp.gateway;

import br.com.zup.bootcamp.entity.LockedCard;
import br.com.zup.bootcamp.entity.Proposal;

public interface LockCardGateway {

    /**
     * Persiste um bloqueio de um cartão
     * @param cardToLock Objeto que representa o cartão bloqueado á ser persistido
     * @return Objeto que representa o cartão bloqueado que foi persistido
     */
    LockedCard execute(LockedCard cardToLock);
}
