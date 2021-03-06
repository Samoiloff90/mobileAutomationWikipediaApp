package tests.wikipedia;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class WikiMobileTest extends TestBase {
    @Test
    void searchNewWikiTest() {
        step("Skip Language Selection", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click());
        step("Type search", () -> {
           $(MobileBy.AccessibilityId("Search Wikipedia")).click();
           $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).setValue("Selenium");
        });
        step("Verify content found", () ->
                $$(byClassName("android.widget.TextView")).shouldHave(sizeGreaterThan(0)));
    }
}
