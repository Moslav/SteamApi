package steam.form;

import framework.BaseForm;
import framework.CommonFunctions;
import framework.elements.Button;
import framework.elements.Label;
import org.openqa.selenium.By;

public  class GamePage extends BaseForm{
    private Button button = new Button(By.xpath("//div[@class = 'header_installsteam_btn header_installsteam_btn_green']/a"));
    private Label label = new Label(By.xpath("//div[@class='discount_block game_purchase_discount']/div[@class='discount_pct']"));
    private static Label labelVisibleValForm = new Label(By.xpath("//div[@class = 'agegate_birthday_selector']"));
    private static By gamePageLocator = By.xpath("//div[@class='apphub_AppName']");
    private String regexp = "-(.*?)%";

    public GamePage() {
        super(gamePageLocator);
    }

    public void checkVisibleForm(){
        if(labelVisibleValForm.findElementsBy().size() != 0 ){
            new ValidationForm().fillInFieldsValidation();
        }
    }

    public String getDiscountOnGame(){
        return CommonFunctions.getRegexMatch(label.getTextElement(), regexp);
    }

    public void clickOnInstallSteam(){
        button.clickAndWAit();
    }

    @Override
    public void assertIsOpen() {
        checkVisibleForm();
        super.assertIsOpen();
    }
}
