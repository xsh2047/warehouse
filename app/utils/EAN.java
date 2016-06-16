package utils;

import play.data.validation.Constraints;
import play.libs.F;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by zabieru on 6/1/2016.
 */
@Constraint(validatedBy = EanValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EAN {
    String message() default "error.invalid.ean";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

