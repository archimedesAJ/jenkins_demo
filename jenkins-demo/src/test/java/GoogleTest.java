import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleTest {
    ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter("target/Report.html");

    private WebDriver driver;

    //Setting up the page
    @BeforeClass
    public void setUp(){
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("My Report");
        extent.attachReporter(spark);

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void teardown(){
        extent.flush();
        driver.quit();

    }

    //Test to open the site
    @Test
    public void OpenSite() throws InterruptedException {
        ExtentTest test = extent.createTest("Confirm Page Title").assignAuthor("Abraham").assignCategory("Functional Test").assignDevice("Windows");
        driver.get("https://google.com/");
        String page_title = driver.getTitle();
        if (page_title.equals("Google")){
            test.pass("Test passed. Page titles match!");
        }
        else {
            test.fail("Test failed. Page titles mismatch!");
        }

        Thread.sleep(2000);
    }
}
