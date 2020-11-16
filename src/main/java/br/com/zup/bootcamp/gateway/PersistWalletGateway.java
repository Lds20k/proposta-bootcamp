package br.com.zup.bootcamp.gateway;

import br.com.zup.bootcamp.entity.Wallet;

public interface PersistWalletGateway {

    /**
     * Persiste uma carteira associada a uma proposta
     * @param walletToProcess Objeto que representa a carteira a se persistida
     * @return Objeto que representa a carteira que foi persistida
     */
    Wallet execute(Wallet walletToProcess);
}
