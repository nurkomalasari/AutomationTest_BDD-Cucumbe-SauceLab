package saucedemo.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//import java.util.concurrent.TimeUnit;

public class step {
    WebDriver driver;
    String baseurl = "https://www.saucedemo.com/";
    @Given("Sauce demo login page")
    public void sauceDemoLoginPage() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.setHeadless(false);
        driver = new ChromeDriver(opt);
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseurl);
            String loginPageAssert = driver.findElement(By.xpath("//div[@class='login_logo']")).getText();
            Assert.assertEquals(loginPageAssert, "Swag Labs");

    }

    @When("Input Username")
    public void inputUsername() {

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("Input Password")
    public void inputPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("Click login button")
    public void clickLoginButton() {
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @Then("User in products page")
    public void userInProductsPage() {

        String productPage = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        Assert.assertEquals(productPage, "Products");
    }

    @And("Input Invalid Password")
    public void inputInvalidPassword() {
        driver.findElement(By.id("password")).sendKeys("errorPass");
    }

    @Then("User get error message")
    public void userGetErrorMessage() {
        String ErrorLogin = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
        Assert.assertEquals(ErrorLogin, "Epic sadface: Username and password do not match any user in this service");
    }

    @And("Click one product")
    public void clickOneProduct() {
        driver.findElement(By.xpath("//div[@class='inventory_item_name ' and text()='Sauce Labs Backpack']")).click();
    }

    @And("Click add to cart")
    public void ClickAddToCart() {//*[@id="add-to-cart-sauce-labs-backpack"]
          driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
    }

    @Then("User in product page")
    public void userInProductPage() { 
        String clickAddToCart = driver.findElement(By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[1]")).getText();
        Assert.assertEquals(clickAddToCart, "Sauce Labs Backpack");

    }
    @And("Click cart icon")
    public void userClickCartIcon() {
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
    }

    @Then("The product is in cart page")
    public void theProductIsInCartPage() {
        String productAssert = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText();
        Assert.assertEquals(productAssert, "Sauce Labs Backpack");
    }

    @And("Click button remove")
    public void clickButtonRemove() {
        String product = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText();
        Assert.assertEquals(product, "Sauce Labs Backpack");
        driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-backpack\"]")).click();
    }

    @Then("The product is removed from cart page")
    public void theProductIsRemovedFromCartPage() {
        try{

            boolean eleExists = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).isDisplayed();
            if(eleExists)
            {

                Assert.assertTrue(false);
                // do stuff
            }
            else{
                // do other stuff
                Assert.assertTrue(true);
            }

        }catch (Exception e) {
            System.out.println(e);
            Assert.assertTrue(true);
        }
    }

    @And("Close the page")
    public void closeThePage() {
        driver.close();
    }

    @And("Input first name")
    public void inputFirstName() {
        driver.findElement(By.id("first-name")).sendKeys("Farhan");
    }

    @And("Click checkout button")
    public void clickCheckoutButton() {
        driver.findElement(By.id("checkout")).click();
    }

    @Then("User in information page")
    public void userInInformationPage() {
        String infoPageAssert = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals(infoPageAssert, "Checkout: Your Information");
    }

    @And("Input last name")
    public void inputLastName() {
        driver.findElement(By.id("last-name")).sendKeys("Tandia");
    }

    @And("Input postal code")
    public void inputPostalCode() {
        driver.findElement(By.id("postal-code")).sendKeys("12341");
    }

    @And("Click continue")
    public void clickContinue() {
        driver.findElement(By.id("continue")).click();
    }

    @Then("User in checkout overview page")
    public void userInCheckoutOverviewPage() {
        String formYourInfo = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals(formYourInfo, "Checkout: Overview");
    }

    @And("Click Finish")
    public void clickFinish() {
        driver.findElement(By.id("finish")).click();
    }

    @Then("User in checkout complete page")
    public void userInCheckoutCompletePage() {
        String formYourInfo = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals(formYourInfo, "Checkout: Complete!");
    }

    @Then("User get postal error message")
    public void userGetPostalErrorMessage() {
        String ErrorCheckout = driver.findElement(By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]/h3")).getText();
        Assert.assertEquals(ErrorCheckout, "Error: Postal Code is required");
    }

    @Then("Button change to remove")
    public void buttonChangeToRemove() {
        String changeRemove = driver.findElement(By.id("remove-sauce-labs-backpack")).getText();
        Assert.assertEquals(changeRemove, "Remove");
    }

    @Then("Button change to add to cart")
    public void buttonChangeToAddToCart() {
        String changeAddToCart = driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).getText();
        Assert.assertEquals(changeAddToCart, "Add to cart");
    }
}
