package test.Step;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import test.Atribute.Atribute;
import test.Base.Base;
import test.CommonPath.EbayPath;
import test.CommonPath.LazadaPath;

import java.util.ArrayList;
import java.util.List;

public class Step extends Base {

    WebDriver driver;
    String expect="Iphone 11";
    EbayPath ebayPath=new EbayPath();
    LazadaPath lazadaPath=new LazadaPath();
    public List<Atribute>productebay(){
        ebayPath.useField();
        ebayPath.implicitWait(driver, 10);
        ebayPath.sendKey(driver, ebayPath.txtboxSearch, expect);
        ebayPath.click(driver, ebayPath.buttonSearch);
        ebayPath.click(driver, ebayPath.tickbox);
        String title=driver.getTitle();
        title=title.substring(11);
        List<WebElement> we = driver.findElements(ebayPath.tensp);
        List<WebElement> we1 = driver.findElements(ebayPath.gia);
        List<WebElement> we2 = driver.findElements(ebayPath.url);

        List<Atribute> atributeList=new ArrayList<Atribute>();

        for (int i=0;i<20;i++){
            String pri=we1.get(i).getText().split("V")[0];
            Atribute atribute=new Atribute(title,we.get(i).getText(),pri.replaceAll(",","").trim(),we2.get(i).getAttribute("href") );
             atributeList.add(atribute);
        }
        return atributeList;
    }

    public List<Atribute>productLazada(){
        driver.get("https://www.lazada.vn/");
        lazadaPath.useField();
        lazadaPath.implicitWait(driver, 10);
        lazadaPath.sendKey(driver, lazadaPath.txtboxSearch, expect);
        lazadaPath.click(driver, lazadaPath.buttonSearch);
        String title2=driver.getTitle();
        title2=title2.substring(55,61);
        List<WebElement> we3 = driver.findElements(lazadaPath.tensp);
        List<WebElement> we4 = driver.findElements(lazadaPath.gia);
        List<WebElement> we5 = driver.findElements(lazadaPath.url);
        List<Atribute> atributeList2=new ArrayList<Atribute>();
        for (int i=0;i<20;i++){
            String pri2=we4.get(i).getText().split("₫")[0].replace(".","");
            Atribute atribute2=new Atribute(title2,we3.get(i).getText(),pri2.trim(),we5.get(i).getAttribute("href") );
            atributeList2.add(atribute2);

        }
            return atributeList2;
    }
    @BeforeMethod
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }



}
