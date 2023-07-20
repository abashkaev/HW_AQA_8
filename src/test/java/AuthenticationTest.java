import data.DataHelper;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import page.DashboardPage;
import page.LoginPage;
import page.VerificationPage;

import static com.codeborne.selenide.Selenide.open;
import static data.SQLHelper.cleanDataBase;
import static data.SQLHelper.getVerificationCode;

public class AuthenticationTest {
    @AfterAll
    static void teardown () {
        cleanDataBase();
    }
    @Test
    public void validAutorisation () {
        open("http://localhost:9999/");
        var loginPage = new LoginPage();
        var testUser = DataHelper.getAuthInfoTest();
        loginPage.validLogin(testUser);
        var verifyPage = new VerificationPage();
        verifyPage.validVerify(getVerificationCode().getVerifyCode());
        var dashboardPage = new DashboardPage();
        dashboardPage.dashBoardVisible();
    }

    @Test
    public void autorisationtWithInvalidUser () {
        open("http://localhost:9999/");
        var loginPage = new LoginPage();
        var authRandom = DataHelper.getRandomUser();
        loginPage.validLogin(authRandom);
        loginPage.errorNotificationIsVisible();
    }
    @Test
    public void autorisationWithInvalidVerificationCode () {
        open("http://localhost:9999/");
        var loginPage = new LoginPage();
        var testUser = DataHelper.getAuthInfoTest();
        loginPage.validLogin(testUser);
        var verifyPage = new VerificationPage();
        verifyPage.validVerify("12345");
        verifyPage.errorNotificationIsVisible();
    }
}
