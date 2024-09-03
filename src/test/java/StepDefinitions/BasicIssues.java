package StepDefinitions;

import Pages.LocatorPage;
import Utilities.GWD;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class BasicIssues {
    WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(3));
    LocatorPage lp=new LocatorPage();

    @Then("Send My Text")
    public void sendMyText(DataTable dataTable) {
        List<List<String>> lists=dataTable.asLists(String.class);
        for (int i = 0; i <lists.size() ; i++) {
            WebElement element=lp.getWebElement(lists.get(i).get(0));
            String text=lists.get(i).get(1);
            lp.mySendKeys(element,text);
        }
    }

    @And("Check the in coming Alert Text")
    public void checkTheInComingAlertText(DataTable dataTable) {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        List<String> strings=dataTable.asList(String.class);
        for (String e: strings) {
            Assert.assertEquals(GWD.getDriver().switchTo().alert().getText(),e);
            System.out.println(GWD.getDriver().switchTo().alert().getText());
        }
        GWD.getDriver().switchTo().alert().accept();
    }
}
