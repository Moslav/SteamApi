package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class Wait {
    private String shorttime = "shorttime";
    private String maintime = "maintime";
    private String longtime = "longtime";

    private final WebDriver driver;

    public Wait(WebDriver driver) {
        this.driver = driver;
    }

    public void explicitWait(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(PropertyReader.getTestProperty(longtime)),
                Integer.parseInt(PropertyReader.getTestProperty(shorttime)));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
    }

    public void implicitWait() {
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(PropertyReader.getTestProperty(maintime)), TimeUnit.SECONDS);
    }

    public void waitPageLoad() {
       /* WebDriverWait wait = new WebDriverWait(driver, 30, 5);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver wdriver) {
                return ((JavascriptExecutor) driver).executeScript(
                        "return document.readyState"
                ).equals("complete");
            }
        });*/
       driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
    }



}
