package br.com.zup.bootcamp.gateway.database.model;

import br.com.zup.bootcamp.entity.Proposal;
import br.com.zup.bootcamp.enumerate.Eligibility;
import br.com.zup.bootcamp.resource.validator.annotation.CPFOrCNPJ;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

// Carga intrínseca = 1/7
@Entity
@Table(name = "proposal")
public class ProposalDBDomain {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @NotBlank
    @CPFOrCNPJ
    @Column(nullable = false, unique = true)
    private String document;

    @NotBlank
    @Email
    @Column(nullable = false)
    private String email;

    @NotBlank
    @Column(nullable = false)
    private String name;

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

    @Deprecated
    public ProposalDBDomain() {
    }

    public ProposalDBDomain(@NotBlank String document, @NotBlank @Email String email, @NotBlank String name, @NotBlank String address, @NotNull @Positive BigDecimal salary, @NotBlank Eligibility eligibility) {
        this.document = document;
        this.email = email;
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.eligibility = eligibility;
    }

    public ProposalDBDomain(String id, @NotBlank String document, @NotBlank @Email String email, @NotBlank String name, @NotBlank String address, @NotNull @Positive BigDecimal salary, @NotBlank Eligibility eligibility) {
        this.id = id;
        this.document = document;
        this.email = email;
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.eligibility = eligibility;
    }

    public ProposalDBDomain(String id, @NotBlank String document, @NotBlank @Email String email, @NotBlank String name, @NotBlank String address, @NotNull @Positive BigDecimal salary, Eligibility eligibility, String card) {
        this.id = id;
        this.document = document;
        this.email = email;
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.eligibility = eligibility;
        this.card = card;
    }

    public Proposal toEntity() {
        return new Proposal(this.id, this.document, this.email, this.name, this.address, this.salary, this.eligibility);
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

    @Override
    public String toString() {
        return "ProposalDBDomain{" +
                "id='" + id + '\'' +
                '}';
    }
}
