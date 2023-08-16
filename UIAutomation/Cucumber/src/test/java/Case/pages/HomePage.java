package Case.pages;

import Case.utils.Driver;
import Case.utils.Helper;
import Case.utils.Log4j;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.Format;
import java.util.List;
import java.util.Random;

public class HomePage extends Helper {
    private final Random ran;

    public HomePage() {
        PageFactory.initElements(Driver.get(), this);
        ran = new Random();
    }

    @FindBy(xpath = "//div[@id='cookieseal-banner']//button[text()='Tüm Çerezlere İzin Ver']")
    public WebElement tumCerezlereIzinVer;
    @FindBy(xpath = "//div[@class='mega-menu ']//ancestor::li[@class='menu-header-item  ']")
    public List<WebElement> kategoriMenuSecim;
    @FindBy(xpath = "//li[@class='menu-header-item menu-header-item--active ']//ul[@class='zones-lists-items']//a")
    public List<WebElement> kategoriSecim;
    @FindBy(css = ".main-header-logo")
    public WebElement anaSayfaLogo;
    @FindBy(css = ".full-width-slider.full-width-slider--horizontal ")
    public WebElement anaSayfaSlaytResmi;

    public void tumCerezlereIzinVer() {
        clickElement(tumCerezlereIzinVer);
        Log4j.info("Tüm çerezlere izin ver butonuna tıklandı.");
    }

    public void herhangiBirKategoriMenuSecim() {
        int random = ran.nextInt(kategoriMenuSecim.size());
        String kategoriMenu = kategoriMenuSecim.get(random).getText();

        hoverElement(kategoriMenuSecim.get(random));
        Log4j.info(String.format("Header bölümündeki menülerden '%s' fareyle üzerine gelindi.", kategoriMenu));
    }

    public void herhangiBirKategoriSecim() {
        int random = ran.nextInt(kategoriSecim.size());
        String kategori = kategoriSecim.get(random).getText();

        clickElement(kategoriSecim.get(random));
        Log4j.info(String.format("Header bölümündeki kategorilerden '%s' tıklandı.", kategori));
    }

    public void anaSayfayaGit() {
        clickElement(anaSayfaLogo);
        Log4j.info("Header bölümündeki logoya tıklanarak ana sayfaya gidildi.");
    }

    public void anaSayfaAcildiMi() {
        if (anaSayfaSlaytResmi.isDisplayed()) {
            Assert.assertTrue(true);
            Log4j.info("Ana sayfadaki slayt gösterimi başarılı bir şekilde görüntülendi. Sonuç: Ana sayfa açıldı.");
        } else {
            Assert.fail("Ana sayfa açılmadı veya slayt görüntülenemedi.");
            Log4j.error("Ana sayfa açılmadı veya slayt görüntülenemedi.");
        }
    }
}
