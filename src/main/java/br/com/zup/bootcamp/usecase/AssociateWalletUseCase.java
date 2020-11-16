package br.com.zup.bootcamp.usecase;

import br.com.zup.bootcamp.entity.Wallet;
import br.com.zup.bootcamp.gateway.PersistWalletGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Carga intrínseca = 2/7
@Service
public class AssociateWalletUseCase {

    @Autowired
    private PersistWalletGateway persistWalletGateway;

    /**
     * Associa uma proposta a uma companhia/carteira
     * @param walletToProcess Objeto que representa a carteira a ser processada
     * @return Objeto que representa a carteira já processada
     */
    public Wallet execute(Wallet walletToProcess) {
        return persistWalletGateway.execute(walletToProcess);
    }
}
