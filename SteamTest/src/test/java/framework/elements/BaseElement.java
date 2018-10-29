package framework.elements;

import framework.BaseEntity;
import framework.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public abstract class BaseElement extends BaseEntity {

    private By locator;
    private WebElement webElement;
    private List<WebElement> elems;

    public BaseElement(By locator) {
        this.locator = locator;
    }

    public WebElement findWebElementBy () {
        webElement = driver.findElement(locator);
        return webElement;
    }

    public void moveToElement(){
        findWebElementBy();
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).build().perform();
    }

    public void clickOnElement(){
        findWebElementBy();
        webElement.click();
    }

    public void clickAndWAit(){
        findWebElementBy();
        webElement.click();
        new Wait(driver).waitPageLoad();
    }

    public void waitForIsElementPresent(){
        new Wait(driver).explicitWait(locator);
    }


    public List<WebElement> findElementsBy(){
        elems = driver.findElements(locator);
        return elems;
    }

    public String getAttributeBy(String attrname){
        findWebElementBy();
        return webElement.getAttribute(attrname);
    }

    public String getTextElement(){
        findWebElementBy();
        return webElement.getText();
    }

    public WebElement getWebElement(){
        return webElement;
    }


}
