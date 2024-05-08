package org.perscholas.casestudy.formbean;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class RegisterUserFormBean {
    private Integer id;

    @Email(message = "Please enter a valid email address")
    @NotEmpty(message = "Please enter an email address")
    private String email;

    @NotEmpty(message = "Please enter your first name")
    private String firstName;

    @NotEmpty(message = "Please enter your last name")
    private String lastName;

    @NotEmpty(message = "Please enter your city")
    private String city;

    @NotEmpty(message = "Please enter your state")
    private String state;

    @NotEmpty(message = "Please enter your address")
    private String address;

    @Pattern(regexp = "^\\d{5}(?:[-\\s]\\d{4})?$",
            message = "Please enter a valid zip code")
    private String zipCode;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$",
            message = "Password must be at least 8 characters long, contain at least one uppercase letter, " +
                    "one lowercase letter, one number, and one special character")
    private String password;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$",
            message = "Password must be at least 8 characters long, contain at least one uppercase letter, " +
                    "one lowercase letter, one number, and one special character")
    private String confirmPassword;
}
