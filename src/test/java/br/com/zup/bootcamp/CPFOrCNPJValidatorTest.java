package br.com.zup.bootcamp;

import br.com.zup.bootcamp.resource.validator.CPFOrCNPJValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CPFOrCNPJValidatorTest {

    @Test
    @DisplayName("Deve recusar um CPF ou CNPJ invalido")
    void invalidCPFOrCNPJ(){
        CPFOrCNPJValidator validator = new CPFOrCNPJValidator();
        Boolean valid = validator.isValid("", null);
        assertFalse(valid);
    }

    @Test
    @DisplayName("Dever aceitar um CPF valido")
    void validCPF(){
        CPFOrCNPJValidator validator = new CPFOrCNPJValidator();
        Boolean valid = validator.isValid("068.230.990-70", null);
        assertTrue(valid);
    }

    @Test
    @DisplayName("Dever aceitar um CNPJ valido")
    void validCNPJ(){
        CPFOrCNPJValidator validator = new CPFOrCNPJValidator();
        Boolean valid = validator.isValid("47.302.140/0001-88", null);
        assertTrue(valid);
    }


}
