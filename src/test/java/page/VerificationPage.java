package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    private final SelenideElement verify = $("[data-test-id='code'] input");
    private final SelenideElement verifyButton = $("[data-test-id='action-verify']");
    private final SelenideElement errorNotification = $("[data-test-id='error-notification']");

    public void isOpenVerificationPage() {
        verify.shouldBe(Condition.visible);
    }

    public DashboardPage validVerify(String verifyCode) {
        verify.setValue(verifyCode);
        verifyButton.click();
        return new DashboardPage();
    }

    public void errorNotificationIsVisible() {
        errorNotification.shouldBe(Condition.visible);
    }
}
