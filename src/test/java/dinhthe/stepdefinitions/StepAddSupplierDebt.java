package dinhthe.stepdefinitions;

import dinhthe.pages.AddSupplierDebt;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepAddSupplierDebt {
    AddSupplierDebt addSupplierDebt = new AddSupplierDebt();

    @When("^I click on the supplier code$")
    public void i_click_on_the_supplier_code() {
        addSupplierDebt.openPageSupplierDetail();
    }

    @When("^I hover icon \"([^\"]*)\", click \"([^\"]*)\"$")
    public void i_hover_icon_click(String icon, String action) {
        addSupplierDebt.addOpenPopupDebt();
    }

    @Then("^I should see a pop-up to add new debt to the supplier$")
    public void i_should_see_a_pop_up_to_add_new_debt_to_the_supplier() {
        addSupplierDebt.verifySupplierDebtPopUp();
    }

    @When("^I enter valid fields for adding new debt$")
    public void i_enter_valid_fields_for_adding_new_debt() {
        addSupplierDebt.addDebtNormal("12/12/2023", "1000000", "Chưa thanh toán");
    }

    @When("^I click on button \"([^\"]*)\"$")
    public void i_click_the_button(String button) {
        addSupplierDebt.clickButtonUpdate();
    }

    @Then("^I should see the debt was added successfully$")
    public void i_should_see_the_debt_was_added_successfully() {
        addSupplierDebt.verifyCreateDebtSuccessful();
    }

    @When("^I enter only the required field \\[Date\\], and leave other fields blanks$")
    public void i_enter_only_the_required_field_date() {
        addSupplierDebt.addDebtWhenOnlyDate("12/12/2023");
    }

    @Then("^I should see an error message indicating that \\[Money\\] and \\[Reason\\] fields are missing$")
    public void i_should_see_an_error_message_indicating_that_money_and_reason_fields_are_missing() {
        addSupplierDebt.checkErrorWhenOnlyDate();
    }

    @When("^I enter only the required field \\[Money\\], and leave other fields blanks$")
    public void i_enter_only_the_required_field_money() {
        addSupplierDebt.addDebtNormal("", "1000000", "");
    }

    @Then("^I should see an error message indicating that \\[Date\\] and \\[Reason\\] fields are missing$")
    public void i_should_see_an_error_message_indicating_that_date_and_reason_fields_are_missing() {
        addSupplierDebt.checkErrorWhenOnlyMoney();
    }

    @When("^I enter only the required field \\[Reason\\], and leave other fields blanks$")
    public void i_enter_only_the_required_field_reason() {
        addSupplierDebt.addDebtNormal("", "", "Chưa thanh toán");
    }

    @Then("^I should see an error message indicating that \\[Date\\] and \\[Money\\] fields are missing$")
    public void i_should_see_an_error_message_indicating_that_date_and_money_fields_are_missing() {
        addSupplierDebt.CheckErrorWhenOnlyReason();
    }

    @When("^I do not enter any required fields$")
    public void i_do_not_enter_any_required_fields() {
    }

    @Then("^I should see error messages indicating that all required fields are missing$")
    public void i_should_see_error_messages_indicating_that_all_required_fields_are_missing() {
        addSupplierDebt.CheckErrorWhenWithoutRequiredFields();
    }

    @When("^I enter an incorrect date format$")
    public void i_enter_an_incorrect_date_format() {
        addSupplierDebt.addDebtNormal("12122023", "1000000", "Chưa thanh toán");
    }

    @Then("^I should see an error message indicating that the date format is incorrect$")
    public void i_should_see_an_error_message_indicating_that_the_date_format_is_incorrect() {
        addSupplierDebt.checkAlertMessageDisplayed("Ngày không hợp lệ (12122023)");
    }

    @When("^I enter more than 300 characters in the \\[Reason\\] field$")
    public void i_enter_more_than_300_characters_at_reason_field() {
        addSupplierDebt.addDebtNormal("12/12/2023", "1000000", "Lorem ipsum dolor sit amet, elit. Quisque malesuada blandit. In non viverra arcu. Suspendisse non urna sem. Fusce consequat dapibus tellus, et rhoncus est efficitur nec. In ut egestas sem, a condimentum augue. Fusce pharetra purus nec felis mollis venenatis porttitor. consectetur adipiscing ultrices112");
    }

    @Then("^I should see an error message indicating that the reason field exceeds the character limit$")
    public void i_should_see_an_error_message_indicating_that_the_reason_field_exceeds_the_character_limit() {
        addSupplierDebt.checkErrorWithMaxlengthReason();
    }

    @When("^I decide to cancel adding new debt$")
    public void i_decide_to_cancel_adding_new_debt() {
        addSupplierDebt.cancelAddDebt();
    }

    @Then("^The pop-up should be closed$")
    public void the_popup_should_be_closed() {
        addSupplierDebt.checkClosePopup();
    }

}
