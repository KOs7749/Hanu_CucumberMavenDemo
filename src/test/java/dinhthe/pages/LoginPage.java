package dinhthe.pages;

import dinhthe.constants.ConstantGlobal;
import dinhthe.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static dinhthe.keywords.WebUI.*;

public class LoginPage {
    //Khai báo Objects
    private By inputUserName = By.xpath("//input[@id='username']");
    private By inputPassword = By.xpath("//input[@id='userpwd']");
    private By buttonLogin = By.xpath("//button[@type='submit']");
    private By errorMessage = By.xpath("//div[@class='form-error-text']");
    private By linkForgotPassword = By.xpath("//a[contains(text(),'Quên mật khẩu?')]");
    private By recoverPassword = By.xpath("//div[@class='form-title'][contains(text(),'Lấy lại mật khẩu')]");


    //Hàm xử lý đặc trưng cho Login Page
    public void navigateToUrl() {
        openURL(ConstantGlobal.URL);
    }

    public void enterUserNameAndPassword(String username, String password) {
        setText(inputUserName, username);
        setText(inputPassword, password);
    }

    public void clickLoginButton() {
        clickElement(buttonLogin);
    }

    public void verifyLoginFail() {
        boolean checkAlertError = WebUI.checkElementExist(errorMessage);
        Assert.assertTrue(checkAlertError, "Fail. Error message not display.");
        verifyEquals(WebUI.getElementText(errorMessage), "Tài khoản hoặc mật khẩu không đúng");
    }

    public void UILoginPage() {
        // Kiểm tra tồn tại các phần tử trên trang đăng nhập
        Assert.assertTrue(WebUI.checkElementExist(inputUserName), "Input username field is not found.");
        Assert.assertTrue(WebUI.checkElementExist(inputPassword), "Input password field is not found.");
        Assert.assertTrue(WebUI.checkElementExist(buttonLogin), "Sign in button is not found.");
        Assert.assertTrue(WebUI.checkElementExist(linkForgotPassword), "Forgot password link is not found.");

        // Kiểm tra văn bản và thuộc tính của các phần tử
        Assert.assertEquals(WebUI.getElementText(By.xpath("//div[@class='form-title']")), "Đăng nhập", "Title is incorrect");
        Assert.assertEquals(WebUI.getElementText(By.xpath("//label[contains(text(),'Tên đăng nhập*')]")), "Tên đăng nhập*", "Username field label is incorrect.");
        Assert.assertEquals(WebUI.getElementText(By.xpath("//label[contains(text(),'Mật khẩu*')]")), "Mật khẩu*", "Password field label is incorrect.");

        // Kiểm tra trạng thái mặc định của checkbox
        WebElement rememberMeCheckbox = WebUI.getWebElement(By.xpath("//label[text()='Giữ tôi luôn đăng nhập']/preceding::input[@type='checkbox']"));
        Assert.assertTrue(rememberMeCheckbox.isSelected(), "Remember me checkbox is not checked.");

        // Kiểm tra các liên kết tải ứng dụng trên điện thoại
        Assert.assertTrue(WebUI.checkElementExist(By.xpath("//div[contains(text(),'Cài đặt ứng dụng trên điện thoại')]/following::div/a[@href='https://play.google.com/store/apps/details?id=vn.oneoffice.oneoffice']")), "Android app link is not found.");
        Assert.assertTrue(WebUI.checkElementExist(By.xpath("//div[contains(text(),'Cài đặt ứng dụng trên điện thoại')]/following::div/a[@href='https://itunes.apple.com/us/app/1office/id1272801903?l=vi&ls=1&mt=8']")), "iOS app link is not found.");
    }

    public void clickLinkableForgotPassword() {
        clickElement(linkForgotPassword);
        boolean checkMenu = WebUI.checkElementExist(recoverPassword);
        Assert.assertTrue(checkMenu, "Password recover page not found");
    }

}
