package br.com.zup.bootcamp.gateway.database.model;

import br.com.zup.bootcamp.entity.Fingerprint;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

// Carga intrínseca = 2/7
@Entity
@Table(name = "fingerprint")
public class FingerprintDBDomain {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @NotBlank
    @Column(nullable = false, length = 10000)
    private String fingerprintBase64;

    @NotNull
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private ProposalDBDomain proposal;

    @Deprecated
    public FingerprintDBDomain() {
    }

    public FingerprintDBDomain(String id, @NotBlank String fingerprintBase64, @NotNull ProposalDBDomain proposal) {
        this.id = id;
        this.fingerprintBase64 = fingerprintBase64;
        this.proposal = proposal;
    }

    public Fingerprint toEntity() {
        return new Fingerprint(this.id, this.fingerprintBase64, this.proposal.toEntity());
    }
}
