package online.ideaplatform.service;

import com.google.gson.Gson;
import online.ideaplatform.model.Root;

import java.io.FileReader;
import java.io.IOException;

public class TicketsJsonParser {
    public static Root parse() {
        Gson gson = new Gson();

        try (FileReader reader = new FileReader("files/tickets.json")) {
            return gson.fromJson(reader, Root.class);
        } catch (IOException e) {
            System.out.println("\u001B[31m" + "Ошибка чтения файла " + e + "\u001B[0m");
        }
        return null;
    }
}
