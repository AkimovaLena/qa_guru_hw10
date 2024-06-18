import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Steps {

    @Step("Открываем главную страницу")
    public void openMain(){
        open("https://github.com");
    };

    @Step("Ищем ропозиторий {repository}")
    public void seurchRepository (String repository) {
        $(".search-input-container").click();
        $("[name=query-builder-test]").setValue(repository);
        $("[name=query-builder-test]").pressEnter();
    };

    @Step ("Открываем {repository}")
    public void openRepository (String repository) {
        $(By.linkText(repository)).click();
    };

    @Step ("(Переходим в раздел ISSUE")
    public void openIssue() {
        $("#issues-tab").click();
    };

    @Step ("Проверяем что раздел содержит ISSUE с номером ")
    public void shouldIssueWithNumber(int issue){
        $(".js-check-all-container").shouldHave(text(String.valueOf(issue)));
    };
}
