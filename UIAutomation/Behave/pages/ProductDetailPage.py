import random
from selenium.webdriver.common.by import By

from pages.CategoryPage import CategoryPage
from pages.HomePage import HomePage
from utils.Driver import Driver
from utils.Helper import Helper


class Elements:
    sepete_ekle_btn = (By.XPATH, "//a[@id='pd_add_to_cart']")
    sepete_eklendi_btn = (By.XPATH, "//a[@id='pd_add_to_cart' and text()='SEPETE EKLENDİ']")
    sepetim = (By.XPATH, "//div[@class='cart-dropdown  ']//span[text()='Sepetim']")
    beden_secenekleri = (By.XPATH,
                         "//div[contains(@class,'size-pop-up')]//a[@data-tracking-label='BedenSecenekleri' and not(@class='disabled')]")
    urun_sepete_ekle_btn = (By.XPATH, "//div[@class='sizeHeightSelectBox']//a[not(contains(@class,'hidden'))]")
    stok_bildirim_mesaj = (By.ID, "evamToolTipTop")
    urun_detay_sayfasi_basligi = (By.XPATH, "//div[@id='rightInfoBar']//div[@class='product-title']")


class ProductDetailPage:
    def __init__(self):
        self.driver = Driver.get()

    def baslik_kontrol(self, urun_basligi):
        if urun_basligi.lower() in Helper.getText(Elements.urun_detay_sayfasi_basligi).lower():
            assert True
            print(f"Doğru ürüne giriş yapıldı. Başlık: {Helper.getText(Elements.urun_detay_sayfasi_basligi)}")
        else:
            assert False, f"Doğru ürüne giriş yapılamadı. Beklenen: {urun_basligi} Görüntülenen: {Helper.getText(Elements.urun_detay_sayfasi_basligi)}"
            print(
                f"Doğru ürüne giriş yapılamadı. Beklenen: {urun_basligi} Görüntülenen: {Helper.getText(Elements.urun_detay_sayfasi_basligi)}")

    def sepete_ekle_butonuna_tikla(self):
        while Helper.getText(Elements.urun_sepete_ekle_btn) != "SEPETE EKLE":
            print("Ürünün stoklarının tükendiği görüntülendi. Başka bir ürüne geçiş yapılıyor.")
            Helper.click_element(Elements.stok_bildirim_mesaj)
            HomePage.herhangi_bir_kategori_menu_secim(self)
            HomePage.herhangi_bir_kategori_secim(self)
            CategoryPage.herhangi_bir_urun_detay_sayfasina_git(self)

        if Helper.getCount(Elements.beden_secenekleri) >= 1:
            ProductDetailPage.herhangi_bir_beden_sec(self)
        Helper.click_element(Elements.sepete_ekle_btn)
        print("Sepete ekle butonuna tıklandı.")

    def sepete_eklendi_mi(self):
        if Helper.is_displayed(Elements.sepete_eklendi_btn):
            assert True
            print("Sepete başarıyla eklendi.")
        else:
            assert False, "Sepete eklenemedi."
            print("Sepete eklenemedi.")

    def herhangi_bir_beden_sec(self):
        random_index = random.randint(0, Helper.getCount(Elements.beden_secenekleri) - 1)
        Helper.click_elements(Elements.beden_secenekleri, random_index)
        print("Rastgele beden seçildi.")

    def sepete_git(self):
        Helper.click_element(Elements.sepetim)
