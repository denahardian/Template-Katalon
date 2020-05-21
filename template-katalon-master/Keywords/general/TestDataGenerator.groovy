package general

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

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
import java.security.SecureRandom;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

public class TestDataGenerator {
	public static def generator = { String alphabet, int n ->
		new Random().with {
			(1..n).collect {
				alphabet[ nextInt( alphabet.length() ) ]
			}.join()
		}
	}


	@Keyword
	public final static String getRandomEmail() {


		StringBuilder sb = new StringBuilder();
		sb.append("QaTest_");
		sb.append(generator( (('a'..'z')).join(), 10 ));
		sb.append("@tds.id");

		return sb.toString().replace(' ', '.');
	}
	@Keyword
	public final static String getRandomNumber() {

		StringBuilder sb = new StringBuilder();
		sb.append("081");
		sb.append(generator( (('0'..'9')).join(), 10 ));

		return sb.toString().replace(' ', '.');
	}
	@Keyword

	public final static String getRandomName(){
		StringBuilder sb = new StringBuilder();
		sb.append("User TDS");

		return sb.toString().replace(' ', ' ');
	}
	@Keyword
	public final static String getRandomPassword(){
		StringBuilder sb = new StringBuilder();
		sb.append(generator( (('a'..'z')+('1'..'9')).join(), 7 ));

		return sb.toString().replace(' ', '.');
	}
}
