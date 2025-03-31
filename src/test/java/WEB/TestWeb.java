package WEB;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.*;
import java.time.Duration;
import java.util.List;
import java.util.Scanner;

public class TestWeb {
    WebDriver driver = new ChromeDriver();

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.get("https://www.way2automation.com/angularjs-protractor/webtables/");
    }

    public void verifyUserIsOnTheUserListTable() {
        WebElement userTable = driver.findElement(By.xpath("//*[@class='smart-table table table-striped']"));
        userTable.isDisplayed();
    }
    public void clickAddUser() {
        WebElement adduser = driver.findElement(By.xpath("//*[@class='btn btn-link pull-right']"));
        adduser.click();
    }

    public void enterFirstName(String firstname) {
        WebElement firstName = driver.findElement(By.name("FirstName"));
        firstName.sendKeys(firstname);
    }

    public void enterLastName(String lastname) {
        WebElement lastName = driver.findElement(By.name("LastName"));
        lastName.sendKeys(lastname);
    }

    public void enterUserName(String username) throws IOException {
        String filePath = "src/test/resources/uniqueUsername.txt";
        String filePathNewUser = "src/test/resources/newUser.txt";
        int lastNumber = 0;

        File newUserFile = new File(filePathNewUser);
        File file = new File(filePath);
        if (file.exists()) {
            Scanner scanner = new Scanner(file);
            if (scanner.hasNextInt()) {
                lastNumber = scanner.nextInt();
            }
            scanner.close();
        }
        lastNumber++;
        String uniqueUserName = username + lastNumber;
        FileWriter writer = new FileWriter(file);
        FileWriter writeNewUser = new FileWriter(newUserFile);

        writeNewUser.write(uniqueUserName);
        writer.write(String.valueOf(lastNumber));

        writer.close();
        writeNewUser.close();

        WebElement userName = driver.findElement(By.name("UserName"));
        userName.sendKeys(uniqueUserName);
    }

    public void enterPassword(String pass) {
        WebElement password = driver.findElement(By.name("Password"));
        password.sendKeys(pass);
    }

    public void customerOption(String firstname) {
        if (firstname.equals("Company AAA")) {
            WebElement companyA = driver.findElement(By.xpath("//*[@value='15']"));
            companyA.click();
        } else {
            WebElement companyB = driver.findElement(By.xpath("//*[@value='16']"));
            companyB.click();
        }
    }

    public void roleOption(String role) {
        WebElement roleDropDown = driver.findElement(By.name("RoleId"));
        Select select = new Select(roleDropDown);
        if (role.equals("Sales Team")) {
            roleDropDown.click();
            select.selectByVisibleText("Sales Team");
            roleDropDown.click();
        } else if (role.equals("Customer")) {
            roleDropDown.click();
            select.selectByVisibleText("Customer");
            roleDropDown.click();
        } else {
            roleDropDown.click();
            select.selectByVisibleText("Admin");
            roleDropDown.click();
        }
    }

    public void enterEmail(String email) {
        WebElement emailAddress = driver.findElement(By.name("Email"));
        emailAddress.sendKeys(email);
    }

    public void enterCell(String cell) {
        WebElement cellphone = driver.findElement(By.name("Mobilephone"));
        cellphone.sendKeys(cell);
    }

    public void clickSave() {
        WebElement saveButton = driver.findElement(By.xpath("//*[@ng-click='save(user)']"));
        saveButton.click();
    }

    public void verifyUser() throws IOException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='smart-table table table-striped']")));
        String filePath = "src/test/resources/newUser.txt";

        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String username = reader.readLine();

        WebElement userTable = driver.findElement(By.xpath("//*[@class='smart-table table table-striped']"));

        List<WebElement> rows = userTable.findElements(By.tagName("tr"));

        boolean userExists = false;

        for (WebElement row : rows) {
            if (row.getText().contains(username)) {
                userExists = true;
                break;
            }
        }
        Assert.assertTrue(userExists,  username + " was not added to the table!");
        System.out.println("Test Passed: " + username + " was successfully added!");
    }


    public void closeWindow() {
        if (driver != null) {
            driver.quit();
        }
    }
}
