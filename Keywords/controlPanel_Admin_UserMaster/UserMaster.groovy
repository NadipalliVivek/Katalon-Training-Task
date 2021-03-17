package controlPanel_Admin_UserMaster
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
import controlPanel_Admin_UserMaster.UserMaster
import com.kms.katalon.core.util.KeywordUtil

public class UserMaster {
	// This method opens user master page
	@Keyword
	public static void navigateToUserMaster() {
		WebUI.switchToFrame(findTestObject('Object Repository/Control Panel/Admin/User Master/Swith to Tree Frame Menu'), GlobalVariable.smallDelay)
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/User Master/Admin Button'))
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/User Master/UserMaster button'))
		WebUI.delay(GlobalVariable.smallDelay)
		WebUI.switchToDefaultContent()
		WebUI.delay(GlobalVariable.smallDelay)
		WebUI.switchToFrame(findTestObject('Object Repository/Control Panel/Admin/User Master/Switch to content frame'), GlobalVariable.smallDelay)
		WebUI.switchToFrame(findTestObject('Object Repository/Control Panel/Admin/User Master/Switch to UserMaster iframe'),GlobalVariable.smallDelay)
	}

	// This method is used for generating random values
	@Keyword
	public static void randomSting(){
		String charset = (('A'..'Z') + ('a'..'z') + ('0'..'9')).join()
		def length = 20
		String randomString = RandomStringUtils.random(length, charset.toCharArray())
		println(randomString)
	}

	// This method creates user successfully
	@Keyword
	public static String addUser() {
		String User_Created_Message = 'User created successfully'
		String charset = (('A'..'Z') + ('a'..'z') + ('0'..'9')).join()
		def length = 8
		String randomUserID = RandomStringUtils.random(length, charset.toCharArray())
		println 'UserID = '+randomUserID
		WebUI.setText(findTestObject('Object Repository/Control Panel/Admin/User Master/User ID textbox'), randomUserID)
		WebUI.setText(findTestObject('Object Repository/Control Panel/Admin/User Master/User Name textbox'),'vivek')
		String email = RandomStringUtils.randomAlphabetic(4) + '@' +RandomStringUtils.randomAlphabetic(3) + '.com'
		println 'random email ID = '+ email
		WebUI.setText(findTestObject('Object Repository/Control Panel/Admin/User Master/Email Id text box'), email)
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/User Master/Role name dropdown'))
		WebUI.delay(GlobalVariable.smallDelay)
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/User Master/Role dropdown Option'))
		WebUI.setText(findTestObject('Object Repository/Control Panel/Admin/User Master/Password text field'), GlobalVariable.UserPassword)
		WebUI.setText(findTestObject('Object Repository/Control Panel/Admin/User Master/Confirm Password text field'), GlobalVariable.UserPassword)
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/User Master/Add user_Culture dropdown'))
		WebUI.delay(GlobalVariable.smallDelay)
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/User Master/Culture dropdown_UK option'))
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/User Master/Save button in add popup'))
		WebUI.switchToDefaultContent()
		WebUI.switchToFrame(findTestObject('Object Repository/Control Panel/Admin/User Master/Switch to content frame'),1)
		WebUI.switchToFrame(findTestObject('Object Repository/Control Panel/Admin/User Master/Switch to UserMaster iframe'),1)
		String Expected_userCreatedSuccessfully = WebUI.getText(findTestObject('Object Repository/Control Panel/Admin/User Master/User Created Successfully message'))
		if(Expected_userCreatedSuccessfully.equals(User_Created_Message)){
			println 'New User Created Successfully'
		}
		else{
			println'User not Created Successfully'
		}
		return randomUserID
	}

	// This method validates the messages in add user popup
	@Keyword
	public static void validations() {
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/User Master/Add button'))
		WebUI.switchToFrame(findTestObject('Object Repository/Control Panel/Admin/User Master/Switch to add user popup'), GlobalVariable.smallDelay)
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/User Master/Cancel button in add popup'))
		WebUI.switchToDefaultContent()
		WebUI.delay(GlobalVariable.smallDelay)
		WebUI.switchToFrame(findTestObject('Object Repository/Control Panel/Admin/User Master/Switch to content frame'), GlobalVariable.smallDelay)
		WebUI.switchToFrame(findTestObject('Object Repository/Control Panel/Admin/User Master/Switch to UserMaster iframe'),GlobalVariable.smallDelay)
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/User Master/Add button'))
		WebUI.switchToFrame(findTestObject('Object Repository/Control Panel/Admin/User Master/Switch to add user popup'), GlobalVariable.smallDelay)
		UserMaster.mandatory_fields()
		WebUI.setText(findTestObject('Object Repository/Control Panel/Admin/User Master/User ID textbox'), 'a')
		WebUI.setText(findTestObject('Object Repository/Control Panel/Admin/User Master/User Name textbox'),'vivek')
		String email = RandomStringUtils.randomAlphabetic(4) + '@' +RandomStringUtils.randomAlphabetic(3) + '.com'
		println 'random email ID = '+ email
		WebUI.setText(findTestObject('Object Repository/Control Panel/Admin/User Master/Email Id text box'), email)
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/User Master/Role name dropdown'))
		WebUI.delay(GlobalVariable.smallDelay)
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/User Master/Role dropdown Option'))
		WebUI.setText(findTestObject('Object Repository/Control Panel/Admin/User Master/Password text field'), 'vive')
		WebUI.verifyElementText(findTestObject('Control Panel/Admin/User Master/Password error message'), 'Password should contain at least 1 alphanumeric, 1 special character & length should be min 4 chars')
		println 'Password should contain at least 1 alphanumeric, 1 special character & length should be min 4 chars'
		WebUI.setText(findTestObject('Object Repository/Control Panel/Admin/User Master/Password text field'), GlobalVariable.UserPassword)
		WebUI.setText(findTestObject('Object Repository/Control Panel/Admin/User Master/Confirm Password text field'),'vivek@966')
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/User Master/Save button in add popup'))
		WebUI.verifyElementText(findTestObject('Control Panel/Admin/User Master/Password must match message'), 'Password must match')
		println 'Password must match'
		WebUI.setText(findTestObject('Object Repository/Control Panel/Admin/User Master/Confirm Password text field'),GlobalVariable.UserPassword)
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/User Master/Add user_Culture dropdown'))
		WebUI.delay(GlobalVariable.smallDelay)
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/User Master/Culture dropdown_UK option'))
		WebUI.delay(GlobalVariable.smallDelay)
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/User Master/Save button in add popup'))
		WebUI.verifyElementText(findTestObject('Control Panel/Admin/User Master/UserID already exists message'), 'User ID Already Exists')
		println 'User ID Already Exists'
	}

	//This method is used for updating user
	@Keyword
	public static String editUser(String userID ) {
		String Update_Message = 'User updated successfully'
		String lastpassword = 'Password should not match with last 1 passwords'
		WebUI.delay(GlobalVariable.smallDelay)
		WebUI.switchToDefaultContent()
		WebUI.delay(GlobalVariable.smallDelay)
		WebUI.switchToFrame(findTestObject('Object Repository/Control Panel/Admin/User Master/Switch to content frame'), GlobalVariable.smallDelay)
		WebUI.switchToFrame(findTestObject('Object Repository/Control Panel/Admin/User Master/Switch to UserMaster iframe'),GlobalVariable.smallDelay)
		WebUI.setText(findTestObject('Object Repository/Control Panel/Admin/User Master/User ID search box'), userID )
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/User Master/Filter for UserID'))
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/User Master/userID_StartsWith'))
		WebUI.delay(GlobalVariable.mediumDelay)
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/User Master/Edit button'))
		WebUI.switchToFrame(findTestObject('Object Repository/Control Panel/Admin/User Master/Switch to add user popup'), GlobalVariable.mediumDelay)
		WebUI.delay(GlobalVariable.smallDelay)
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/User Master/Cancel button in add popup'))
		WebUI.delay(GlobalVariable.smallDelay)
		WebUI.switchToDefaultContent()
		WebUI.delay(GlobalVariable.smallDelay)
		WebUI.switchToFrame(findTestObject('Object Repository/Control Panel/Admin/User Master/Switch to content frame'), GlobalVariable.smallDelay)
		WebUI.switchToFrame(findTestObject('Object Repository/Control Panel/Admin/User Master/Switch to UserMaster iframe'),GlobalVariable.smallDelay)
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/User Master/Edit button'))
		WebUI.switchToFrame(findTestObject('Object Repository/Control Panel/Admin/User Master/Switch to add user popup'), GlobalVariable.mediumDelay)
		WebUI.delay(GlobalVariable.mediumDelay)
		WebUI.setText(findTestObject('Object Repository/Control Panel/Admin/User Master/User Name textbox'), 'nadipalli')
		String email = RandomStringUtils.randomAlphabetic(4) + '@' +RandomStringUtils.randomAlphabetic(3) + '.com'
		println 'random email ID = '+ email
		WebUI.setText(findTestObject('Object Repository/Control Panel/Admin/User Master/Email Id text box'), email)
		WebUI.setText(findTestObject('Object Repository/Control Panel/Admin/User Master/Password text field'), GlobalVariable.UserPassword)
		WebUI.setText(findTestObject('Object Repository/Control Panel/Admin/User Master/Confirm Password text field'), GlobalVariable.UserPassword)
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/User Master/Edit_SaveButton'))
		WebUI.delay(GlobalVariable.smallDelay)
		WebUI.verifyElementText(findTestObject('Object Repository/Control Panel/Admin/User Master/Last 1 password message'), lastpassword)
		println lastpassword
		String newPassword = RandomStringUtils.randomAlphabetic(2)+"@"+RandomStringUtils.randomNumeric(5)
		println 'updated password = '+ newPassword
		WebUI.setText(findTestObject('Object Repository/Control Panel/Admin/User Master/Password text field'), newPassword)
		WebUI.setText(findTestObject('Object Repository/Control Panel/Admin/User Master/Confirm Password text field'), newPassword)
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/User Master/Edit_SaveButton'))
		WebUI.switchToDefaultContent()
		WebUI.switchToFrame(findTestObject('Object Repository/Control Panel/Admin/User Master/Switch to content frame'),1)
		WebUI.switchToFrame(findTestObject('Object Repository/Control Panel/Admin/User Master/Switch to UserMaster iframe'),1)
		String Actual_updatedMessage = WebUI.getText(findTestObject('Object Repository/Control Panel/Admin/User Master/Updated sucessfully message'))
		if(Actual_updatedMessage.equals(Update_Message)){
			println 'User Successfully updated '
		}
		else{
			println'User not updated Successfully'
		}
		return newPassword
	}

	// This method used for logout from the application
	@Keyword
	public static void logOut() {
		WebUI.switchToDefaultContent()
		WebUI.switchToFrame(findTestObject('Object Repository/Control Panel/Admin/User Master/Switch to content frame'), GlobalVariable.mediumDelay)
		WebUI.click(findTestObject('Object Repository/Logout'))
	}

	// This method is used for validating astrisk symbols in Add user popup
	@Keyword
	public static void mandatory_fields() {
		WebUI.click(findTestObject('Object Repository/Control Panel/Admin/User Master/Save button in add popup'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/Control Panel/Admin/User Master/Astrisk for User ID'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/Control Panel/Admin/User Master/Astrisk for user name'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/Control Panel/Admin/User Master/Astrisk for Email'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/Control Panel/Admin/User Master/Astrisk for password'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/Control Panel/Admin/User Master/Astrisk for confirm password'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/Control Panel/Admin/User Master/Astrisk for Role'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/Control Panel/Admin/User Master/Astirsk for culture'))
	}

	// This method is used for validating user ID
	@Keyword
	public static void userId_validation(userID){
		WebUI.switchToFrame(findTestObject('Object Repository/Control Panel/Admin/User Master/Swith to Tree Frame Menu'), 3)
		String Actual_UserID =	WebUI.getAttribute(findTestObject('Object Repository/Control Panel/Admin/User Master/User name validation'), 'value')
		if(Actual_UserID.equals(userID)){
			println 'UserID Matched'
		}
		else{
			println 'UserID not Matched'
		}
		println Actual_UserID
		println userID
	}
}
