package test.CommonPath;

import org.openqa.selenium.By;
import test.Base.Base;

public class LazadaPath extends Base {
    public By url,txtboxSearch,buttonSearch,product,tensp,gia;
    public void useField() {
        buttonSearch=By.xpath("//*[@class=\"search-box__button--1oH7\"]");
        txtboxSearch = By.xpath("//*[@class=\"search-box__input--O34g\"]");
        product=By.xpath("//*[@class=\"_3BIK3 _23S9X\"]");
        url=By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div/div[1]/div[2]/div/div/div/div[2]/div[2]/a");
        tensp=By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div/div[1]/div[2]/div/div/div/div[2]/div[2]/a");
        gia=By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div/div[1]/div[2]/div/div/div/div[2]/div[3]/span");

    }
}

