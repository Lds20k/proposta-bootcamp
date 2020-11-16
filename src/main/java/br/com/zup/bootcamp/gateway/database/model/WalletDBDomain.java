package br.com.zup.bootcamp.gateway.database.model;

import br.com.zup.bootcamp.client.response.AssociateWalletResponse;
import br.com.zup.bootcamp.entity.Wallet;
import br.com.zup.bootcamp.enumerate.CompanyEnumerate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "wallet")
public class WalletDBDomain {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @NotBlank
    @Column(nullable = false, updatable = false, unique = true)
    private String externalId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CompanyEnumerate company;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String card;

    @OneToOne
    @JoinColumn(nullable = false, updatable = false, referencedColumnName = "id")
    private ProposalDBDomain proposal;

    @Deprecated
    public WalletDBDomain() {
    }

    public WalletDBDomain(CompanyEnumerate company, @NotBlank String card, ProposalDBDomain proposal) {
        this.company = company;
        this.card = card;
        this.proposal = proposal;
    }

    public WalletDBDomain(String id, @NotBlank String externalId, CompanyEnumerate company, @NotBlank String card, ProposalDBDomain proposal) {
        this.id = id;
        this.externalId = externalId;
        this.company = company;
        this.card = card;
        this.proposal = proposal;
    }

    public WalletDBDomain(Wallet walletToProcess, AssociateWalletResponse walletResponse) {
        this.id = null;
        this.company = walletToProcess.getCompany();
        this.card = walletToProcess.getCard();
        this.externalId = walletResponse.getId();
        this.proposal = new ProposalDBDomain(walletToProcess.getProposal());
    }


    public Wallet toEntity() {
        return new Wallet(this.id, this.company, this.card, this.proposal.toEntity());
    }
}
