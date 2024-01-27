package online.ideaplatform.service;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateDeserializer implements JsonDeserializer<LocalDate> {
    private final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd.MM.yy");

    @Override
    public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)  {
        try {
            return LocalDate.parse(json.getAsString(), dateFormat);
        } catch (Exception e) {
            throw new JsonParseException(e);
        }
    }
}
