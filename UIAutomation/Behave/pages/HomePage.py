import random
from selenium.webdriver.common.by import By
from utils.Driver import Driver
from utils.Helper import Helper


class Elements:
    TUM_CEREZLERE_IZIN_VER = (By.XPATH, "//div[@id='cookieseal-banner']//button[text()='Tüm Çerezlere İzin Ver']")
    KATEGORI_MENU_SECIM = (By.XPATH, "//div[@class='mega-menu ']//ancestor::li[@class='menu-header-item  ']")
    KATEGORI_SECIM = (
        By.XPATH, "//li[@class='menu-header-item menu-header-item--active ']//ul[@class='zones-lists-items']//a")
    ANA_SAYFA_LOGO = (By.CSS_SELECTOR, ".main-header-logo")
    ANA_SAYFA_SLAYT_RESMI = (By.CSS_SELECTOR, ".full-width-slider.full-width-slider--horizontal ")
    EL_SEARCH_BUTTON = (By.XPATH, "//input[@value='Search']")


class HomePage:
    def __init__(self):
        self.driver = Driver.get()

    def tum_cerezlere_izin_ver(self):
        Helper.click_element(Elements.TUM_CEREZLERE_IZIN_VER)

    def herhangi_bir_kategori_menu_secim(self):
        random_index = random.randint(0, Helper.getCount(Elements.KATEGORI_MENU_SECIM) - 1)
        print(f"Header bölümündeki menülerden '{Helper.getTexts(Elements.KATEGORI_MENU_SECIM, random_index)}' fareyle üzerine gelindi.")

        Helper.hover_elements(Elements.KATEGORI_MENU_SECIM, random_index)


    def herhangi_bir_kategori_secim(self):
        random_index = random.randint(0, Helper.getCount(Elements.KATEGORI_SECIM) - 1)
        print(f"Header bölümündeki kategorilerden '{Helper.getTexts(Elements.KATEGORI_SECIM, random_index)}' tıklandı.")

        Helper.click_elements(Elements.KATEGORI_SECIM, random_index)


    def ana_sayfaya_git(self):
        Helper.click_element(Elements.ANA_SAYFA_LOGO)

    def ana_sayfa_acildi_mi(self):
        if Helper.is_displayed(Elements.ANA_SAYFA_SLAYT_RESMI):
            print("Ana sayfa açıldı.")
        else:
            raise AssertionError("Ana sayfa açılmadı veya slayt görüntülenemedi.")
