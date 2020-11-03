package br.com.zup.bootcamp.entity;

import br.com.zup.bootcamp.enumerate.Eligibility;
import br.com.zup.bootcamp.resource.validator.annotation.CPFOrCNPJ;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

// Carga intrínseca = 0/7
public class Proposal {

    private final String id;

    @NotBlank
    @CPFOrCNPJ
    private final String document;

    @NotBlank
    @Email
    private final String email;

    @NotBlank
    private final String name;

    @NotBlank
    private final String address;

    @NotNull
    @Positive
    private final BigDecimal salary;

    @NotBlank
    private final Eligibility eligibility;

    public Proposal(@NotBlank String document, @NotBlank @Email String email, @NotBlank String name, @NotBlank String address, @NotNull @Positive BigDecimal salary) {
        this.id = null;
        this.document = document;
        this.email = email;
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.eligibility = Eligibility.PENDENTE;
    }

    public Proposal(String id, @NotBlank String document, @NotBlank @Email String email, @NotBlank String name, @NotBlank String address, @NotNull @Positive BigDecimal salary, @NotBlank Eligibility eligibility) {
        this.id = id;
        this.document = document;
        this.email = email;
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.eligibility = eligibility;
    }

    public String getId() {
        return id;
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

    public Eligibility getEligibility() {
        return eligibility;
    }
}
