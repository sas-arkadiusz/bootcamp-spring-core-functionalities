package pl.arkadiusz.applicationtransporeon.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PostalCodeValidator.class)
@Documented
public @interface PostalCode {

    String message() default "Address has to be valid.";

    String format() default "\\d{5}(-\\d{4})?";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}