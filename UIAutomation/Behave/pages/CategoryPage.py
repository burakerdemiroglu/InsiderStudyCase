import random
from selenium.webdriver.common.by import By

from pages.HomePage import HomePage
from utils.Driver import Driver
from utils.Helper import Helper


class Elements:
    URUN_ADI_LISTESI = (By.XPATH, "//div[@class='product-image']//ancestor::a[1]//h5[@class='product-card__title']")
    URUN_SAYISI = (By.XPATH, "//span[@class='product-list-heading__product-count']/p")
    ARAMA_KUTUSU = (By.XPATH, "//input[@placeholder='Ürün, kategori veya marka ara']")
    FILTREYI_GIZLE_BTN = (By.XPATH, "//span[text()='Filtreyi Gizle']")


class CategoryPage:
    def __init__(self):
        self.driver = Driver.get()

    def herhangi_bir_urun_detay_sayfasina_git(self):
        while Helper.getAttribute(Elements.ARAMA_KUTUSU, "id") == "search_input":
            print("Aradığın sayfaya şu an ulaşılmıyor hatası alındı. Başka ürüne geçiş yapılıyor.")
            HomePage.ana_sayfaya_git(self)
            HomePage.herhangi_bir_kategori_menu_secim(self)
            HomePage.herhangi_bir_kategori_secim(self)

        while Helper.getText(Elements.URUN_SAYISI) == "0 ürün listelendi.":
            print("Kategoride ürün bulunmuyor. Tekrar seçim yapılacak.")
            HomePage.herhangi_bir_kategori_menu_secim(self)
            HomePage.herhangi_bir_kategori_secim(self)

        random_index = random.randint(0, Helper.getCount(Elements.URUN_ADI_LISTESI) - 1)
        urun_basligi = Helper.getTexts(Elements.URUN_ADI_LISTESI, random_index)

        Helper.click_elements(Elements.URUN_ADI_LISTESI, random_index)

        return urun_basligi

    def kategori_acildi_mi(self):
        if Helper.isDisplayed(Elements.FILTREYI_GIZLE_BTN):
            assert True
            print("Kategori sayfası açıldı.")
        else:
            assert False, "Kategori sayfası açılamadı."
