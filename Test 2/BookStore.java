package Test2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BookStore {
    public static void main (String[] args) throws InterruptedException {
        String DriverPathExe = ("C:\\Users\\workspace\\chromedriver\\chromedriver.exe");
        System.setProperty("webdriver.driver.chrome", DriverPathExe);

        WebDriver driver = new ChromeDriver();

        String Url = ("https://demoqa.com/books");
        driver.get(Url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

        //Login page
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();

        WebElement username = driver.findElement(By.id("userName"));
        WebElement password = driver.findElement(By.id("password"));

        for (int i=0;i<4;i++){
            driver.findElement(By.id("userName")).clear();
            driver.findElement(By.id("password")).clear();
            WebElement username1 = new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.id("userName")));
            WebElement password1 = new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
            //WebElement login1 = new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.id("login")));
            if (i==0){
                username1.sendKeys("test salah");
                password1.sendKeys("Welcome@123salah");
                driver.findElement(By.id("login")).click();
            } else if (i==1){
                username1.sendKeys("test");
                password1.sendKeys("passwordsalah");
                driver.findElement(By.id("login")).click();
            } else if (i==2){
                username1.sendKeys("username salah");
                password1.sendKeys("Welcome@123");
                driver.findElement(By.id("login")).click();
            } else if (i==3){
                username1.sendKeys("");
                password1.sendKeys("Welcome@123");
                driver.findElement(By.id("login")).click();
                break;
            }
        }
        driver.findElement(By.id("userName")).clear();
        driver.findElement(By.id("userName")).sendKeys("test");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("Welcome@123");
        driver.findElement(By.id("login")).click();

        Select selectRows = new Select(driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]/span[2]/select[1]")));
        selectRows.selectByValue("5");

        WebElement nextButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/div/div[3]/button"));
        nextButton.click();
        WebElement previousButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/div/div[1]/button"));
        previousButton.click();

        driver.findElement(By.xpath("//a[contains(text(),'Git Pocket Guide')]")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement tambahkoleksi = driver.findElement(By.xpath("//button[contains(text(),'Add To Your Collection')]"));
        js.executeScript("arguments[0].click()", tambahkoleksi);
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
        WebElement backStoreBook = driver.findElement(By.xpath("//button[contains(text(),'Back To Book Store')]"));
        js.executeScript("arguments[0].click()", backStoreBook);

        driver.findElement(By.xpath("//a[contains(text(),'Learning JavaScript Design Patterns')]")).click();
        js.executeScript("arguments[0].click()", driver.findElement(By.xpath("//button[contains(text(),'Add To Your Collection')]")));
        Thread.sleep(5000);
        driver.switchTo().alert().accept();

        WebElement profileMenu = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[6]/div[1]/ul[1]/li[3]"));
        js.executeScript("arguments[0].click()", profileMenu);

        WebElement hapus = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[5]/div[1]/span[1]/*[1]"));
        hapus.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@id='closeSmallModal-ok']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        WebElement hapusAll= driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/div[3]/div[3]/button[1]"));
        js.executeScript("arguments[0].click()", hapusAll);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@id='closeSmallModal-ok']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        //logout
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();

        driver.quit();

        //WebElement backStoreBook = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"addNewRecordButton\"]")));
        //backStoreBook.click();
    }

}
