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
import org.openqa.selenium.remote.DesiredCapabilities as DesiredCapabilities
import com.kms.katalon.core.appium.driver.AppiumDriverManager as AppiumDriverManager
import com.kms.katalon.core.mobile.driver.MobileDriverType as MobileDriverType
import com.kms.katalon.core.util.internal.PathUtil as PathUtil
import io.appium.java_client.android.AndroidDriver as AndroidDriver
import java.util.regex.Matcher as Matcher
import java.util.regex.Pattern as Pattern
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration



Mobile.comment('Make user get otp code')

def directory = RunConfiguration.getProjectDir() + '/Data Files/apk/message.apk'


Mobile.tap(findTestObject('message/android.widget.RelativeLayout1'), 0)

String message = Mobile.getText(findTestObject('message/android.widget.TextView2 -  OTP anda adalah 547645. Info linkaja.id'), 
    20, FailureHandling.CONTINUE_ON_FAILURE)

Pattern p1 = Pattern.compile('OTP anda adalah ([^.]*). Info linkaja.id')

Matcher m1 = p1.matcher(message)

if (m1.find()) {
    CustomKeywords.'general.Excel.writeExcel'(m1.group(1),'path')
}

Mobile.closeApplication()

