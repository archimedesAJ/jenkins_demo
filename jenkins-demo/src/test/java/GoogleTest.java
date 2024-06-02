import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleTest {
    private WebDriver driver;

    //Setting up the page
    @BeforeClass
    public void setUp(){

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void teardown(){
        driver.quit();

    }

    //Test to open the site
    @Test
    public void OpenSite() throws InterruptedException {
        driver.get("https://google.com/");
        String page_title = driver.getTitle();
        if (page_title.equals("Google")){
            System.out.println("passed");
        }
        else {
            System.out.println("failed");
        }

        Thread.sleep(2000);
    }
}
