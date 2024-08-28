package StepDefinitions;

import Utilities.GWD;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.Scanner;

public class Hooks {
    @Before
    public void before(){

    }

    @After
    public void after(Scenario scenario){
//        if (scenario.isFailed()){
//            TakesScreenshot ts=((TakesScreenshot) GWD.getDriver());
//            byte[] StateInMemory=ts.getScreenshotAs(OutputType.BYTES);
//            scenario.attach(StateInMemory, "image/png", "screenshot name");
//        }
        GWD.quitDriver();
    }
}
