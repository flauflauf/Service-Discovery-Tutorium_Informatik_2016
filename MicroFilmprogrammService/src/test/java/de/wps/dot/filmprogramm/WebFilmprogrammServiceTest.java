package de.wps.dot.filmprogramm;

import static org.junit.Assert.*;

import java.util.Collections;

import org.junit.Test;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class WebFilmprogrammServiceTest {

	@Test
	public void callHTTPEndPoint() throws UnirestException {
		// Arrange
		WebFilmprogrammService service = new WebFilmprogrammService(Collections.emptyList());
		service.start(12345);
		
		// Act
		HttpResponse<String> response = Unirest.get("http://localhost:12345/vorführungen").asString();
		String responseString = response.getBody();
		
		// Assert
		assertEquals(200, response.getStatus());
		assertTrue(responseString.startsWith("["));
		assertTrue(responseString.endsWith("]"));
	}

}
