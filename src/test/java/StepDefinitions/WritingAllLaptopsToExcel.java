package StepDefinitions;

import Pages.LocatorPage;
import Utilities.ExcelUtility;
import Utilities.GWD;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Utilities.ExcelUtility;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class WritingAllLaptopsToExcel {
    LocatorPage lp = new LocatorPage();
    List<String> list=new ArrayList<>();

    @Given("Navigate to Blaze website")
    public void navigateToBlazeWebsite() {
        GWD.getDriver().get("https://www.demoblaze.com/index.html");
    }

    @When("Click on the element in LocatorPage")
    public void clickOnTheElementInLocatorPage(DataTable dataTable) {
        List<String> strElement = dataTable.asList(String.class);
        for (String strE : strElement){
            lp.myClick(lp.getWebElement(strE));
        }

    }

    @Then("Get list of laptops and write to the excel file")
    public void getListOfLaptopsAndWriteToTheExcelFile() {
        lp.waitUntilElementsToBeVisible(lp.getListOfLaptops());
        List<WebElement> listOfLaptops = lp.getListOfLaptops();

        for (WebElement e : listOfLaptops){
            String strElement=e.getText().toString().substring(0,10);
            list.add(strElement);
        }

//        ExcelUtility.writeToExcel();
    }


    @And("Get list of laptops and write to the excel file in second page")
    public void getListOfLaptopsAndWriteToTheExcelFileInSecondPage(DataTable dataTable) {

        List<String> elementStr = dataTable.asList(String.class);
        for (String strE : elementStr){
            lp.waitUntilElementToBeClicable(lp.getWebElement(strE));
        }

        lp.waitUntilElementsToBeVisible(lp.getListOfLaptops());
        List<WebElement> listOfLaptops = lp.getListOfLaptops();

        for (int i = 0; i < list.size(); i++) {
            for (WebElement e : listOfLaptops){
                String strElement=e.getText().toString().substring(0,10);
                if (!list.get(i).equals(strElement)) {
                    list.add(strElement);
                }
            }
        }

        System.out.println("list = " + list);

//        ExcelUtility.writeToExcel();
    }
}
