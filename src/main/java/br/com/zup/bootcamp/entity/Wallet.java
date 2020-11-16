package br.com.zup.bootcamp.entity;

import br.com.zup.bootcamp.enumerate.CompanyEnumerate;

public class Wallet {

    private final String id;

    private final CompanyEnumerate company;

    private final String card;

    private final Proposal proposal;

    public Wallet(String company, String card, Proposal proposal) {
        this.id = "";
        this.company = CompanyEnumerate.define(company);
        this.card = card;
        this.proposal = proposal;
    }

    public Wallet(String id, CompanyEnumerate company, String card, Proposal proposal) {
        this.id = id;
        this.company = company;
        this.card = card;
        this.proposal = proposal;
    }

    public String getId() {
        return id;
    }

    public CompanyEnumerate getCompany() {
        return company;
    }

    public String getCard() {
        return card;
    }

    public Proposal getProposal() {
        return proposal;
    }

    public boolean companyIsNone() {
        return company.equals(CompanyEnumerate.NONE);
    }

    public String getCompanyString() {
        return this.company.toString().toLowerCase();
    }
}
