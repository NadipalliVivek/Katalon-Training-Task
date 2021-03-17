import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import controlPanel_Admin_UserMaster.UserMaster as UserMaster
import logInToTheApplication.logIn as logIn

// Navigating to UserMaster Page
UserMaster.navigateToUserMaster()
//Validation in add user popup
UserMaster.validations()
//For adding new user successfully
String userID = UserMaster.addUser()
//Updating the added user
String newPassword = UserMaster.editUser(userID)
//Logout
UserMaster.logOut()
//Login to the application with updated user details
logIn.logInToTheApplication(userID, newPassword)
//UserId validation
UserMaster.userId_validation(userID)
