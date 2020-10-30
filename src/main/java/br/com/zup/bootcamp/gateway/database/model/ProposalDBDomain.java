package br.com.zup.bootcamp.gateway.database.model;

import br.com.zup.bootcamp.entity.Proposal;
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

    @Deprecated
    public ProposalDBDomain() {
    }

    public ProposalDBDomain(@NotBlank String document, @NotBlank @Email String email, @NotBlank String name, @NotBlank String address, @NotNull @Positive BigDecimal salary) {
        this.document = document;
        this.email = email;
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    public ProposalDBDomain(String id, @NotBlank String document, @NotBlank @Email String email, @NotBlank String name, @NotBlank String address, @NotNull @Positive BigDecimal salary) {
        this.id = id;
        this.document = document;
        this.email = email;
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    public Proposal toEntity() {
        return new Proposal(this.id, this.document, this.email, this.name, this.address, this.salary);
    }
}
