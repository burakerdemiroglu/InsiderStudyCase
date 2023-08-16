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

public class ProductDetailPage extends Helper {
    private final Random ran;
    private HomePage _homePage;
    private CategoryPage _categoryPage;

    public ProductDetailPage() {
        PageFactory.initElements(Driver.get(), this);
        ran = new Random();
        _homePage = new HomePage();
        _categoryPage = new CategoryPage();
    }

    @FindBy(xpath = "//a[@id='pd_add_to_cart']")
    public WebElement sepeteEkleBtn;
    @FindBy(xpath = "//a[@id='pd_add_to_cart' and text()='SEPETE EKLENDİ'] ")
    public WebElement sepeteEklendiBtn;
    @FindBy(xpath = "//div[@class='cart-dropdown  ']//span[text()='Sepetim']")
    public WebElement Sepetim;
    @FindBy(xpath = "//div[contains(@class,'size-pop-up')]//a[@data-tracking-label='BedenSecenekleri' and not(@class='disabled')]")
    public List<WebElement> bedenSecenekleri;
    @FindBy(xpath = "//div[@class='sizeHeightSelectBox']//a[not(contains(@class,'hidden'))]")
    public WebElement urunSepeteEkleBtn;
    @FindBy(id = "evamToolTipTop")
    public WebElement stokBildirimMesaj;
    @FindBy(xpath = "//div[@id='rightInfoBar']//div[@class='product-title']")
    public WebElement urunDetaySayfasiBasligi;

    public void sepeteEkleButonunaTikla() {
        while (!urunSepeteEkleBtn.getText().equals("SEPETE EKLE")) {
            Log4j.info("Ürünün stoklarının tükendiği görüntülendi. Başka bir ürüne geçiş yapılıyor.");
            clickElement(stokBildirimMesaj);
            _homePage.herhangiBirKategoriMenuSecim();
            _homePage.herhangiBirKategoriSecim();
            _categoryPage.herhangiBirUrunDetaySayfasinaGit();
        }

        if (bedenSecenekleri.size() >= 1) {
            herhangiBirBedenSec();
        }
        clickElement(sepeteEkleBtn);
        Log4j.info("Sepete ekle butonuna tıklandı.");
    }

    public void sepeteGit() {
        clickElement(Sepetim);
    }

    public void herhangiBirBedenSec() {
        clickElement(bedenSecenekleri.get(ran.nextInt(bedenSecenekleri.size())));
        Log4j.info("Rastgele beden seçildi.");
    }

    public void sepeteEklendiMi() {
        if (sepeteEklendiBtn.isDisplayed()) {
        Assert.assertTrue(true);
        Log4j.info("Sepete başarıyla eklendi.");
    } else {
        Assert.fail("Sepete eklenemedi.");
        Log4j.error("Sepete eklenemedi.");
    }
    }

    public void baslikKontrol(String urunBasligi) {
        if (urunDetaySayfasiBasligi.getText().toLowerCase().contains(urunBasligi.toLowerCase())) {
            Assert.assertTrue(true);
            Log4j.info("Doğru ürüne giriş yapıldı.");
        } else {
            Assert.fail("Doğru ürüne giriş yapılamadı. Beklenen: " + urunBasligi + " Görüntülenen: " + urunDetaySayfasiBasligi.getText());
            Log4j.error("Doğru ürüne giriş yapılamadı. Beklenen: " + urunBasligi + " Görüntülenen: " + urunDetaySayfasiBasligi.getText());
        }
    }
}
