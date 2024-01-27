package online.ideaplatform.service;

import com.google.gson.Gson;
import online.ideaplatform.model.Root;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class TicketsJsonParser {
    public static Root parse() {
        Gson gson = new Gson();
        try (InputStreamReader reader = new InputStreamReader(
                TicketsJsonParser.class.getResourceAsStream("/tickets.json"),
                StandardCharsets.UTF_8
        )) {
            return gson.fromJson(reader, Root.class);
        } catch (IOException e) {
            System.out.println("\u001B[31m" + "Ошибка чтения файла " + e + "\u001B[0m");
        }
        return null;
    }
}
