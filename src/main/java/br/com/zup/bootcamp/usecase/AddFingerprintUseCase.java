package br.com.zup.bootcamp.usecase;

import br.com.zup.bootcamp.entity.Fingerprint;
import br.com.zup.bootcamp.gateway.PersistFingerprintGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Carga intrínseca = 2/9
@Service
public class AddFingerprintUseCase {

    @Autowired
    private PersistFingerprintGateway persistFingerPrintGateway;

    /**
     * Persiste uma impressão digital
     * @param fingerprintToProcess Objeto que representa a impressão digital
     * @return Objeto que representa a impressão digital que foi persistida
     */
    public Fingerprint execute(Fingerprint fingerprintToProcess){
        Fingerprint fingerprint = persistFingerPrintGateway.execute(fingerprintToProcess);
        return fingerprint;
    }
}
