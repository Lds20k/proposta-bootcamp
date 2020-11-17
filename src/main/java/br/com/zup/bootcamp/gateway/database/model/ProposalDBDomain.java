package br.com.zup.bootcamp.gateway.database.model;

import br.com.zup.bootcamp.entity.Proposal;
import br.com.zup.bootcamp.enumerate.Eligibility;
import br.com.zup.bootcamp.resource.validator.annotation.CPFOrCNPJ;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

// Carga intrínseca = 3/7
@Entity
@Table(name = "proposal")
public class ProposalDBDomain {

    @Id
    private String id;

    @NotBlank
    @Column(nullable = false, unique = true, updatable = false)
    private String document;

    @NotBlank
    @Column(nullable = false, unique = true, updatable = false)
    private String hashDocument;

    private transient String email;

    private transient String name;

    @NotBlank
    @Column(nullable = false)
    private String address;

    @NotNull
    @Positive
    @Column(nullable = false)
    private BigDecimal salary;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Eligibility eligibility;

    @Column(unique = true)
    private String card;

    @OneToMany(mappedBy = "proposal", cascade = CascadeType.ALL)
    private Collection<FingerprintDBDomain> fingerprints = new ArrayList<>();

    @OneToOne(mappedBy = "proposal", cascade = CascadeType.ALL)
    private LockedCardDBDomain lockedCard;

    @OneToMany(mappedBy = "proposal", cascade = CascadeType.ALL)
    private Collection<PasswordRecoverDBDomain> passwordRecover = new HashSet<>();

    @OneToMany(mappedBy = "proposal", cascade = CascadeType.ALL)
    private Collection<AdviseTripDBDomain> adviseTrip = new HashSet<>();

    @OneToOne(mappedBy = "proposal", cascade = CascadeType.ALL)
    private WalletDBDomain wallet;

    @Deprecated
    public ProposalDBDomain() {
    }

    public ProposalDBDomain(String id) {
        this.id = id;
    }

    public ProposalDBDomain(String id, @NotBlank String document, @NotBlank String hashDocument, @NotBlank @Email String email, String name, String address, @NotNull @Positive BigDecimal salary, @NotBlank Eligibility eligibility) {
        this.id = id;
        this.document = document;
        this.hashDocument = hashDocument;
        this.email = email;
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.eligibility = eligibility;
    }

    public ProposalDBDomain(Proposal proposal) {
        this.id = proposal.getId();
        this.document = proposal.getDocument();
        this.email = proposal.getEmail();
        this.name = proposal.getName();
        this.address = proposal.getAddress();
        this.salary = proposal.getSalary();
        this.eligibility = proposal.getEligibility();
        this.card = proposal.getCard();
    }

    public Proposal toEntity() {
        return new Proposal(
                this.id,
                this.document,
                this.email,
                this.name,
                this.address,
                this.salary,
                this.eligibility,
                this.card
        );
    }

    public String getId() {
        return id;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public void setEligibility(Eligibility eligibility) {
        this.eligibility = eligibility;
    }

    public void addFingerPrint(FingerprintDBDomain fingerPrint){
        this.fingerprints.add(fingerPrint);
    }

    public void setLockedCard(LockedCardDBDomain lockedCard) {
        this.lockedCard = lockedCard;
    }

    @Override
    public String toString() {
        return "ProposalDBDomain{" +
                "id='" + id + '\'' +
                '}';
    }

    public void addRecoverPassword(PasswordRecoverDBDomain passwordRecover) {
        this.passwordRecover.add(passwordRecover);
    }

    public void addAdviseTrip(AdviseTripDBDomain adviseTripDBDomain) {
        this.adviseTrip.add(adviseTripDBDomain);
    }
}
