import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
    }

    @AfterAll
    static void afterAll() {
        Selenide.closeWebDriver();
    }
}
