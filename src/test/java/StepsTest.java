import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class StepsTest extends BaseTest {

    private static final String repository = "eroshenkoam/allure-example";
    private static final int issue = 80;

    @Test
    @Owner("EAkimova")
    @Feature("Сьют по поиску")
    @Story("Поиск ISSUE")
    @DisplayName("Проверка Issue с номером "+issue)
    void stepsTest() {

        SelenideLogger.addListener("allure", new AllureSelenide());
        Steps steps = new Steps();

        steps.openMain();
        steps.seurchRepository(repository);
        steps.openRepository(repository);
        steps.openIssue();
        steps.shouldIssueWithNumber(issue);


    }

}
