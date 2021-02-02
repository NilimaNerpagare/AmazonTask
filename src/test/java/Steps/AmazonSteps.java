package Steps;

import com.sun.source.tree.IfTree;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class AmazonSteps {

    WebDriver driver = null;

    @Given("User opens the browser")
    public void userOpensTheBrowser() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        System.out.println("1. Chrome browser is opened");

    }

    @And("navigate to Amazon webpage")
    public void navigateToAmazonWebpage() {
        driver.get("http://amazon.com");
        System.out.println("2. Amazon.com WebPage Opened");
    }

    @And("Search for Nikon Product")
    public void searchForNikonProduct() {
        System.out.println("3. Searching for Nikon product");
        driver.findElement(By.id("twotabsearchtextbox")).click();
        driver.findElement(By.id("twotabsearchtextbox")).clear();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nikon");
        driver.findElement(By.id("nav-search-submit-button")).click();
        System.out.println("...and Search results displayed");
    }

    @And("Sort the results using filter")
    public void sortTheResultsUsingFilter() {
        System.out.println("4. Checking filter options for search results");
        driver.findElement(By.id("a-autoid-0-announce")).click();

    }

    @And("selects the filter as highest price to Lowest")
    public void selectsTheFilterAsHighestPriceToLowest() {
        System.out.println("5. Selecting filter as Price from Highest to Lowest for search results");
        driver.findElement(By.id("s-result-sort-select_2")).click();
        System.out.println("...and Search results are now arranged in the order of Highest to Lowest Price");

    }

    @And("selects the second product")
    public void selectsTheSecondProduct() {
        System.out.println("6. Selecting the second product from the displayed and rearranged search results");
        driver.findElement(By.xpath("//div[@id='search']/div/div[2]/div/span[3]/div[2]/div[2]/div/span/div/div/div[2]/div[2]/div/div/div/div/div/h2/a/span")).click();
    }

    @And("open the product details")
    public void openTheProductDetails() {
        System.out.println("7. Opened the Product Details for the second product in the Search Result list");
    }

    @Then("verify if the product details display Nikon D{int}X")
    public void verifyIfTheProductDetailsDisplayNikonDX(int arg0) {
        String ProductTitle = driver.findElement(By.id("productTitle")).getText();
        System.out.println("Second product found is " +ProductTitle);

        Assert.assertTrue("8. Nikon D3X is Not Found", ProductTitle.contains("Nikon D3X"));
        System.out.println("8. Nikon D3X Product is found");
    }


}