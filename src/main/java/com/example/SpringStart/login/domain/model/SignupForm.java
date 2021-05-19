package com.example.SpringStart.login.domain.model;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

import javax.validation.constraints.*;

@Data
public class SignupForm {

    @NotBlank(groups = ValidGroup1.class)
    @Email(groups = ValidGroup2.class)
    private String userId;

    @NotBlank(groups = ValidGroup1.class)
    @Length(min = 4, max = 8, groups = ValidGroup2.class)
    @Pattern(regexp = "^[a-zA-z0-9]+$", groups = ValidGroup3.class)
    private String password;

    @NotBlank(groups = ValidGroup1.class)
    private String userName;

    @NotNull(groups = ValidGroup1.class)
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date birthday;

    @NotNull(groups = ValidGroup1.class)
    @Min(value = 18, groups = ValidGroup2.class)
    @Max(value = 100, groups = ValidGroup3.class)
    private int age;

    @AssertFalse(groups = ValidGroup1.class)
    private boolean marriage;
}
