package tests;

import enums.Tabs;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CompaniesPage;
import pages.MainPage;
import pages.SalariesPage;
import pages.WorkPage;

public class DouTest extends TestBase {


    @Test
    public void pmSalaryOnDecember2011() {
        new MainPage().open()
                .navigateByClickingOnHeaderTab(new SalariesPage(), Tabs.SALARIES)
                .setCity("Киев")
                .setJobPosition("Project manager")
                .setPeriod("декабрь 2011")
                .shouldSeeSelectedCity("Киев")
                .shouldSeeSelectedJob("Project manager")
                .shouldSeeSelectedPeriod("декабрь 2011")
                .shouldSeeMaxSalary("3000");
    }

    @Test
    public void cloudBeesCompanyLinkRedirectsToProperWebSite() {
        new MainPage().open()
                .navigateByClickingOnHeaderTab(new WorkPage(), Tabs.WORK)
                .navigateByClickingOnSubheaderTab(new CompaniesPage(), Tabs.COMPANIES)
                .searchCompany("CloudBees")
                .openCompanyPage("CloudBees")
                .clickOnCompanyWebsiteAndVerifyTitle("CloudBees | Enterprise Jenkins and DevOps");

    }

    @Test
    public void jsseMaxSalary3yearsExperience() {
        new MainPage().open()
                .navigateByClickingOnHeaderTab(new SalariesPage(), Tabs.SALARIES)
                .setCity("вся Украина")
                .setJobPosition("Senior Software Engineer")
                .setProgrammingLanguage("Java")
                .setSlider(3, 3)
                .shouldSeeSelectedCity("вся Украина")
                .shouldSeeSelectedJob("Senior Software Engineer")
                .shouldSeeSelectedLanguage("Java")
                .shouldSeeThatSliderIsSetCorrectly("left: 30%; width: 0%;")
                .shouldSeeMaxSalary("4000");
    }

    @Test
    public void jsseAverageSalaryFrom2to5yearsExperience() {
        new MainPage().open()
                .navigateByClickingOnHeaderTab(new SalariesPage(), Tabs.SALARIES)
                .setCity("вся Украина")
                .setJobPosition("Senior Software Engineer")
                .setProgrammingLanguage("Java")
                .setSlider(2, 5)
                .shouldSeeSelectedCity("вся Украина")
                .shouldSeeSelectedJob("Senior Software Engineer")
                .shouldSeeSelectedLanguage("Java")
                .shouldSeeThatSliderIsSetCorrectly("left: 20%; width: 30%;")
                .shouldSeeAvgSalary("3500");
    }

    @BeforeMethod(alwaysRun = true)
    public void before() {
        createDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void after() {
        removeDriver();
    }
}
