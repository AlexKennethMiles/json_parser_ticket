package online.ideaplatform;

import online.ideaplatform.model.Root;
import online.ideaplatform.service.TicketsJsonParser;

import java.time.Duration;
import java.util.Map;

import static online.ideaplatform.service.FlightTimeCalculator.calculateFlightTimes;
import static online.ideaplatform.service.FlightTimeCalculator.formatDuration;
import static online.ideaplatform.service.PriceStatisticsCalculator.calculatePriceDifference;

public class Main {
    public static void main(String[] args) {
        Root root = TicketsJsonParser.parse();
        if (root != null) {
            Map<String, Duration> flightTimes = calculateFlightTimes(root.tickets());
            System.out.println("- Минимальное время полёта из Владивостока в Тель-Авив:");
            flightTimes.forEach((carrier, duration) ->
                    System.out.println("Перевозчик " + carrier + ":  " + formatDuration(duration)));
            double priceDifference = calculatePriceDifference(root.tickets());
            System.out.println("- Разница между средней ценой и медианой для полета между "
                    + "городами Владивосток и Тель-Авив: " + priceDifference);
        } else {
            System.out.println("\u001B[31m" + "Ошибка парсинга JSON в POGO" + "\u001B[0m");
        }
    }
}
