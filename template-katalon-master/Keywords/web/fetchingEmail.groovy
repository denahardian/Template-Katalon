package web

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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.jsoup.Jsoup as Jsoup;
import java.io.IOException;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import javax.mail.BodyPart;
import javax.mail.Message;

import internal.GlobalVariable

public class fetchingEmail {



	/*
	 * from https://stackoverflow.com/questions/36707939/how-to-extract-a-registration-url-from-a-mail-content
	 * Author(s): B_L
	 * Created: 01/30/2019
	 *
	 * Last Modified by: B_L
	 * Last Modified: 01/30/2019
	 *
	 *
	 * Purpose: Grab verify link from email
	 *
	 */


	public static check(String host, String storeType, String user,String password) {
		try {
			String emailLink = ''
			//create properties field
			Properties properties = new Properties();

			properties.put("mail.imap.host",host);
			properties.put("mail.imap.port", "993");
			properties.put("mail.imap.starttls.enable", "true");
			properties.setProperty("mail.imap.socketFactory.class","javax.net.ssl.SSLSocketFactory");
			properties.setProperty("mail.imap.socketFactory.fallback", "false");
			properties.setProperty("mail.imap.socketFactory.port",String.valueOf(993));
			Session emailSession = Session.getDefaultInstance(properties);

			//create the imap store object and connect with the pop server
			Store store = emailSession.getStore("imap");

			store.connect(host, user, password);

			//create the folder object and open it
			Folder emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_ONLY);

			// retrieve the messages from the folder in an array and print it
			MimeMessage[] messages = emailFolder.getMessages();
			//System.out.println("messages.length---" + messages.length);
			int n=messages.length;

			//change n- to number of emails you want to dig through
			for (int i = n-5; i<n; i++) {
				MimeMessage message = messages[i];
				ArrayList<String> links = new ArrayList<String>();

				if(message.getSubject().contains("Codex - Invitation for Assessment")){
					String html = message.getContent();
					emailLink  = parseHTML(html)
				}else{
					System.out.println("Email:"+ i + " is not a wanted email");
				}



			}
			return emailLink;
			emailFolder.close(false);
			store.close();

		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	public static parseHTML(html){
		String getLink = "";
		Document document;
		try {
			//Get Document object after parsing the html from given url.
			document = Jsoup.parse(html)

			//Get links from document object.
			Elements links = document.select("a[href]");

			//Iterate links and print link attributes.
			for (Element link : links) {
				getLink = link.attr("href");

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return getLink;
	}

	public static String getEmailLinkFromEmail(setHost,setMailStoreType,setUsername,setPassword){
		String host = setHost;
		String mailStoreType = setMailStoreType;
		String username = setUsername;
		String password = setPassword;
		String emailLink = check(host, mailStoreType, username, password);
		return emailLink;
	}


}
