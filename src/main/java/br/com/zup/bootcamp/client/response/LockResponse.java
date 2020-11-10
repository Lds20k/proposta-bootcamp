package br.com.zup.bootcamp.client.response;

import br.com.zup.bootcamp.enumerate.Eligibility;

// Carga intrínseca = 2/7
public class LockResponse {
    private String resultado;

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Eligibility toEligibility() {
        if(this.resultado.equals("BLOQUEADO")) return Eligibility.BLOQUEADO;
        return Eligibility.INDEFINIDO;
    }
}
