package com.automationintesting.unit.service;

import com.automationintesting.api.BookingApplication;
import java.net.http.HttpRequest;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.URI;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import java.io.IOException;
import java.lang.InterruptedException;

// We need to start the app up to test it. So we use the SpringRunner class and SpringBootTest to configure
// and run the app.
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = BookingApplication.class)
@ActiveProfiles("dev")
public class HealthCheckTest {
  @Test
  public void bookingHealthCheckTest() throws IOException, InterruptedException {
    HttpClient client = HttpClient.newBuilder()
      .build();
    HttpRequest request = HttpRequest.newBuilder()
      .uri(URI.create("http://localhost:3000/booking/actuator/health"))
      .GET()
      .build();
    HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
    Assert.assertEquals(200, response.statusCode());
    Assert.assertEquals("{\"status\":\"UP\"}", response.body());
    }

}
