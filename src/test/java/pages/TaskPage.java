package pages;

import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.seleniumhq.selenium.fluent.FluentWebElement;
import org.seleniumhq.selenium.fluent.FluentWebElements;

import java.util.List;

/**
 * Created by ffranca on 3/30/15.
 */
public class TaskPage extends FluentWebDriverPage {
    public TaskPage(WebDriverProvider driverProvider) {
        super(driverProvider);
    }

    public boolean verifyPage(){
        return getCurrentUrl().contains("/tasks");
    }

    public void addNewTask(String task) {
        input(By.id("new_task")).click().sendKeys(task).sendKeys(Keys.ENTER);
    }

    public boolean verifyNewTask(String task) {
        WebElement element = findElement(By.cssSelector(".ng-scope.ng-binding.editable.editable-click"));
        return element.getText().contains(task);
    }


    public void changeTaskPrivacy(String task, String taskPrivacy) {
       List<WebElement> rowElements = findElements(By.tagName("tr"));

        for(WebElement row : rowElements){
            List<WebElement> cells = row.findElements(By.tagName("td"));

            if(cells.size() > 1){
                //task fixed column 1
                if(task.equals(cells.get(1).getText())){
                    // task privacy fixed column 2
                    WebElement element = cells.get(2).findElement(By.cssSelector(".ng-pristine.ng-valid"));
                    if("public".equals(taskPrivacy)) {
                        if ("task.public".equals(element.getAttribute("ng-model")) && !element.isSelected())
                            element.click();
                    }
                    else if("private".equals(taskPrivacy)){
                        if("task.public".equals(element.getAttribute("ng-model")) && element.isSelected())
                            element.click();
                    }
                }
            }

        }
    }

    public boolean verifyTaskPrivacy(String task, String taskPrivacy) {
        List<WebElement> rowElements = findElements(By.tagName("tr"));

        for (WebElement row : rowElements) {
            List<WebElement> cells = row.findElements(By.tagName("td"));

            if (cells.size() > 1)
                //task fixed column 1
                if (task.equals(cells.get(1).getText())) {
                    // task privacy fixed column 2
                    WebElement element = cells.get(2).findElement(By.cssSelector(".ng-valid"));
                    if ("public".equals(taskPrivacy))
                        return element.isSelected();
                     else if("private".equals(taskPrivacy))
                        return !element.isSelected();

                }
        }
        return false;
    }

    public void clicksOn(String link) {
        button(By.partialLinkText(link)).click();
    }
}
