from selenium import webdriver


class Driver:
    driver = None

    @staticmethod
    def get():
        if Driver.driver is None:
            Driver.driver = webdriver.Chrome()

        Driver.driver.maximize_window()
        Driver.driver.implicitly_wait(30)
        Driver.driver.set_page_load_timeout(60)

        return Driver.driver

    @staticmethod
    def close_driver():
        if Driver.driver is not None:
            Driver.driver.quit()
            Driver.driver = None
