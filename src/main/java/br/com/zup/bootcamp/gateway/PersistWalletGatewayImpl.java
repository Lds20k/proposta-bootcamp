package br.com.zup.bootcamp.gateway;

import br.com.zup.bootcamp.client.CardClient;
import br.com.zup.bootcamp.client.response.AssociateWalletResponse;
import br.com.zup.bootcamp.entity.Wallet;
import br.com.zup.bootcamp.gateway.database.model.WalletDBDomain;
import br.com.zup.bootcamp.gateway.database.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

// Carga intrínseca = 5/7
@Service
public class PersistWalletGatewayImpl implements PersistWalletGateway {

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private CardClient cardClient;

    /**
     * Persiste uma carteira associada a uma proposta
     * @param walletToProcess Objeto que representa a carteira a se persistida
     * @return Objeto que representa a carteira que foi persistida
     */
    @Override
    public Wallet execute(Wallet walletToProcess) {
        Map<String, String> request = new HashMap<>();
        request.put("email", walletToProcess.getProposal().getEmail());
        request.put("carteira", walletToProcess.getCompanyString());
        ResponseEntity<AssociateWalletResponse> response = cardClient.associateWallet(
                walletToProcess.getCard(),
                request
        );

        WalletDBDomain walletDBDomain = new WalletDBDomain(walletToProcess, response.getBody());
        return walletRepository.save(walletDBDomain).toEntity();
    }
}
