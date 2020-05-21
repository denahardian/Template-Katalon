
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import java.lang.String


def static "api.JsonParser.jsonParse"(
    	Object response	) {
    (new api.JsonParser()).jsonParse(
        	response)
}

def static "mobile.Swipe.AndroidSwipe"(
    	int startX	
     , 	int startY	
     , 	int endX	
     , 	int endY	) {
    (new mobile.Swipe()).AndroidSwipe(
        	startX
         , 	startY
         , 	endX
         , 	endY)
}

def static "mobile.startApplication.startAbsolutePath"(
    	String appName	
     , 	boolean reset	) {
    (new mobile.startApplication()).startAbsolutePath(
        	appName
         , 	reset)
}

def static "general.Excel.writeExcel"(
    	String name	
     , 	String excelPath	) {
    (new general.Excel()).writeExcel(
        	name
         , 	excelPath)
}

def static "general.TestDataGenerator.getRandomEmail"() {
    (new general.TestDataGenerator()).getRandomEmail()
}

def static "general.TestDataGenerator.getRandomNumber"() {
    (new general.TestDataGenerator()).getRandomNumber()
}

def static "general.TestDataGenerator.getRandomName"() {
    (new general.TestDataGenerator()).getRandomName()
}

def static "general.TestDataGenerator.getRandomPassword"() {
    (new general.TestDataGenerator()).getRandomPassword()
}
