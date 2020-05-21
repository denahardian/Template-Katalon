package api

import org.eclipse.persistence.internal.oxm.record.json.JSONParser
import org.json.JSONArray

import com.kms.katalon.core.annotation.Keyword

import groovy.json.JsonSlurper

public class JsonParser {
	@Keyword
	def jsonParse(def response){
		def slurper = new JsonSlurper()
		def result = slurper.parseText(response.getResponseBodyContent())
		return result
	}
}
