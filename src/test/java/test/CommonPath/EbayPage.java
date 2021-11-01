package test.CommonPath;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import test.Models.Attribute;
import test.Base.BasePage;

import java.util.ArrayList;
import java.util.List;

public class EbayPage extends BasePage {


        @FindBy(xpath="//*[@id=\"gh-btn\"]")
        private WebElement buttonSearchPath;

        @FindBy(xpath="//*[@class=\"gh-tb ui-autocomplete-input\"]")
        private WebElement txtboxSearchPath;

        @FindBy(xpath="//*[@id=\"x-refine__group_1__2\"]/ul/li[1]/div/a/div/span/input")
        private WebElement tickboxPath;

        @FindBy(xpath="//*[@id='srp-river-results']/ul/li")
        private WebElement productPath;

        @FindBy(xpath="//*[@class=\"s-item__link\"]")
        private List<WebElement> urlPath;

        @FindBy(xpath="//*[@class=\"s-item__title\"]")
        private List<WebElement> nameProductPath;

        @FindBy(xpath="//*[@class=\"s-item__price\"]")
        private List<WebElement> pricePath;

        String expect="Iphone 11";

        private WebDriver driver;
        public EbayPage(WebDriver _driver){
            super(_driver);
            driver = _driver;
            PageFactory.initElements(driver, this);
        }

    @Step("Search product")
    public void searchProductOfEbay(){
        sendKey( txtboxSearchPath, expect);
        click( buttonSearchPath);
    }

    @Step("Get title of website")
    public String getTitleOfEbay(){
        String title=driver.getTitle();
        return title;
    }

    public List<Attribute> getProductOfEbay(){
        List<Attribute> atributeList=new ArrayList<Attribute>();
        for (int i=0;i<20;i++){
            String pri=pricePath.get(i).getText().split("V")[0];
            Attribute atribute=new Attribute(getTitleOfEbay(),nameProductPath.get(i).getText(),pri.replaceAll(",","").trim(),urlPath.get(i).getAttribute("href") );
            atributeList.add(atribute);
        }
        return atributeList;
    }


}
