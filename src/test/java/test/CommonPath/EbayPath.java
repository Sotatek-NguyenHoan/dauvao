package test.CommonPath;

import org.openqa.selenium.By;
import test.Base.Base;

public class EbayPath extends Base {
    public By url,txtboxSearch,buttonSearch,tickbox,product,tensp,gia;
    public void useField() {
        buttonSearch=By.xpath("//*[@id=\"gh-btn\"]");
        txtboxSearch = By.xpath("//*[@class=\"gh-tb ui-autocomplete-input\"]");
        tickbox=By.xpath("//*[@id=\"x-refine__group_1__2\"]/ul/li[1]/div/a/div/span/input");
        product=By.xpath("//*[@id='srp-river-results']/ul/li");
        url=By.xpath("//*[@class=\"s-item__link\"]");
        tensp=By.xpath("//*[@class=\"s-item__title\"]");
        gia=By.xpath("//*[@class=\"s-item__price\"]");

    }
}
