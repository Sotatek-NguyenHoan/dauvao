package test;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import test.Atribute.Atribute;
import test.CommonPath.EbayPath;
import test.CommonPath.LazadaPath;
import test.Step.Step;

import java.util.*;

public class TestClass  extends Step {
    @Test
    public void Task()  {
        //productebay();
        //productLazada();
        List<Atribute> atributeList0=new ArrayList<Atribute>();
        atributeList0.addAll(productebay());
        atributeList0.addAll(productLazada());
        List<Atribute> ebayProduct = sort(atributeList0);
        for (int i =0; i< ebayProduct.size();i++) {
             System.out.println(ebayProduct.get(i).getTitle() + " " + ebayProduct.get(i).getUrl() + " " + ebayProduct.get(i).getProductName() + " " + ebayProduct.get(i).getProductPrice());
        }

    }
}
