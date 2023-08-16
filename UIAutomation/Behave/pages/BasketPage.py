import random
from selenium.webdriver.common.by import By

from pages.CategoryPage import CategoryPage
from pages.HomePage import HomePage
from utils.Driver import Driver
from utils.Helper import Helper


class Elements:
    sepet_durum = (By.XPATH, "//span[contains(text(),'Sepetim (1 Ürün)')]")


class BasketPage:
    def __init__(self):
        self.driver = Driver.get()

    def sepete_gidildi_mi(self):
        if Helper.isDisplayed(Elements.sepet_durum):
            assert True
            print("Sepete başarıyla gidildi.")
        else:
            assert False, "Sepete gidilemedi."
            print("Sepete gidilemedi.")
