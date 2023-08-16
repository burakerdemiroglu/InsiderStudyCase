import time
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.action_chains import ActionChains
from utils.Driver import Driver


class Helper:
    driver = Driver.get()
    builder = ActionChains(Driver.get())
    wait = WebDriverWait(Driver.get(), timeout=20)

    @staticmethod
    def click_element(element):
        Helper.driver.find_element(*element).click()

    @staticmethod
    def click_elements(element, index):
        Helper.driver.find_elements(*element)[index].click()

    @staticmethod
    def send_keys_element(element, value):
        Helper.wait.until(EC.visibility_of_element_located(element))
        Helper.driver.find_element(*element).send_keys(value)

    @staticmethod
    def navigate_to_url(url):
        Driver.get().get(url)

    @staticmethod
    def scroll_into_view(element):
        Helper.driver.execute_script("arguments[0].scrollIntoView(true);", Helper.driver.find_element(*element))

    @staticmethod
    def is_displayed(element):
        Helper.wait.until(EC.visibility_of_element_located(element))
        return Helper.driver.find_element(*element).is_displayed()

    @staticmethod
    def click_with_link_text(link_text):
        Helper.driver.find_element(By.LINK_TEXT, link_text).click()

    @staticmethod
    def hover_element(element):
        Helper.builder.move_to_element(Helper.driver.find_element(*element)).perform()

    @staticmethod
    def hover_elements(element, index):
        Helper.builder.move_to_element(Helper.driver.find_elements(*element)[index]).perform()

    @staticmethod
    def getCount(element):
        return len(Helper.driver.find_elements(*element))

    @staticmethod
    def isDisplayed(element):
        return Helper.driver.find_element(*element).is_displayed()

    @staticmethod
    def getTexts(element, index):
        return Helper.driver.find_elements(*element)[index].text

    @staticmethod
    def getText(element):
        return Helper.driver.find_element(*element).text

    @staticmethod
    def getAttribute(element, attribute):
        return Helper.driver.find_element(*element).get_attribute(attribute)

    @staticmethod
    def switch_last_tab():
        original_tab = Helper.driver.current_window_handle
        all_tabs = Helper.driver.window_handles

        for tab in all_tabs:
            if original_tab != tab:
                Helper.driver.switch_to.window(tab)
