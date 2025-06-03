package ra.mvc.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailUniqueValidator implements ConstraintValidator<EmailUnique, String > {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        // viết logic kiểm tra email có duy nhất hay không
        return false;
    }
}
