package br.com.zup.bootcamp.resource.validator;

import br.com.zup.bootcamp.resource.validator.annotation.CPFOrCNPJ;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CPFOrCNPJValidator implements ConstraintValidator<CPFOrCNPJ, String> {

    @Override
    public void initialize(CPFOrCNPJ constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null) return true;

        CPFValidator cpfValidator = new CPFValidator();
        cpfValidator.initialize(null);

        CNPJValidator cnpjValidator = new CNPJValidator();
        cnpjValidator.initialize(null);

        return cpfValidator.isValid(value, context) || cnpjValidator.isValid(value, context);
    }
}
