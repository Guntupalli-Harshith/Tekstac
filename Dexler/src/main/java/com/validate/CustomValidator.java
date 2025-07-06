package com.validate;

import com.model.Admission;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CustomValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Admission.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Admission admission = (Admission) target;

        // Validate child name (only alphabets and space, min 2 characters)
        if (admission.getChildName() != null && !admission.getChildName().matches("^[A-Za-z ]{2,}$")) {
            errors.rejectValue("childName", "invalid.childName", "Name should contain only alphabets and spaces with a minimum of 2 characters");
        }

        // Validate contact number
        if (admission.getContactNumber() != null && !admission.getContactNumber().matches("^[6-9]\\d{9}$")) {
            errors.rejectValue("contactNumber", "invalid.contactNumber", "Contact Number should be of 10 digits and start with a number between 6 and 9");
        }
    }
}