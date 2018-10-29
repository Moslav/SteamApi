package steam.menu;

import framework.PropertyReader;
import framework.elements.Label;
import org.openqa.selenium.By;

import java.util.Locale;
import java.util.ResourceBundle;

public class Menu  {
    private static Locale locale = new Locale(PropertyReader.getTestProperty("lang"));
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("localization", locale);
    private static By menuFormLocator = By.xpath("//div[@id = 'store_search']");


    public enum MainMenu {
        Games(resourceBundle.getString("Games"));

        private String locatorMenu;
        private String commonLocatorMenu = "//div[@class='store_nav']//span[contains(.,'%s')]";

        MainMenu(String locator) {
            this.locatorMenu = locator;
        }

        public By getWebElementMenu(){
           return By.xpath(String.format(commonLocatorMenu, locatorMenu));
        }
    }

    public enum SubMenu {
        Actions(resourceBundle.getString("Action"));

        private String locatorSubMenu;
        private String commonLocatorSubMenu = "//div[@class = 'popup_body popup_menu']//a[contains(.,'%s')]";

        SubMenu(String locator){
            this.locatorSubMenu = locator;
        }

        public By getWebElementSubMenu(){
            return By.xpath(String.format(commonLocatorSubMenu, locatorSubMenu));
        }


    }

    public void navigateToMenu(MainMenu mainMenu,SubMenu subMenu){
        Label labelnMenu = new Label(mainMenu.getWebElementMenu());
        labelnMenu.moveToElement();
        Label labelSubMenu = new Label(subMenu.getWebElementSubMenu());
        labelSubMenu.clickAndWAit();
    }

    public static Menu getMenu(){
        return new Menu();
    }

}
