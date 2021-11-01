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

public class LazadaPage extends BasePage {

        @FindBy(xpath="//*[@class=\"search-box__button--1oH7\"]")
        private WebElement buttonSearchPath;

        @FindBy(xpath="//*[@class=\"search-box__input--O34g\"]")
        private WebElement txtboxSearchPath;

        @FindBy(xpath="//*[@class=\"_3BIK3 _23S9X\"]")
        private WebElement productPath;

        @FindBy(xpath="//*[@id=\"root\"]/div/div[3]/div[1]/div/div[1]/div[2]/div/div/div/div[2]/div[2]/a")
        private List<WebElement> urlPath;

        @FindBy(xpath="//*[@id=\"root\"]/div/div[3]/div[1]/div/div[1]/div[2]/div/div/div/div[2]/div[2]/a")
        private List<WebElement> nameProductPath;

        @FindBy(xpath="//*[@id=\"root\"]/div/div[3]/div[1]/div/div[1]/div[2]/div/div/div/div[2]/div[3]/span")
        private List<WebElement> pricePath;

        String expect="Iphone 11";
        private WebDriver driver;
        public LazadaPage(WebDriver _driver){
            super(_driver);
            driver = _driver;
            PageFactory.initElements(driver, this);
        }

        @Step("Search product")
        public void searchProductOfLazada(){
            driver.get("https://www.lazada.vn/");
            sendKey( txtboxSearchPath, expect);
            click( buttonSearchPath);
        }

        @Step("Get title of website")
        public String getTitleOfLazada(){
            String title2=driver.getTitle().substring(55,61);
            return title2;
        }

        @Step("Get information of products")
        public List<Attribute> getProductOfLazada(){
            List<Attribute> atributeList2=new ArrayList<Attribute>();
            for (int i=0;i<20;i++){
                String pri2=pricePath.get(i).getText().split("₫")[0].replace(".","");
                Attribute atribute2=new Attribute(getTitleOfLazada(),nameProductPath.get(i).getText(),pri2.trim(),urlPath.get(i).getAttribute("href") );
                atributeList2.add(atribute2);

            }
            return atributeList2;
        }
}

