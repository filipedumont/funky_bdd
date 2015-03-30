package steps;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import pages.Pages;

import static org.junit.Assert.assertTrue;

/**
 * Created by Filipe on 3/29/2015.
 */
public class TaskSteps {

    private final Pages pages;

    public TaskSteps(Pages pages){
        this.pages = pages;
    }

    @When("user adds new task $task")
    public void userAddsNewTask(String task){
        pages.taskPage().addNewTask(task);
    }

    @Then("new task $task should be created")
    public void verifyNewTask(String task){
        assertTrue(pages.taskPage().verifyNewTask(task));
    }

    @When("user hits $taskPrivacy on $task task")
    public void userHitsTaskPrivacyOnTask(String taskPrivacy, String task){
        pages.taskPage().changeTaskPrivacy(task, taskPrivacy);
    }

    @Then("$task task is set as $taskPrivacy")
    public void verifyTaskPrivacy(String task, String taskPrivacy){
        assertTrue(pages.taskPage().verifyTaskPrivacy(task, taskPrivacy));
    }

}
