package lesson16;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

public class PersonAPI {
    // version 1
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

    // version 2
    public static List<Person> getPersonFromAPI(int value) {
        List<Person> persons = new ArrayList<>();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://randomuser.me/api"))
                .GET()
                .build();
        try {
            for (int i = 0; i < value; i++) {
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                Person person = parseJsonToPerson(response);
                persons.add(person);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return persons;
    }

    // version 3
    public static List<Person> getPersons(int value) {
        String formatted = String.format("https://randomuser.me/api?results=%d", value);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(formatted))
                .GET()
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return jsonParser(response);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Person parseJsonToPerson(HttpResponse<String> response) {
        JSONObject object = new JSONObject(response.body()).getJSONArray("results").getJSONObject(0);
        return setFields(object);
    }

    public static List<Person> jsonParser(HttpResponse<String> response) {
        List<Person> persons = new ArrayList<>();
        int value = new JSONObject(response.body()).getJSONObject("info").getInt("results");
        for (int i = 0; i < value; i++) {
            JSONObject object = new JSONObject(response.body()).getJSONArray("results").getJSONObject(i);
            persons.add(setFields(object));
        }
        return persons;
    }

    private static Person setFields(JSONObject object) {
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
        return ZonedDateTime.parse(stringDate).toLocalDateTime();
    }
}
