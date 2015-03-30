package pages;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by Filipe on 3/29/2015.
 */
public class HomePage extends FluentWebDriverPage{


    public HomePage(WebDriverProvider driverProvider){
        super(driverProvider);
    }

    public void navigateToPage(){
        get("http://rails-todo-demo.herokuapp.com");
    }

    public void signInWith(String username, String password){
        link(By.linkText("Sign In")).click();

        input(By.id("user_email")).sendKeys(username);
        input(By.id("user_password")).sendKeys(password);

        input(By.cssSelector(".btn.btn-primary")).click();
    }

    public void clicksOn(String link){
        link(By.linkText(link)).click();
    }

    public boolean verifyPage() {
        WebElement element = findElement(By.cssSelector("center>h1"));
        return element.getText().contains("ToDo App");
    }
}
