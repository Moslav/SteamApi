package framework.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class ComboBox extends BaseElement{

    public ComboBox(By locator) {
        super(locator);
    }

    public void chooseElementFromSelect(String value){
        Select select = new Select(getWebElement());
        select.selectByValue(value);
    }
}
