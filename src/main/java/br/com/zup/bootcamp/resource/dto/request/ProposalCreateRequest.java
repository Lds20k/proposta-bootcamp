package br.com.zup.bootcamp.resource.dto.request;

import br.com.zup.bootcamp.entity.Proposal;
import br.com.zup.bootcamp.resource.validator.annotation.CPFOrCNPJ;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

// Carga intrínseca = 1/7
public class ProposalCreateRequest {

    @NotBlank
    @CPFOrCNPJ
    private final String document;

    @NotBlank
    private final String email;

    @NotBlank
    private final String name;

    @NotBlank
    private final String address;

    @NotNull
    @Positive
    private final BigDecimal salary;

    public ProposalCreateRequest(@NotBlank @CPF @CNPJ String document, @NotBlank String email, @NotBlank String name, @NotBlank String address, @NotNull @Positive BigDecimal salary) {
        this.document = document;
        this.email = email;
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    public String getDocument() {
        return document;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public Proposal toModel() {
        return new Proposal(this.document, this.email, this.name, this.address, this.salary);
    }
}
