package com.tricentis.demowebshop.tests;

import com.codeborne.selenide.WebDriverRunner;
import com.tricentis.demowebshop.tests.components.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

public class MainTests extends TestBase {

    @AfterEach
    public void clearBrowser() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
    }

    @Test
    @DisplayName("Регистрация пользователя")
    void registerNewUserAPITest() {
        String authCookieValue = step("Регистрируем пользователя через API ", () -> given()
                .when()
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam(testData.VERIFICATION_TOKEN_NAME, testData.VERIFICATION_TOKEN_INPUT_VALUE)
                .formParam("FirstName", firstName)
                .formParam("LastName", lastName)
                .formParam("Email", email)
                .formParam("Password", password)
                .formParam("ConfirmPassword", password)
                .cookie(testData.VERIFICATION_TOKEN_NAME, testData.VERIFICATION_TOKEN_HEADER_VALUE)
                .post("/register")
                .then()
                .extract().cookie(testData.AUTH_COOKIE_NAME));


        step("Подкладываем куки созданного пользователя", () -> {
            open("/Themes/DefaultClean/Content/images/logo.png");
            Cookie authCookie = new Cookie(testData.AUTH_COOKIE_NAME, authCookieValue);
            WebDriverRunner.getWebDriver().manage().addCookie(authCookie);
        });

        step("Открываем сайт", () -> {
            open("/registerresult/1");
        });

        step("Проверяем, что пользователь зарегистрирован", () -> {
            user.checkUserCreated(email);
        });
    }

    @Test
    @DisplayName("Редактирование профиля")
    void userCanModifyProfileAPITest() {
        String authCookieValue = step("Регистрируем пользователя через API ", () -> given()
                .when()
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam(testData.VERIFICATION_TOKEN_NAME, testData.VERIFICATION_TOKEN_INPUT_VALUE)
                .formParam("FirstName", firstName)
                .formParam("LastName", lastName)
                .formParam("Email", email)
                .formParam("Password", password)
                .formParam("ConfirmPassword", password)
                .cookie(testData.VERIFICATION_TOKEN_NAME, testData.VERIFICATION_TOKEN_HEADER_VALUE)
                .post("/register")
                .then()
                .extract().cookie(testData.AUTH_COOKIE_NAME));

        step("Подкладываем куки созданного пользователя", () -> {
            open("/Themes/DefaultClean/Content/images/logo.png");
            Cookie authCookie = new Cookie(testData.AUTH_COOKIE_NAME, authCookieValue);
            WebDriverRunner.getWebDriver().manage().addCookie(authCookie);
        });

        step("Открываем профиль", () -> {
            open("/customer/info");
        });

        step("Заполняем профиль новыми занчениями", () -> {
            user
                    .setFirstName(anotherName)
                    .setLastName(anotherLastName)
                    .setEmail(anotherEmail);
        });

        step("Сохраняем профиль", () -> {
            user.saveProfile();
        });

        step("Повторно открываем профиль", () -> {
            user.openProfile();
        });

        step("Проверяем, что изменения сохранились", () -> {
            user.checkChangesSaved(anotherEmail, anotherName, anotherLastName);
        });
    }
}