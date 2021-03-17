package logInToTheApplication

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
import internal.GlobalVariable as GlobalVariable

public class logIn {
	//This method is used for login to the application
	@Keyword
	public static void logInToTheApplication(username,password) {
		//WebUI.openBrowser(GlobalVariable.url)
		//WebUI.maximizeWindow()
		WebUI.setText(findTestObject('Object Repository/Login/UserName'), username)
		WebUI.setText(findTestObject('Object Repository/Login/Password'), password)
		WebUI.click(findTestObject('Object Repository/Login/Submit Button'))
		WebUI.delay(3)
	}
	@Keyword
	public static void logInValidation(){
		WebUI.openBrowser(GlobalVariable.url)
		WebUI.maximizeWindow()
		WebUI.setText(findTestObject('Object Repository/Login/UserName'), GlobalVariable.InvalidUserName)
		WebUI.setText(findTestObject('Object Repository/Login/Password'), GlobalVariable.InvalidPassword)
		WebUI.click(findTestObject('Object Repository/Login/Submit Button'))
		String errorMessage = WebUI.getText(findTestObject('Object Repository/Login/Error message'))
		println errorMessage
		WebUI.setText(findTestObject('Object Repository/Login/UserName'), GlobalVariable.InactiveUserName)
		WebUI.setText(findTestObject('Object Repository/Login/Password'), GlobalVariable.InactiveUserPassword)
		WebUI.click(findTestObject('Object Repository/Login/Submit Button'))
		String InactiveUser = WebUI.getText(findTestObject('Object Repository/Login/Error message'))
		println InactiveUser
	}
}
