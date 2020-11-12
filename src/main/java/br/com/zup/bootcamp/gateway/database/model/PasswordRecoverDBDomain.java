package br.com.zup.bootcamp.gateway.database.model;

import br.com.zup.bootcamp.entity.PasswordRecover;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "password_recover")
public class PasswordRecoverDBDomain {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(nullable = false)
    private LocalDateTime date;

    @NotBlank
    @Column(nullable = false)
    private String ip;

    @NotBlank
    @Column(nullable = false)
    private String userAgent;

    @NotNull
    @ManyToOne
    @JoinColumn(nullable = false, updatable = false, referencedColumnName = "id")
    private ProposalDBDomain proposal;

    @Deprecated
    public PasswordRecoverDBDomain() {
    }

    public PasswordRecoverDBDomain(String ip, String userAgent, ProposalDBDomain proposal) {
        this.id = null;
        this.date = LocalDateTime.now();
        this.ip = ip;
        this.userAgent = userAgent;
        this.proposal = proposal;
    }

    public PasswordRecover toEntity() {
        return new PasswordRecover(this.id, this.date, this.ip, this.userAgent, this.proposal.toEntity());
    }
}
