package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class CompaniesPage extends MainPage {

    public CompaniesPage open(){
        Selenide.open("/companies");
        return this;
    }

    private SelenideElement searchInput = $("input[class='company']");

    public CompaniesPage searchCompany (String companyName) {
        searchInput.setValue(companyName).pressEnter();
        $$(".l-items > li[class='l-company'] .cn-a").first().shouldHave(Condition.exactText(companyName));
        return this;
    }

    public CompaniesPage openCompanyPage(String companyName) {
        $x("//a[@class='cn-a' and text()='" + companyName + "']").click();
        return this;
    }

    public CompaniesPage clickOnCompanyWebsiteAndVerifyTitle(String nameOrHandleOrTitle) {
        $(".company-info .site > a ").click();
        Selenide.switchTo().window(nameOrHandleOrTitle);
        assertEquals(nameOrHandleOrTitle, getWebDriver().getTitle());
        return this;
    }



}
