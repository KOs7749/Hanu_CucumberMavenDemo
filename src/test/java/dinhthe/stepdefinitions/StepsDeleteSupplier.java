package dinhthe.stepdefinitions;

import dinhthe.hooks.TestContext;
import dinhthe.pages.LoginPage;
import dinhthe.pages.SupplierPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class StepsDeleteSupplier {

    SupplierPage supplierPage = new SupplierPage();
    LoginPage loginPage = new LoginPage();

    public StepsDeleteSupplier(TestContext testContext) {
        supplierPage = new SupplierPage();
    }

    @And("I select menu {string}")
    public void iSelectMenu(String menuName) {
        supplierPage.selectMenuPurchase(menuName);
    }

    @When("I click submenu {string}")
    public void i_click_submenu(String submenuName) {
        // Method to click submenu
        supplierPage.clickIconSupplier(submenuName);
    }

    @Then("I should be taken to the page Supplier List")
    public void i_should_be_taken_to_page_supplier_list() {
        // Method to verify if the Supplier List page is opened
        supplierPage.verifySupplierListPageIsOpen();
    }

    @When("I select one supplier checkbox")
    public void i_select_one_supplier_checkbox() {
        supplierPage.selectFirstCheckbox();
    }

    @And("I click delete icon")
    public void i_cick_delete_icon() {
        supplierPage.clickDeleteIcon();
    }

    @And("I click button Update")
    public void i_click_button_update() {
        supplierPage.clickButtonUpdate();
    }

    @And("I click button Cancel")
    public void i_click_button_cancel() {
        supplierPage.clickButtonCancel();
    }

    @Then("I should see a supplier deleted successfully")
    public void the_supplier_is_deleted_successfully() {
        supplierPage.verifySupplierDeleted();
    }

    @When("I select more than one supplier checkbox")
    public void i_select_multiple_supplier_checkbox() {
        supplierPage.selectMultipleSuppliers();
    }

    @Then("I should see suppliers deleted successfully")
    public void the_suppliers_is_deleted_successfully() {
        supplierPage.verifySupplierDeleted();
    }

    @Then("I should see that supplier still exists in the list")
    public void i_should_see_supplier_in_list() {
        supplierPage.verifyCancelDelete();
    }
}
