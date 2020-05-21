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
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

WebUI.callTestCase(findTestCase('Common Test Case/Login'), [('var_email') : var_email, ('var_password') : var_password], FailureHandling.STOP_ON_FAILURE)

switch (var_statusExpectedResult.toString()) {
	case 'email_is_empty':
		'Verify when expected test case login with email is empty'
		def errorMessage = Mobile.getText(findTestObject('login_page/TextViewAlert - Email tidak boleh kosong'), GlobalVariable.G_Timeout)
		Mobile.verifyEqual(errorMessage.contains('*Email tidak boleh kosong'), true)
		break
}

@com.kms.katalon.core.annotation.SetUp
def Setup() {
	'Path of the Apk File Store in path variable'
	def path = RunConfiguration.getProjectDir() + '/Data Files/tds_v1.apk'

	'Start the application'
	Mobile.startApplication(path, false)
}

@com.kms.katalon.core.annotation.TearDown
def Teardown() {
	Mobile.closeApplication()
}

