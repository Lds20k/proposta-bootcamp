package br.com.zup.bootcamp.enumerate;

public enum Eligibility {
    PENDENTE("PENDENTE"),
    ELEGIVEL("ELEGIVEL"),
    NAO_ELEGIVEL("NAO_ELEGIVEL"),
    ELEITO("ELEITO"),
    BLOQUEADO("BLOQUEADO"),
    INDEFINIDO("INDEFINIDO");

    Eligibility(String restriction) {
    }
}
