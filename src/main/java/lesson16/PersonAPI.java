package lesson16;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.*;

public class PersonAPI {
    public static Person getPersonFromAPI() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://randomuser.me/api"))
                .GET()
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return parseJsonToPerson(response);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Person parseJsonToPerson(HttpResponse<String> response) {
        JSONObject object = new JSONObject(response.body()).getJSONArray("results").getJSONObject(0);
        Person person = new Person();
        person.setGender(object.getString("gender"));
        person.setName(object.getJSONObject("name").getString("first"));
        person.setLastName(object.getJSONObject("name").getString("last"));
        person.setCity(object.getJSONObject("location").getString("city"));
        person.setState(object.getJSONObject("location").getString("state"));
        person.setCountry(object.getJSONObject("location").getString("country"));
        person.setDate(toLocalDateTimeFromString(object.getJSONObject("dob").getString("date")));
        person.setAge(Period.between(toLocalDateTimeFromString(object.getJSONObject("dob").getString("date"))
                .toLocalDate(), LocalDateTime.now().toLocalDate()).getYears());
        person.setEmail(object.getString("email"));
        person.setUsername(object.getJSONObject("login").getString("username"));
        person.setPassword(object.getJSONObject("login").getString("password"));
        return person;
    }

    private static LocalDateTime toLocalDateTimeFromString(String stringDate) {
        Instant instant = Instant.parse(stringDate);
        return LocalDateTime.ofInstant(instant, ZoneId.of(ZoneOffset.UTC.getId()));
    }
}
