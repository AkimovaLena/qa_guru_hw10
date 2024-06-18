import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


public class LambdaStepTest extends BaseTest {

    private static final String repository = "eroshenkoam/allure-example";
    private static final int issue = 80;

    @Test
    void selenideTest() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("Ищем ропозиторий " + repository, () -> {
            $(".search-input-container").click();
            $("[name=query-builder-test]").setValue(repository);
            $("[name=query-builder-test]").pressEnter();
        });
        step("Открываем " + repository, () -> {
            $(By.linkText(repository)).click();
        });
        step("Переходим в раздел ISSUE ", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем что раздел содержит ISSUE с номером " + String.valueOf(issue), () -> {
            $(".js-check-all-container").shouldHave(text(String.valueOf(issue)));
        });

    }

}
