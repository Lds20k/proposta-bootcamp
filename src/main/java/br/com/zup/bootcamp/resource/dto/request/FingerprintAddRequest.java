package br.com.zup.bootcamp.resource.dto.request;

import br.com.zup.bootcamp.entity.Fingerprint;
import br.com.zup.bootcamp.entity.Proposal;
import br.com.zup.bootcamp.resource.validator.annotation.StringInBase64;

import javax.validation.constraints.NotBlank;

// Carga intrínseca = 1/7
public class FingerprintAddRequest {

    @NotBlank
    @StringInBase64
    private String fingerprintBase64;

    public String getFingerprintBase64() {
        return fingerprintBase64;
    }

    public void setFingerprintBase64(String fingerprintBase64) {
        this.fingerprintBase64 = fingerprintBase64;
    }

    public Fingerprint toEntity(Proposal proposal) {
        return new Fingerprint(this.fingerprintBase64, proposal);
    }
}
