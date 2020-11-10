package br.com.zup.bootcamp.gateway.database.model;

import br.com.zup.bootcamp.entity.LockedCard;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "locked_card")
public class LockedCardDBDomain {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(nullable = false, unique = true, updatable = false)
    private String card;

    @Column(nullable = false, updatable = false)
    private String clientIp;

    @Column(nullable = false, updatable = false)
    private String userAgent;

    @Column(nullable = false, updatable = false)
    private LocalDateTime date;

    @OneToOne
    @JoinColumn(nullable = false, updatable = false, unique = true)
    private ProposalDBDomain proposal;

    @Deprecated
    public LockedCardDBDomain() {
    }

    public LockedCardDBDomain(String card, String clientIp, String userAgent, ProposalDBDomain proposal) {
        this.card = card;
        this.clientIp = clientIp;
        this.userAgent = userAgent;
        this.date = LocalDateTime.now();
        this.proposal = proposal;
    }

    public LockedCard toEntity() {
        return new LockedCard(this.id, this.card, this.clientIp, this.userAgent, this.date, proposal.toEntity());
    }
}
