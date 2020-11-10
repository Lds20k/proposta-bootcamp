package br.com.zup.bootcamp.gateway.implementation;

import br.com.zup.bootcamp.entity.LockedCard;
import br.com.zup.bootcamp.gateway.ConsultLockCardGateway;
import br.com.zup.bootcamp.gateway.database.model.LockedCardDBDomain;
import br.com.zup.bootcamp.gateway.database.repository.LockedCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConsultLockCardGatewayImpl implements ConsultLockCardGateway {

    @Autowired
    private LockedCardRepository lockedCardRepository;


    /**
     * Busca um cartão bloqueado persistido
     * @param card String do identificador do cartão associado a proposta
     * @return Objeto que representa o cartão bloqueado
     */
    @Override
    public Optional<LockedCard> execute(String card) {
        Optional<LockedCardDBDomain> lockedCardDBDomain = lockedCardRepository.findByCard(card);
        if(lockedCardDBDomain.isEmpty()) return Optional.empty();
        return Optional.of(lockedCardDBDomain.get().toEntity());
    }
}
