package StepDefinitions;

import Pages.LocatorPage;
import Utilities.ExcelUtility;
import Utilities.GWD;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class WritingAllLaptopsToExcel {
    LocatorPage lp = new LocatorPage();
    ArrayList<String> list=new ArrayList<>();

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
            String strElement=e.getText();
            int endIndex = strElement.indexOf('$');
            if (endIndex != -1) {
                strElement = strElement.toString().substring(0, endIndex);
            } else {
                strElement=strElement.toString().substring(0,10);
            }
            list.add(strElement);
        }
        System.out.println(list);

        String path = "src/test/java/ExcelFiles/TableOfProducts.xlsx";
        String listName = "LAPTOPS";
        int listSize = list.size();
        ExcelUtility.writeToExcel(path,list,listSize,listName);
    }
}
