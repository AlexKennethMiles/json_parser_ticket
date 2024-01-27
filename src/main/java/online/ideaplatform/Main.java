package online.ideaplatform;

import online.ideaplatform.model.Root;
import online.ideaplatform.service.TicketsJsonParser;

public class Main {
    public static void main(String[] args) {
        Root root = TicketsJsonParser.parse();
        if (root != null) {
            root.tickets().forEach(System.out::println);

        } else {
            System.out.println("\u001B[31m" + "Ошибка парсинга JSON в POGO" + "\u001B[0m");
        }
    }
}
