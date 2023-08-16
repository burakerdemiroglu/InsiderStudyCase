from behave import *

from pages.CategoryPage import CategoryPage
from pages.HomePage import HomePage
from pages.BasketPage import BasketPage
from pages.ProductDetailPage import ProductDetailPage
from utils.Helper import Helper


class ProductSteps(HomePage):

    @given('"{url}" adresine gidilir.')
    def step_impl(self, url):
        Helper.navigate_to_url(url)
        HomePage.tum_cerezlere_izin_ver(self)
        HomePage.ana_sayfa_acildi_mi(self)

    @step("Herhangi bir kategori sayfasına gidilir.")
    def step_impl(self):
        HomePage.herhangi_bir_kategori_menu_secim(self)
        HomePage.herhangi_bir_kategori_secim(self)
        CategoryPage.kategori_acildi_mi(self)

    @step("Herhangi bir ürün sayfasına gidilir.")
    def step_impl(self):
        urunBaslik = CategoryPage.herhangi_bir_urun_detay_sayfasina_git(self)
        ProductDetailPage.baslik_kontrol(self, urunBaslik)

    @step("Ürün sepete eklenir.")
    def step_impl(self):
        ProductDetailPage.sepete_ekle_butonuna_tikla(self)
        ProductDetailPage.sepete_eklendi_mi(self)

    @when("Sepet sayfasına gidilir.")
    def step_impl(self):
        ProductDetailPage.sepete_git(self)
        BasketPage.sepete_gidildi_mi(self)

    @then("Anasayfaya geri dönülür.")
    def step_impl(self):
        HomePage.ana_sayfaya_git(self)
        HomePage.ana_sayfa_acildi_mi(self)
