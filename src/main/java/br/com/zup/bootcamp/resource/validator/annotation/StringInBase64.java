package br.com.zup.bootcamp.resource.validator.annotation;

import br.com.zup.bootcamp.resource.validator.StringInBase64Validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * O valor do elemento precisa estar estritamente em Base64
 * <p>
 *     Tipos suportados
 * </p>
 * <ul>
 *     <li>{@code String}</li>
 * </ul>
 * Elementos com valor {@code null} são considerados validos
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StringInBase64Validator.class)
public @interface StringInBase64 {
    String message() default "br.com.zup.bootcamp.resource.validator.annotation.StringInBase64";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default  {};
}
