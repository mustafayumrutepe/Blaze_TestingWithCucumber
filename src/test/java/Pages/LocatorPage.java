package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class LocatorPage extends Parent{public LocatorPage() {PageFactory.initElements(GWD.getDriver(),this);}

    @FindBy(xpath = "//*[text()='Laptops']")                                                         private WebElement laptops;
    @FindBy(id = "next2")                                                                            private WebElement next;
    @FindBy(xpath = "//a[@id='signin2' and text()='Sign up']")                                       private WebElement SignUp;
    @FindBy(xpath = "//input[@type='text' and @class='form-control' and @id='sign-username']")       private WebElement UserName;
    @FindBy(xpath = "//*[@type='password' and @class='form-control' and @id='sign-password']")       private WebElement Password;
    @FindBy(xpath = "//*[text()='Sign up' and @class='btn btn-primary']")                            private WebElement SignUpButton;



    public WebElement getWebElement(String strElement){
        switch (strElement){
            case "laptops": return this.laptops;
            case "next": return this.next;
            case "SignUp"                            : return this.SignUp;
            case "UserName"                          : return this.UserName;
            case "Password"                          : return this.Password;
            case "SignUpButton"                      : return this.SignUpButton;
        }
        return null;
    }







    @FindBy(xpath = "//div[@id='tbodyid']/div") private List<WebElement> listOfLaptops;
    public List<WebElement> getListOfLaptops() {return listOfLaptops;}


}
