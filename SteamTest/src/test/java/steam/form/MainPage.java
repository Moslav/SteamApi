package steam.form;

import framework.BaseForm;
import framework.PropertyReader;
import framework.elements.Label;
import org.openqa.selenium.By;

public  class MainPage extends BaseForm {

    private static By mainPageLocator = By.xpath("//div[@class= 'searchbox']");
    private Label labelForChooseLanguage  = new Label(By.xpath("//div[@id = 'global_action_menu']//span[@id='language_pulldown']"));
    private Label labelRussianLang = new Label(By.xpath("//div[@class='popup_body popup_menu']/a[contains(@href, 'russian')]"));
    private Label labelEnglishLang = new Label(By.xpath("//div[@class='popup_body popup_menu']/a[contains(@href, 'english')]"));
    private Label valueOfLanguageSteamPage = new Label(By.tagName("html"));
    private final String langRussian = "ru";
    private final String langEnglish = "en";
    private final String lang = "lang";

    public MainPage() {
        super(mainPageLocator);
    }

    public String getSiteLanguage(){
        return valueOfLanguageSteamPage.getAttributeBy(lang);
    }

    /** переписат нормально*/

    public void chooseLanguageSite(){
        switch (getSiteLanguage()){
            case "en":
                if(PropertyReader.getTestProperty(lang).equals(langRussian)){
                    labelForChooseLanguage.clickOnElement();
                    labelRussianLang.clickOnElement();
                }
                break;
            case "ru":
                if(PropertyReader.getTestProperty(lang).equals(langEnglish)){
                    labelForChooseLanguage.clickOnElement();
                    labelEnglishLang.clickOnElement();
                }
                break;
        }
    }

}
