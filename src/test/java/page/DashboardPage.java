package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.conditions.Text;

import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {
    public void dashBoardVisible() {
        $("[data-test-id='dashboard']").shouldHave(Condition.text("  Личный кабинет")).shouldBe(Condition.visible);
    }
}
