package selenium.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public abstract class PageObjectCommon {
    protected final WebDriver driver;
    protected final WebDriverWait wait;

    public PageObjectCommon(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public <V> V wait(Function<WebDriver, V> isTrue) {
        return wait.until(isTrue);
    }
}
