package ra.mvc.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ra.mvc.model.FormRequest;
@Component
public class FormRequestValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        // Specify the class type that this validator supports
        return clazz.isAssignableFrom(FormRequest.class); // Replace with actual class check
    }

    @Override
    public void validate(Object target, Errors errors) {
        // Implement validation logic here
        // Use errors.rejectValue() to report validation errors
        FormRequest request = (FormRequest) target;

        if (request.getName().trim().isEmpty()){
            errors.rejectValue("name","name.emtpy");
        }
    }
}
