package online.ideaplatform.service;

import online.ideaplatform.model.Ticket;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FlightTimeCalculator {

    public static Map<String, Duration> calculateFlightTimes(List<Ticket> tickets) {
        return tickets.stream()
                .filter(ticket -> "VVO".equals(ticket.origin()) && "TLV".equals(ticket.destination()))
                .collect(Collectors.groupingBy(Ticket::carrier, Collectors.mapping(
                        ticket -> calculateFlightTime(ticket.departureDate(), ticket.departureTime(),
                                ticket.arrivalDate(), ticket.arrivalTime()),
                        Collectors.minBy(Duration::compareTo))))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().orElse(Duration.ZERO)));
    }

    private static Duration calculateFlightTime(LocalDate departureDate, LocalTime departureTime,
                                                LocalDate arrivalDate, LocalTime arrivalTime) {
        return Duration.between(
                departureDate.atTime(departureTime),
                arrivalDate.atTime(arrivalTime)
        );
    }

    public static String formatDuration(Duration duration) {
        long hours = duration.toHours();
        long minutes = duration.minusHours(hours).toMinutes();
        return String.format("%02d часов %02d минут", hours, minutes);
    }
}
