package steam.form;

import framework.BaseForm;
import framework.elements.Button;
import org.openqa.selenium.By;

public  class ActionPage extends BaseForm {
    private Button buttonSpecial = new Button(By.xpath("//div[@class='contenthub_specials_see_more']/a"));
    private static By actionPageLocator = By.xpath("//div[@class='page_content content_hub']/h2");

    public ActionPage(){
        super(actionPageLocator);
    }

    public void showAllSpecials() {
        buttonSpecial.clickAndWAit();
    }

}
