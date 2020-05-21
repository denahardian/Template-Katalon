import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import web.fetchingEmail as fetchingEmail

//config email
String host ="imap.gmail.com";
String mailStoreType="imap";
String username="sidik.developer@gmail.com";
String password="hpdkkvhrttyfbbiv";

String emailLink = fetchingEmail.getEmailLinkFromEmail(host,mailStoreType,username,password)
WebUI.comment(emailLink)
WebUI.openBrowser('')
WebUI.navigateToUrl(emailLink, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.delay(10)
WebUI.closeBrowser()

