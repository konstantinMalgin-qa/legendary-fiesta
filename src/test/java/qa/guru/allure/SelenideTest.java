package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest {

    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.browserSize = "1920x1080";
        open("https://github.com");

        $(".search-input-container").click();
        $("#query-builder-test")
                .sendKeys("konstantinMalgin-qa/RegistrationPageObjectTest");
        $("#query-builder-test").submit();

        $(linkText("konstantinMalgin-qa/RegistrationPageObjectTest")).click();
        $("#issues-tab").click();
        $(withText("#1")).should(Condition.exist);
    }

}
