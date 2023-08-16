package Case.pages;

import Case.utils.Driver;
import Case.utils.Helper;
import Case.utils.Log4j;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class BasketPage extends Helper {
    private final Random ran;

    public BasketPage() {
        PageFactory.initElements(Driver.get(), this);
        ran = new Random();
    }

    @FindBy(xpath = "//span[contains(text(),'Sepetim (1 Ürün)')]")
    public WebElement sepetDurum;

    public void sepeteGidildiMi() {
        if (sepetDurum.isDisplayed()) {
            Assert.assertTrue(true);
            Log4j.info("Sepete başarıyla gidildi.");
        } else {
            Assert.fail("Sepete gidilemedi.");
            Log4j.error("Sepete gidilemedi.");
        }
    }
}
