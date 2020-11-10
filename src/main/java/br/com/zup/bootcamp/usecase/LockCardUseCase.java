package br.com.zup.bootcamp.usecase;

import br.com.zup.bootcamp.entity.LockedCard;
import br.com.zup.bootcamp.gateway.LockCardGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LockCardUseCase {

    @Autowired
    private LockCardGateway lockCardGateway;

    /**
     * Bloqueia um cartão
     * @param cardToLock Objeto que representa o cartão á ser bloqueado
     * @return Objeto que representa o cartão bloqueado que foi persistido
     */
    public LockedCard execute(LockedCard cardToLock){
        return lockCardGateway.execute(cardToLock);
    }
}
