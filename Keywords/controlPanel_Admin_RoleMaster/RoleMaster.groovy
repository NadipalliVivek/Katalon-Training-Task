package controlPanel_Admin_RoleMaster
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import org.apache.commons.lang.RandomStringUtils
import internal.GlobalVariable

public class RoleMaster {

	//This method is used for navigating to role master page
	@Keyword
	public static void navigatingtorolemaster() {
		WebUI.switchToFrame(findTestObject('Control Panel/Admin/Role Master/Switch to Frame'), GlobalVariable.smallDelay)
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin button'))
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/Role Master/Role Master Button'))
		WebUI.delay(GlobalVariable.mediumDelay)
		WebUI.switchToDefaultContent()
		WebUI.delay(GlobalVariable.mediumDelay)
		WebUI.switchToFrame(findTestObject('Object Repository/Control Panel/Admin/Role Master/Switch to Role master content frame'), GlobalVariable.smallDelay)
		WebUI.switchToFrame(findTestObject('Object Repository/Control Panel/Admin/Role Master/Switch to iframe'), GlobalVariable.smallDelay)
	}

	//This method is to crate contractor role
	@Keyword
	public static String contractor_Role() {
		String selectMessage = 'Select atleast one Company/Department/Trade under View Access'
		String modulesMessage = 'Please select at least one function in any one module'
		String sucessMessage = 'Role created successfully'
		WebUI.delay(GlobalVariable.smallDelay)
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/Role Master/Add Button'))
		WebUI.delay(GlobalVariable.smallDelay)
		WebUI.switchToFrame(findTestObject('Control Panel/Admin/Role Master/Switch to Add new role popup'), GlobalVariable.smallDelay)
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/Role Master/Add Role_Save Button'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Control Panel/Admin/Role Master/Astrisk for role name'), GlobalVariable.smallDelay)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Control Panel/Admin/User Master/Astrisk for event notification template'),GlobalVariable.smallDelay)
		String charset = (('A'..'Z') + ('a'..'z') + ('0'..'9')).join()
		def length = 8
		String randomRoleName = RandomStringUtils.random(length, charset.toCharArray())
		println(randomRoleName)
		WebUI.setText(findTestObject('Object Repository/Control Panel/Admin/Role Master/Add Role Textbox'), randomRoleName)
		WebUI.setText(findTestObject('Object Repository/Control Panel/Admin/Role Master/Role Description'), 'Is contractr Role- Yes')
		WebUI.check(findTestObject('Object Repository/Control Panel/Admin/Role Master/IS Contractor Role Radio Button- Yes'))
		WebUI.delay(GlobalVariable.smallDelay)
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/Role Master/Event Notification Templete'))
		WebUI.delay(GlobalVariable.smallDelay)
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/Role Master/Option in Event Notification Templete'))
		WebUI.delay(GlobalVariable.smallDelay)
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/Role Master/Add Role_Save Button'))
		WebUI.delay(1)
		String ActualModulesMessage = WebUI.getText(findTestObject('Object Repository/Control Panel/Admin/Role Master/Select option from modules'))
		if(ActualModulesMessage.equals(modulesMessage)){
			println ActualModulesMessage
		}
		else {
			println 'select options in modules message is not displayed'
		}
		WebUI.check(findTestObject('Object Repository/Control Panel/Admin/Role Master/Modules_Control Panel Check box'))
		WebUI.delay(GlobalVariable.mediumDelay)
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/Role Master/Add Role_Save Button'))
		String ListBoxMessage = WebUI.getText(findTestObject('Object Repository/Control Panel/Admin/Role Master/Select atleast one Company Department Trade under View Access message'))
		if(ListBoxMessage.equals(selectMessage)){
			println ListBoxMessage
		}
		else{
			println 'company, Trade, department message is not displayed'
		}
		WebUI.delay(GlobalVariable.mediumDelay)
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/Role Master/Option in Company list box'))
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/Role Master/Option in Department list box'))
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/Role Master/option in Trade list box'))
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/Role Master/Add Role_Save Button'))
		WebUI.delay(1)
		WebUI.switchToDefaultContent()
		WebUI.delay(GlobalVariable.smallDelay)
		WebUI.switchToFrame(findTestObject('Object Repository/Control Panel/Admin/Role Master/Switch to Role master content frame'), GlobalVariable.smallDelay)
		WebUI.switchToFrame(findTestObject('Object Repository/Control Panel/Admin/Role Master/Switch to iframe'), GlobalVariable.smallDelay)
		WebUI.verifyElementText(findTestObject('Object Repository/Control Panel/Admin/Role Master/Role created successfully message'), sucessMessage)
		println sucessMessage
		return randomRoleName
	}

	//This method is used to update contact role
	@Keyword
	public static void update_contractorRole(String rolename){
		String updated_message = 'Role updated successfully'
		String roleExists= 'Role Name Already Exists'
		WebUI.setText(findTestObject('Object Repository/Control Panel/Admin/Role Master/Role name search box'), rolename)
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/Role Master/RoleName filter'))
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/Role Master/Equals to option'))
		WebUI.delay(GlobalVariable.smallDelay)
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/Role Master/Edit Role button'))
		WebUI.switchToFrame(findTestObject('Control Panel/Admin/Role Master/Switch to Add new role popup'), GlobalVariable.smallDelay)
		WebUI.setText(findTestObject('Object Repository/Control Panel/Admin/Role Master/Add Role Textbox'), 'Account Contractor')
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/Role Master/Add Role_Save Button'))
		WebUI.delay(GlobalVariable.smallDelay)
		String ActualRoleExistingMessage = WebUI.getText(findTestObject('Object Repository/Control Panel/Admin/Role Master/Role Existing Message'))
		if(ActualRoleExistingMessage.equals(roleExists)){
			println 'Role Name must be Unique'
		}
		else{
			println 'Role Name is accepting duplicate'
		}
		WebUI.setText(findTestObject('Object Repository/Control Panel/Admin/Role Master/Add Role Textbox'), rolename)
		WebUI.check(findTestObject('Object Repository/Control Panel/Admin/Role Master/Enable Mobile Notification- No'))
		WebUI.delay(GlobalVariable.smallDelay)
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/Role Master/Add Role_Save Button'))
		WebUI.delay(1)
		WebUI.switchToDefaultContent()
		WebUI.delay(GlobalVariable.smallDelay)
		WebUI.switchToFrame(findTestObject('Object Repository/Control Panel/Admin/Role Master/Switch to Role master content frame'), GlobalVariable.smallDelay)
		WebUI.switchToFrame(findTestObject('Object Repository/Control Panel/Admin/Role Master/Switch to iframe'), GlobalVariable.smallDelay)
		String ActualUpdatedMessage = WebUI.getText(findTestObject('Object Repository/Control Panel/Admin/Role Master/Role updated sucessfully message'))
		if(ActualUpdatedMessage.equals(updated_message)){
			println 'Role Updated Sucessfully'
		}
		else{
			println 'Role updated message is not displayed'
		}
	}

	//This method is used to crate non contractor role
	@Keyword
	public static String non_ContractorRole() {
		String sucessMessage = 'Role created successfully'
		WebUI.delay(GlobalVariable.smallDelay)
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/Role Master/Add Button'))
		WebUI.delay(GlobalVariable.smallDelay)
		WebUI.switchToFrame(findTestObject('Control Panel/Admin/Role Master/Switch to Add new role popup'), GlobalVariable.smallDelay)
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/Role Master/Close Button in add role popup'))
		WebUI.switchToDefaultContent()
		WebUI.delay(GlobalVariable.smallDelay)
		WebUI.switchToFrame(findTestObject('Object Repository/Control Panel/Admin/Role Master/Switch to Role master content frame'), GlobalVariable.smallDelay)
		WebUI.switchToFrame(findTestObject('Object Repository/Control Panel/Admin/Role Master/Switch to iframe'), GlobalVariable.smallDelay)
		WebUI.delay(GlobalVariable.smallDelay)
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/Role Master/Add Button'))
		WebUI.delay(GlobalVariable.smallDelay)
		WebUI.switchToFrame(findTestObject('Control Panel/Admin/Role Master/Switch to Add new role popup'), GlobalVariable.smallDelay)
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/Role Master/Add Role_Save Button'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Control Panel/Admin/Role Master/Astrisk for role name'), GlobalVariable.smallDelay)
		String charset = (('A'..'Z') + ('a'..'z') + ('0'..'9')).join()
		def length = 8
		String randomRoleName = RandomStringUtils.random(length, charset.toCharArray())
		println('Role name = '+ randomRoleName)
		WebUI.setText(findTestObject('Object Repository/Control Panel/Admin/Role Master/Add Role Textbox'), randomRoleName)
		WebUI.setText(findTestObject('Object Repository/Control Panel/Admin/Role Master/Role Description'), 'Is contractr Role- No')
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/Role Master/Event Notification Templete'))
		WebUI.delay(GlobalVariable.smallDelay)
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/Role Master/Option in Event Notification Templete'))
		WebUI.delay(GlobalVariable.smallDelay)
		WebUI.check(findTestObject('Object Repository/Control Panel/Admin/Role Master/Modules_Control Panel Check box'))
		WebUI.delay(GlobalVariable.smallDelay)
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/Role Master/Add Role_Save Button'))
		WebUI.delay(1)
		WebUI.switchToDefaultContent()
		WebUI.delay(GlobalVariable.smallDelay)
		WebUI.switchToFrame(findTestObject('Object Repository/Control Panel/Admin/Role Master/Switch to Role master content frame'), GlobalVariable.smallDelay)
		WebUI.switchToFrame(findTestObject('Object Repository/Control Panel/Admin/Role Master/Switch to iframe'), GlobalVariable.smallDelay)
		String ActualSuccessMessage = WebUI.getText(findTestObject('Object Repository/Control Panel/Admin/Role Master/Role created successfully message'))
		if(ActualSuccessMessage.equals(sucessMessage)){
			println 'Role Created Successfully'
		}
		else{
			println 'Role not created sucessfully'
		}
		return randomRoleName
	}

	//This method is to update non contractor role
	@Keyword
	public static void Role_UpdateNonContractorRole(String rolename){
		String updated_message = 'Role updated successfully'
		String selectMessage = 'Select atleast one Company/Department/Trade under View Access'
		String roleExists= 'Role Name Already Exists'
		WebUI.setText(findTestObject('Object Repository/Control Panel/Admin/Role Master/Role name search box'), rolename)
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/Role Master/RoleName filter'))
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/Role Master/Equals to option'))
		WebUI.delay(GlobalVariable.smallDelay)
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/Role Master/Edit Role button'))
		WebUI.switchToFrame(findTestObject('Control Panel/Admin/Role Master/Switch to Add new role popup'), GlobalVariable.smallDelay)
		WebUI.setText(findTestObject('Object Repository/Control Panel/Admin/Role Master/Add Role Textbox'), 'Account Contractor')
		WebUI.check(findTestObject('Object Repository/Control Panel/Admin/Role Master/Enable Mobile Notification- No'))
		WebUI.delay(GlobalVariable.smallDelay)
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/Role Master/Add Role_Save Button'))
		WebUI.delay(GlobalVariable.smallDelay)
		String ActualRoleExistingMessage = WebUI.getText(findTestObject('Object Repository/Control Panel/Admin/Role Master/Role Existing Message'))
		if(ActualRoleExistingMessage.equals(roleExists)){
			println 'Role Name must be Unique'
		}
		else{
			println 'Role Name is accepting duplicate'
		}
		WebUI.setText(findTestObject('Object Repository/Control Panel/Admin/Role Master/Add Role Textbox'), rolename)
		WebUI.setText(findTestObject('Object Repository/Control Panel/Admin/Role Master/Role Description'), 'Is contractr Role- No \nRestriced access- yes')
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/Role Master/Restriceted access_Yes'))
		WebUI.delay(GlobalVariable.smallDelay)
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/Role Master/Add Role_Save Button'))
		String ListBoxMessage = WebUI.getText(findTestObject('Object Repository/Control Panel/Admin/Role Master/Select atleast one Company Department Trade under View Access message'))
		if(ListBoxMessage.equals(selectMessage)){
			println ListBoxMessage
		}
		else{
			println 'company, Trade, department message is not displayed'
		}
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/Role Master/Option in Company list box'))
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/Role Master/Option Department in update'))
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/Role Master/Option trade in update'))
		WebUI.delay(GlobalVariable.smallDelay)
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/Role Master/Add Role_Save Button'))
		WebUI.switchToDefaultContent()
		WebUI.switchToFrame(findTestObject('Object Repository/Control Panel/Admin/Role Master/Switch to Role master content frame'), 1)
		WebUI.switchToFrame(findTestObject('Object Repository/Control Panel/Admin/Role Master/Switch to iframe'), 1)
		String UpdateMessage = WebUI.getText(findTestObject('Object Repository/Control Panel/Admin/Role Master/Role updated sucessfully message'))
		if(UpdateMessage.equals(updated_message)){
			println 'Role updated successfully'
		}
		else{
			println 'Role not Updated Sucessfully'
		}
	}
}
