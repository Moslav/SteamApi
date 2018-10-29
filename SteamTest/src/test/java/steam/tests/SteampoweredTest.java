package steam.tests;

import framework.BaseTest;
import org.testng.Assert;
import steam.form.*;
import steam.menu.Menu;

public class SteampoweredTest extends BaseTest{

    @Override
    public void test() {
        MainPage mainPage = new MainPage();
        mainPage.chooseLanguageSite();
        Menu.getMenu().navigateToMenu(Menu.MainMenu.Games, Menu.SubMenu.Actions);


        ActionPage actionPage = new ActionPage();
        actionPage.showAllSpecials();

        SpecialPage specialPage = new SpecialPage();
        specialPage.findMaxElementAndClick();

        GamePage gamePage = new GamePage();

        Assert.assertEquals(specialPage.returnMaxValueOfDiscount(), gamePage.getDiscountOnGame());
        gamePage.clickOnInstallSteam();

        InstallSteamPage installSteamPage = new InstallSteamPage();
        installSteamPage.beginInstallSteam();

    }
}