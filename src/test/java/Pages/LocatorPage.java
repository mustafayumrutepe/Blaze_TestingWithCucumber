package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class LocatorPage extends Parent{public LocatorPage() {PageFactory.initElements(GWD.getDriver(),this);}

    @FindBy(xpath = "//*[text()='Laptops']")        private WebElement laptops;
    @FindBy(id = "next2")                           private WebElement next;




    public WebElement getWebElement(String strElement){
        switch (strElement){
            case "laptops": return this.laptops;
            case "next": return this.next;
        }
        return null;
    }







    @FindBy(xpath = "//div[@id='tbodyid']/div") private List<WebElement> listOfLaptops;
    public List<WebElement> getListOfLaptops() {return listOfLaptops;}


}
