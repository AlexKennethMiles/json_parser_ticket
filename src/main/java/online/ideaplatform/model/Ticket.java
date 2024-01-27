package online.ideaplatform.model;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import online.ideaplatform.service.DateDeserializer;
import online.ideaplatform.service.TimeDeserializer;

import java.time.LocalDate;
import java.time.LocalTime;

public record Ticket(
        String origin,
        @SerializedName("origin_name")
        String originName,
        String destination,
        @SerializedName("destination_name")
        String destinationName,
        @SerializedName("departure_date")
        @JsonAdapter(DateDeserializer.class)
        LocalDate departureDate,
        @SerializedName("departure_time")
        @JsonAdapter(TimeDeserializer.class)
        LocalTime departureTime,
        @SerializedName("arrival_date")
        @JsonAdapter(DateDeserializer.class)
        LocalDate arrivalDate,
        @SerializedName("arrival_time")
        @JsonAdapter(TimeDeserializer.class)
        LocalTime arrivalTime,
        String carrier,
        int stops,
        int price
) {
}
