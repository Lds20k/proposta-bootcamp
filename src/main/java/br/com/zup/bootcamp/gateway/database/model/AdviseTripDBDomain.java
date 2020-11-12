package br.com.zup.bootcamp.gateway.database.model;

import br.com.zup.bootcamp.entity.AdviseTrip;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

// Carga intrínseca = 1/7
@Entity
@Table(name = "advise_trip")
public class AdviseTripDBDomain {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @NotBlank
    @Column(nullable = false)
    private String card;

    @NotBlank
    @Column(nullable = false)
    private String destiny;

    @NotNull
    @Column(nullable = false)
    private LocalDate ending;

    @NotNull
    @Column(nullable = false)
    private LocalDate saveDate;

    @NotBlank
    @Column(nullable = false, updatable = false)
    private String ip;

    @NotBlank
    @Column(nullable = false, updatable = false)
    private String userAgent;

    @NotNull
    @ManyToOne
    @JoinColumn(nullable = false, updatable = false, referencedColumnName = "id")
    private ProposalDBDomain proposal;

    @Deprecated
    public AdviseTripDBDomain() {
    }

    public AdviseTripDBDomain(String card, String destiny, LocalDate ending, String ip, String userAgent, ProposalDBDomain proposal) {
        this.card = card;
        this.destiny = destiny;
        this.ending = ending;
        this.ip = ip;
        this.userAgent = userAgent;
        this.proposal = proposal;
        this.saveDate = LocalDate.now();
    }

    public AdviseTrip toEntity() {
        return new AdviseTrip(
                this.id,
                this.card,
                this.destiny,
                this.ending,
                this.saveDate,
                this.ip,
                this.userAgent,
                this.proposal.toEntity()
        );
    }
}
