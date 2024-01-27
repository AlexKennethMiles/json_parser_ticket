package online.ideaplatform.service;

import online.ideaplatform.model.Ticket;

import java.util.List;
import java.util.stream.Collectors;

public class PriceStatisticsCalculator {

    public static double calculatePriceDifference(List<Ticket> tickets) {
        List<Integer> prices = tickets.stream()
                .filter(ticket -> "VVO".equals(ticket.origin()) && "TLV".equals(ticket.destination()))
                .map(Ticket::price)
                .collect(Collectors.toList());

        double averagePrice = calculateAverage(prices);
        double medianPrice = calculateMedian(prices);

        return averagePrice - medianPrice;
    }

    private static double calculateAverage(List<Integer> prices) {
        return prices.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);
    }

    private static double calculateMedian(List<Integer> prices) {
        prices.sort(Integer::compareTo);
        int size = prices.size();
        if (size % 2 == 0) {
            int midIndex1 = size / 2 - 1;
            int midIndex2 = size / 2;
            return (prices.get(midIndex1) + prices.get(midIndex2)) / 2.0;
        } else {
            int midIndex = size / 2;
            return prices.get(midIndex);
        }
    }
}



