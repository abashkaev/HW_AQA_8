package page;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final SelenideElement login = $("[data-test-id='login'] input");
    private final SelenideElement password = $("[data-test-id='password'] input");
    private final SelenideElement button = $("[data-test-id='action-login']");

    private final SelenideElement errorNotification = $("[data-test-id='error-notification']");


    public VerificationPage validLogin (DataHelper.AuthInfo info) {
        login.setValue(info.getUserLogin());
        password.setValue(info.getUserPassword());
        button.click();
        return new VerificationPage();
    }

    public void errorNotificationIsVisible () {
        errorNotification.shouldBe(Condition.visible);
    }
}
