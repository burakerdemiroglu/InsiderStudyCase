package Case.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Helper {

    private final WebDriver driver;
    private final Actions builder;
    private WebDriverWait wait;
    int timeOut = 20;

    public Helper() {
        driver = Driver.get();
        builder = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
    }

    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void sendKeysElement(WebElement element, String value) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(value);
    }

    public void navigateToUrl(String url) {
        driver.get(url);
        Log4j.info(String.format("'%s' linkine gidildi.", driver.getCurrentUrl()));
    }

    public String getText(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    public void scrollIntoView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public Boolean isDisplayed(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }

    public static void clickWithLinkText(String linktext) {
        Driver.get().findElement(By.linkText(linktext)).click();
    }

    public void hoverElement(WebElement element) {
        builder.moveToElement(element).perform();
    }

    public static void switchLastTab() {
        String originTab = Driver.get().getWindowHandle();
        Set<String> allTabs = Driver.get().getWindowHandles();

        for (String tab : allTabs) {
            if (!originTab.equals(tab)) {
                Driver.get().switchTo().window(tab);
            }
        }
    }
}