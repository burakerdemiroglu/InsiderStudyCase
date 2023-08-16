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

public class CategoryPage extends Helper {
    private HomePage _homePage;

    public CategoryPage() {
        PageFactory.initElements(Driver.get(), this);
        _homePage = new HomePage();
    }

    private Random ran = new Random();
    @FindBy(xpath = "//div[@class='product-image']//ancestor::a[1]//h5[@class='product-card__title']")
    public List<WebElement> urunAdiListesi;
    @FindBy(xpath = "//span[@class='product-list-heading__product-count']/p")
    public WebElement urunSayisi;
    @FindBy(xpath = "//input[@placeholder='Ürün, kategori veya marka ara']")
    public WebElement aramaKutusu;
    @FindBy(xpath = "//span[text()='Filtreyi Gizle']")
    public WebElement filtreyiGizleBtn;

    public String herhangiBirUrunDetaySayfasinaGit() {
        while (aramaKutusu.getAttribute("id").equals("search_input")) {
            Log4j.info("Aradığın sayfaya şu an ulaşılmıyor hatası alındı. Başka ürüne geçiş yapılıyor.");
            _homePage.anaSayfayaGit();
            _homePage.herhangiBirKategoriMenuSecim();
            _homePage.herhangiBirKategoriSecim();
        }

        while (urunSayisi.getText().equals("0 ürün listelendi.")) {
            Log4j.info("Kategoride ürün bulunmuyor. Tekrar seçim yapılacak.");
            _homePage.herhangiBirKategoriMenuSecim();
            _homePage.herhangiBirKategoriSecim();
        }
        int random = ran.nextInt(urunAdiListesi.size());
        String urunBasligi = urunAdiListesi.get(random).getText();

        clickElement(urunAdiListesi.get(random));
        Log4j.info(String.format("Herhangi bir ürünün detay sayfasına gidildi. Başlık: '%s'", urunBasligi));

        return urunBasligi;
    }

    public void kategoriAcildiMi() {
        if (filtreyiGizleBtn.isDisplayed()) {
            Assert.assertTrue(true);
            Log4j.info("Kategori sayfası açıldı.");
        } else {
            Assert.fail("Kategori sayfası açılamadı.");
            Log4j.error("Kategori sayfası açılamadı.");
        }
    }
}