package dinhthe.stepdefinitions;

import dinhthe.constants.ConstantGlobal;
import dinhthe.hooks.TestContext;
import dinhthe.models.Supplier;
import dinhthe.pages.AddSupplierPage;
import dinhthe.pages.LoginPage;
import dinhthe.pages.SupplierPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepAddSupplier extends AddSupplierPage {

    AddSupplierPage addSupplierPage = new AddSupplierPage();
    SupplierPage supplierPage = new SupplierPage();
    LoginPage loginPage = new LoginPage();

    Supplier supplier;

    public StepAddSupplier(TestContext testContext) {
    }

    @Given("I am logged in successfully")
    public void iAmLoginSuccessfully() {
        loginPage.navigateToUrl();
        loginPage.enterUserNameAndPassword(ConstantGlobal.USERNAME, ConstantGlobal.PASSWORD);
        loginPage.clickLoginButton();
    }

    @Given("I select item {string}")
    public void iSelectItem(String item) {
        addSupplierPage.selectItemSupplier(item);
    }

    @Then("I should be taken to the page Add Supplier")
    public void iShouldBeTakenToThePageAddSupplier() {
        addSupplierPage.verifyOpenPagAddSupplier();
    }

    @When("I enter valid all fields")
    public void iEnterValidAllFields() {
        Supplier supplier = new Supplier("Lê văn thủy", "0355349275", "dtthe201@gmail.com", "20/01/2002", "024300206886", "17/12/2021");
        addSupplierPage.addSupplierNormal(supplier);
    }

    @And("I click the button {string}")
    public void iClickButtonUpdate(String buttonUpdate) {
        addSupplierPage.clickbuttonUpdate();
    }

    @Then("I should be taken to the page Supplier Detail")
    public void iShouldBeTakenToThePageSupplierDetail() {
        addSupplierPage.verifyAddSupplierSuccessfully();
    }

    @When("I enter valid Full name field, and leave other fields blank")
    public void iEnterValidNamedAndLeaveOtherFieldsBlank() {
        Supplier supplier = new Supplier("Lê Văn Thủy", "", "", "", "", "");
        addSupplierPage.addSupplierWhenOnlyName(supplier);
    }

    @Then("I should see error message 'Loại nhà cung cấp chưa nhập Mã nhà cung cấp chưa nhập'")
    public void iShouldSeeErrorMessage1() {
        addSupplierPage.checkErrorMessageWhenOnlyName();
    }

    @When("I enter valid Supplier Code field, and leave other fields blank")
    public void iEnterValidSupplierCodeAndLeaveOtherFieldsBlank() {
        addSupplierPage.addSupplierWhenOnlySupplierCode();
    }

    @Then("I should see error message 'Loại nhà cung cấp chưa nhập Tên khách hàng bắt buộc phải nhập'")
    public void iShouldSeeErrorMessage2() {
        addSupplierPage.checkErrorMessageWhenOnlyName();
    }

    @When("I enter valid Supplier Type field, and leave other fields blank")
    public void iEnterValidSupplierTypeAndLeaveOtherFieldsBlank() {
        addSupplierPage.addSupplierWhenOnlySupplierType();
    }

    @Then("I should see error message 'Mã nhà cung cấp chưa nhập Tên khách hàng bắt buộc phải nhập'")
    public void iShouldSeeErrorMessage3() {
        addSupplierPage.checkErrorMessageWhenOnlySupplierType();
    }

    @When("I leave all fields blank")
    public void iLeaveAllFieldsBlank() {
        addSupplierPage.addSupplierWithoutEnterRequiredField();
    }

    @Then("I should see error message 'Mã nhà cung cấp chưa nhập Tên khách hàng bắt buộc phải nhập Loại nhà cung cấp chưa nhập'")
    public void iShouldSeeErrorMessage4() {
        addSupplierPage.checkErrorMessageWithoutRequiredField();
    }

    @When("I enter invalid phone number format")
    public void iEnterInvalidPhoneNumber() {
        Supplier supplier = new Supplier("Lê Văn Thủy", "1234abcd!@#$", "dtthe201@gmail.com", "20/01/2002", "024300206868", "17/12/2021");
        addSupplierPage.addSupplierNormal(supplier);
    }

    @Then("I should see error message indicating incorrect phone number format")
    public void iShouldSeeErrorMessage5() {
        addSupplierPage.checkInvalidPhoneNumber();
    }

    @When("I enter invalid email format")
    public void iEnterInvalidEmailFormat() {
        Supplier supplier = new Supplier("Lê Văn Thủy", "0355349379", "dtthe", "20/01/2002", "0243002068866", "17/12/2021");
        addSupplierPage.addSupplierNormal(supplier);
    }

    @Then("I should see error message indicating incorrect email format")
    public void iShoulSeeErrorMessage6() {
        addSupplierPage.checkInvalidEmail();
    }

    @When("I enter invalid date of birth format")
    public void iEnterInvalidDateOfBirthFormat() {
        Supplier supplier = new Supplier("Lê Văn Thủy", "0355349373", "dtthe", "20012002", "024300206868", "17/12/2021");
        addSupplierPage.addSupplierNormal(supplier);
    }

    @Then("I should see error message indicating incorrect date of birth format")
    public void iShouldSeeErrorMessageIndicatingIncorrectDateOfBirthFormat() {
        checkAlertMessageDisplayed("Ngày sinh không hợp lệ (20012002)");
    }

    @When("I enter invalid id of date format")
    public void iEnterInvalidIDDateFormat() {
        Supplier supplier = new Supplier("Lê Văn Thủy", "0355349373", "dtthe", "20/01/2002", "024300206868", "17122021");
        addSupplierPage.addSupplierNormal(supplier);
    }

    @Then("I should see error message indicating incorrect id of date format")
    public void iShouldSeeErrorMessageIndicatingIncorrectIDDateFormat() {
        checkAlertMessageDisplayed("Ngày cấp không hợp lệ (17122021)");
    }

    @And("I click on the button 'Hủy bỏ'")
    public void iClickButtonCancel() {
        addSupplierPage.cancelAddSupplier();
    }

    @Then("I should be redirected to the previous page without adding a new supplier")
    public void iShouldRedirectPreviousPage() {
        addSupplierPage.checkReturnPagePurchaseProposalScreen();
    }

}
