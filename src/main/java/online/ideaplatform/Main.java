package online.ideaplatform;

import online.ideaplatform.model.Root;
import online.ideaplatform.service.TicketsJsonParser;

import java.time.Duration;
import java.util.Map;

import static online.ideaplatform.service.FlightTimeCalculator.calculateFlightTimes;
import static online.ideaplatform.service.FlightTimeCalculator.formatDuration;

public class Main {
    public static void main(String[] args) {
        Root root = TicketsJsonParser.parse();
        if (root != null) {
            root.tickets().forEach(System.out::println);
            Map<String, Duration> flightTimes = calculateFlightTimes(root.tickets());
            flightTimes.forEach((carrier, duration) ->
                    System.out.println("Перевозчик: " + carrier
                            + ", Минимальное время полёта из Владивостока в Тель-Авив: "
                            + formatDuration(duration)));
        } else {
            System.out.println("\u001B[31m" + "Ошибка парсинга JSON в POGO" + "\u001B[0m");
        }
    }
}
