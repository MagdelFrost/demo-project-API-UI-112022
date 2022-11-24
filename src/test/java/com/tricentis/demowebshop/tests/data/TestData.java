package com.tricentis.demowebshop.tests.data;

import com.github.javafaker.Faker;
import lombok.Getter;

@Getter
public class TestData {

    public final String AUTH_COOKIE_NAME = "NOPCOMMERCE.AUTH";
    public final String VERIFICATION_TOKEN_NAME = "__RequestVerificationToken";
    public final String VERIFICATION_TOKEN_INPUT_VALUE = "XapUk5SPaJmG9pDlZ1tlf1snRyim7nc9PmXtFHt0VwTC0VmNQe_NhKcGZLR9Y6dUqtm-I0kkmOwEnS78l1cOa61GqXN9aVsqhOPYZue-j2Y1";
    public final String VERIFICATION_TOKEN_HEADER_VALUE = "gu-OZ7vGMA98nzVPYmU8mhYs98kYSlT5afnyeYDjxWGRyWR9BqFEqGLNzaghEnn5-8ge-M93B--xbfx4JMTH3nmQ4I1GdH5JtXDvAEc0YBU1";
    Faker faker = new Faker();

    String password = faker.numerify("#*#*#*#*#");
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String anotherEmail = faker.internet().emailAddress();
    String anotherName = faker.name().firstName();
    String anotherLastName = faker.name().lastName();

}
