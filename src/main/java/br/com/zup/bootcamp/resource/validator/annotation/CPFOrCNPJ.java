package br.com.zup.bootcamp.resource.validator.annotation;

import br.com.zup.bootcamp.resource.validator.CPFOrCNPJValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * O valor do elemento anotado precisa estar estritamente no formato de CPF ou CNPJ
 * <p>
 *     Tipos suportados
 * </p>
 * <ul>
 *     <li>{@code String}</li>
 * </ul>
 * Elementos {@code null} são considerados validos
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CPFOrCNPJValidator.class)
public @interface CPFOrCNPJ {
    String message() default "br.com.zup.bootcamp.resource.validator.annotation.CPFOrCNPJ";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
