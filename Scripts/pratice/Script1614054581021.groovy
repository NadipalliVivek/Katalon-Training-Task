import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import logInToTheApplication.logIn as logIn
import controlPanel_Admin_UserMaster.UserMaster as UserMaster
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils
import org.junit.After

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable
import org.apache.commons.lang.RandomStringUtils as RandStr
import logInToTheApplication.logIn as logIn

//String charset = (('A'..'Z') + ('a'..'z') + ('0'..'9')).join()
//def length = 8
//String UserID = RandomStringUtils.random(length, charset.toCharArray())
//println(UserID)
//logIn.logInToTheApplication()
//UserMaster.navigateToUserMaster()
//UserMaster.addUser()
//UserMaster.logOut()
//def password = org.apache.commons.lang.RandomStringUtils.randomAscii(8)
//println(password)

//UserMaster.navigateToUserMaster()
//UserMaster.addUser()
//WebUI.openBrowser('http://qa-auto.astorsafe.com/Login.aspx')
//logIn.logInToTheApplication('administrator', 'Automation@2021')


for(i=1;i<5;i++)
{ print '*'}