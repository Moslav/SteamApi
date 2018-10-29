package steam.form;

import framework.BaseForm;
import framework.elements.Button;
import org.openqa.selenium.By;

public  class InstallSteamPage extends BaseForm {
    private Button button = new Button(By.xpath("//div[@class = 'about_install_ctn']/a"));
    private static By installSteamPage = By.xpath("//div[@id=\"about_greeting_ctn\"]/div/img");

    public InstallSteamPage() {
        super(installSteamPage);
    }

    public void beginInstallSteam(){
        button.clickOnElement();
    }
}
