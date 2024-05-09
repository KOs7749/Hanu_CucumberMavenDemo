package dinhthe.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static dinhthe.keywords.WebUI.*;

public class SupplierPage {

    //Open Supplier Page

    protected By menu = By.xpath("//a[@title='Phân hệ' and @class='header-link icon-thumbnails pop-done pop-control pop-control-click pop-connect']");
    protected By menuPurchaseSupply = By.xpath("//span[@class='app-menu-item-desc' and text()='Quản lý, giám sát quy trình mua hàng']");
    protected By iconSuggestMaterial = By.xpath("//a[@title='Tạo mới']");
    protected By submenuSupplier = By.xpath("//div[@class='list list-menu pop-box pop-box-mousemove pop-box-mousedown']//div[@class='title'][contains(text(),'Nhà cung cấp')]");
    protected By purchaseProposalScreen = By.xpath("//div[@id='header-title' and contains(div, 'Đề xuất vật tư')]");
    protected By iconSupplier = By.xpath("//i[@class='sidemenu-item-icon icon-shipped']");
    protected By headerListTitle = By.xpath("//span[contains(text(),'Danh sách nhà cung cấp')]");
    protected By boxSearch = By.xpath("//form[@class='form-ajax ajax-form-done']");
    protected By inputSearchName = By.xpath("//input[@placeholder='Tìm kiếm']");
    protected By searchResultLocator = By.xpath("//tr[contains(@class, 'table-row-body')]/td[@col='name']");

    protected By rowLocator = By.xpath("//tr[contains(@class, 'table-row-body')][1]");
    private By firstCheckbox = By.xpath("(//input[@type='checkbox'])[2]"); // assuming first checkbox
    private By deleteButton = By.xpath("//a[@title='Xóa']"); // delete button
    private By confirmDeleteButton = By.xpath("//div[@class='dialog-btns dialog-confirm-btns']//div[text()='Đồng ý']"); // confirm delete button
    private By cancelButton = By.xpath("//div[@class='dialog-btns dialog-confirm-btns']//div[text()='Hủy bỏ']"); // cancel delete button
    private By tableRow = By.xpath("//tr[contains(@class, 'table-row-body')]");
    private By tableRowChecked = By.xpath("//tr[contains(@class, 'table-row-body checked')]");
    private By checkboxLocator = By.xpath("//input[@name='ID[]']");
    protected By headerDetailSupplier = By.xpath("//a[normalize-space()='Thông tin chung']");


    public void selectMenuPurchase(String menuName) {
        clickElement(menu);
        clickElement(menuPurchaseSupply);
    }

    public void clickIconSupplier(String submenuName) {
        clickElement(iconSupplier);
        sleep(5);
    }

    public void verifySupplierListPageIsOpen() {
        boolean checkMenu = checkElementExist(headerListTitle);
        Assert.assertTrue(checkMenu, "The system is unable to open the screen for creating a new supplier");
    }

    public void selectFirstCheckbox() {
        clickElement(firstCheckbox);
        //boolean checkboxChecked = checkElementExist(tableRowChecked);
        // Assert.assertTrue(checkboxChecked, "checkbox has not been checked");
    }

    public void clickDeleteIcon() {
        clickElement(deleteButton);
    }

    public void clickButtonUpdate() {
        waitForElementVisible(confirmDeleteButton);
        clickElement(confirmDeleteButton);
        sleep(5);
    }

    public void selectMultipleSuppliers() {
        List<WebElement> checkboxes = getWebElements(checkboxLocator);
        for (int i = 0; i < 2; i++) {
            checkboxes.get(i).click();
        }
    }

    public void verifySupplierDeleted() {
        // Kiểm tra xem phần tử 'table-row-body checked' đã biến mất hoàn toàn sau khi xóa
        boolean isSupplierDeleted = checkElementNotExist(tableRowChecked);
        Assert.assertTrue(isSupplierDeleted, "Supplier is still present in the list after deletion.");
    }

    public void clickButtonCancel() {
        clickElement(cancelButton);
        sleep(5);
    }

    public void verifyCancelDelete() {
        boolean isPresent = checkElementExist(tableRow);
        Assert.assertTrue(isPresent, "Supplier is still present in the list");
    }
}



