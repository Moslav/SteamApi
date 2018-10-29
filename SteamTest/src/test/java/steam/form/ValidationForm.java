package steam.form;

import framework.elements.ComboBox;
import framework.elements.Label;
import org.openqa.selenium.By;

public  class ValidationForm {
    private Label label = new Label(By.xpath("//div[@class='agegate_text_container btns']/a[@class='btnv6_blue_hoverfade btn_medium']"));
    private ComboBox comboBoxYear = new ComboBox(By.xpath("//select[@id = 'ageYear']"));
    private String date = "1999";

    public void fillInFieldsValidation(){
        comboBoxYear.findWebElementBy();
        comboBoxYear.chooseElementFromSelect(date);
        passTheValidationProcess();
    }

    public void passTheValidationProcess(){
        label.clickOnElement();
    }

}
