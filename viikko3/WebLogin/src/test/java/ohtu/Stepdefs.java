package ohtu;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Stepdefs {
    //WebDriver driver = new ChromeDriver();
    WebDriver driver = new HtmlUnitDriver();
    String baseUrl = "http://localhost:4567";
    
    @Given("login is selected")
    public void loginIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click();   
    }  
    
    @Given("new user is selected")
    public void newUserIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click();   
    }
    
    @Given("user with username {string} and password {string} is successfully created")
    public void userWithUsernameAndPasswordIsSuccesfullyCreated(String username, String password) {
    	newUserIsSelected();
    	validUsernameAndPasswordAndMatchingPasswordConfirmationAreGiven(username, password);
    	newUserIsCreated();
    }
    
    @Given("user with username {string} and password {string} is tried to be created")
    public void userWithUsernameAndPasswordIsTriedToBeCreated(String username, String password) {
    	newUserIsSelected();
    	registerWith(username, password, password);
    }
    
    @When("a valid username {string} and password {string} and matching password confirmation are entered")
    public void validUsernameAndPasswordAndMatchingPasswordConfirmationAreGiven(String username, String password) {
    	registerWith(username, password, password);
    }
    
    @When("correct username {string} and password {string} are given")
    public void correctUsernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }    
    
    @Then("user is logged in")
    public void userIsLoggedIn() {
        pageHasContent("Ohtu Application main page");
    }    
 
    @When("correct username {string} and incorrect password {string} are given")
    public void correctUsernameAndIncorrectPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }
    
    @When("nonexistent username {string} and any password {string} are given")
    public void nonExistentUsernameAndAnyPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }
    
    @When("too short username {string} and valid password {string} and matching password confirmation are entered")
    public void tooShortUsernameAndValidPasswordAndMatchingPasswordConfirmationAreGiven(String username, String password) {
    	registerWith(username, password, password);
    }
    
    @When("valid username {string} and too short password {string} and matching password confirmation are entered")
    public void validUsernameAndTooShortPasswordAndMatchingPasswordConfirmationAreGiven(String username, String password) {
    	registerWith(username, password, password);
    }
    
    @When("valid username {string} and password {string} and non-matching password confirmation are entered")
    public void validUsernameAndPasswordAndNonMatchingPasswordConfirmationAreGiven(String username, String password) {
    	registerWith(username, password, password + "a");
    }
    
    
    @Then("user is not logged in and error message is given")
    public void userIsNotLoggedInAndErrorMessageIsGiven() {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    }    
    
    @When("username {string} and password {string} are given")
    public void usernameAndPasswordAreGiven(String username, String password) throws Throwable {
        logInWith(username, password);
    }   
    
    @Then("system will respond {string}")
    public void systemWillRespond(String pageContent) throws Throwable {
        assertTrue(driver.getPageSource().contains(pageContent));
    }
    
    @Then("a new user is created")
    public void newUserIsCreated() {
    	pageHasContent("Welcome to Ohtu Application!");
    }
    
    @Then("user is not created and error {string} is reported")
    public void userIsNotCreatedAndErrorIsReported(String error) {
    	pageHasContent("Create username and give password");
    	pageHasContent(error);
    }
    
    @After
    public void tearDown(){
        driver.quit();
    }
        
    /* helper methods */
 
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }
        
    private void logInWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Give your credentials to login"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();  
    } 
    
    private void registerWith(String username, String password, String confirmation) {
        assertTrue(driver.getPageSource().contains("Create username and give password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(confirmation);
        element.submit();  
    } 
}
