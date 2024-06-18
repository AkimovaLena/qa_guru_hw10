import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Stories;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class SelenideTest extends BaseTest {

    @Test
    void selenideTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");
        $(".search-input-container").click();
        $("[name=query-builder-test]").setValue("eroshenkoam/allure-example");
        $("[name=query-builder-test]").pressEnter();
        $(By.linkText("eroshenkoam/allure-example")).click();
        $("#issues-tab").click();
        $(".js-check-all-container").shouldHave(text("89"));

    }


}
