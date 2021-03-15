package com.automationintesting.unit.service;

import java.net.http.HttpClient;
import io.restassured.response.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
// import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Scanner;

import static io.restassured.RestAssured.given;

// We need to start the app up to test it. So we use the SpringRunner class and SpringBootTest to configure
// and run the app.
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = ReportApplication.class)
@ActiveProfiles("dev")
public class HealthCheck {
  @Test
  public void bookingHealthCheckTest(){
    HttpRequest.newBuilder(new URI("http://localhost:3000/booking/actuator/health"));
    HttpRequest request = HttpRequest.newBuilder()
      .uri(new URI("http://localhost:3000/booking/actuator/health"))
      .GET()
      .build();
    Response response = HttpRequest.get("http://localhost:3000/booking/actuator/health");
    Assert.assertEquals(200, response.getStatusCode());
    Assert.assertEquals("{\"status\":\"UP\"}", response.getBody());
    }

}
