package br.com.zup.bootcamp.resource.validator;

import br.com.zup.bootcamp.resource.validator.annotation.StringInBase64;
import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.util.Strings;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StringInBase64Validator implements ConstraintValidator<StringInBase64, String> {

    @Override
    public void initialize(StringInBase64 constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(Strings.isBlank(value)) return true;
        return Base64.isBase64(value);
    }
}
