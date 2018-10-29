package steam.form;

import framework.BaseForm;
import framework.CommonFunctions;
import framework.elements.Label;
import org.openqa.selenium.By;

public class SpecialPage extends BaseForm {
    private Label labelForGameWithDiscount = new Label(By.xpath("//div[@id = 'search_result_container']"));
    private String locatorForLabeslWithGame = "//div[@class = 'col search_discount responsive_secondrow']/span[contains(.,'%s')]";
    private Label labelWithGames;
    private static By specialPage = By.xpath("//div[@class='page_content']/h2");
    private String regexp = "-(.*?)%";

    public SpecialPage() {
        super(specialPage);
    }

    public void findMaxElementAndClick() {
        CommonFunctions.findMaxValueList(CommonFunctions.getListIntegerValueFromTextWithRegex(labelForGameWithDiscount.getTextElement(), regexp));
        labelWithGames = new Label(By.xpath(String.format(locatorForLabeslWithGame, CommonFunctions.getMaximumElement())));
        labelWithGames.clickAndWAit();
    }

    public String returnMaxValueOfDiscount() {
       return CommonFunctions.getMaximumElement();
    }
}

