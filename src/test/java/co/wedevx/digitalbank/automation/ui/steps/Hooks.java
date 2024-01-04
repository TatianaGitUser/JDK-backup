package co.wedevx.digitalbank.automation.ui.steps;

import co.wedevx.digitalbank.automation.ui.utilities.DB_Utils;
import co.wedevx.digitalbank.automation.ui.utilities.Driver;
import io.cucumber.java.*;

import java.util.concurrent.TimeUnit;

import static co.wedevx.digitalbank.automation.ui.utilities.Driver.getDriver;

public class Hooks {
    @BeforeAll()
    public static void establishConnectionToDB(){
        DB_Utils.establishConnection();

    }
    @Before ("not @WithdrawFromSavings")// select cucumber//
    public void the_user_is_on_dbank_homepage() {
        getDriver().get("https://dbank-qa.wedevx.co/bank");
        getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @After ("not @NegativeRegistrationScenarios")
    public void afterEachScenario(Scenario scenario){
        Driver.takeScreenShotToFolder(scenario);
        Driver.takeScreenShot(scenario);
       // Driver.closeDriver();
    }
@AfterAll()
    public static void closeConnectionToDB(){
        DB_Utils.closeConnection();
}
}
