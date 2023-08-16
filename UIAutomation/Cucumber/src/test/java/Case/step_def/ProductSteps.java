package Case.step_def;

import Case.pages.BasketPage;
import Case.pages.CategoryPage;
import Case.pages.HomePage;
import Case.pages.ProductDetailPage;
import Case.utils.Helper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSteps {
    HomePage _homePage;
    CategoryPage _categoryPage;
    ProductDetailPage _productDetailPage;
    BasketPage _basketPage;
    Helper _helper;

    public ProductSteps() {
        _homePage = new HomePage();
        _categoryPage = new CategoryPage();
        _productDetailPage = new ProductDetailPage();
        _basketPage = new BasketPage();
        _helper = new Helper();
    }

    @Given("{string} adresine gidilir.")
    public void adresineGidilir(String url) {
        _helper.navigateToUrl(url);
        _homePage.tumCerezlereIzinVer();
        _homePage.anaSayfaAcildiMi(); //assert
    }

    @And("Herhangi bir kategori sayfasına gidilir.")
    public void herhangiBirKategoriSayfasinaGidilir() {
        _homePage.herhangiBirKategoriMenuSecim();
        _homePage.herhangiBirKategoriSecim();
        _categoryPage.kategoriAcildiMi(); //assert
    }

    @And("Herhangi bir ürün sayfasına gidilir.")
    public void herhangiBirUrunSayfasinaGidilir() {
        String urunBaslik = _categoryPage.herhangiBirUrunDetaySayfasinaGit();
        _productDetailPage.baslikKontrol(urunBaslik); //assert
    }

    @And("Ürün sepete eklenir.")
    public void urunSepeteEklenir() {
        _productDetailPage.sepeteEkleButonunaTikla();
        _productDetailPage.sepeteEklendiMi(); //assert
    }

    @When("Sepet sayfasına gidilir.")
    public void sepetSayfasinaGidilir() {
        _productDetailPage.sepeteGit();
        _basketPage.sepeteGidildiMi(); //assert
    }

    @Then("Anasayfaya geri dönülür.")
    public void anasayfayaGeriDonulur(){
        _homePage.anaSayfayaGit();
        _homePage.anaSayfaAcildiMi(); //assert
    }
}
