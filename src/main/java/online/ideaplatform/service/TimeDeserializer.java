package online.ideaplatform.service;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TimeDeserializer implements JsonDeserializer<LocalTime> {
    private final DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");
    private final DateTimeFormatter altTimeFormat = DateTimeFormatter.ofPattern("H:mm");

    @Override
    public LocalTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
        try {
            return LocalTime.parse(json.getAsString(), timeFormat);
        } catch (DateTimeParseException e) {
            return LocalTime.parse(json.getAsString(), altTimeFormat);
        } catch (Exception e) {
            throw new JsonParseException(e);
        }
    }
}
