package ru.mobiwidgets.bot.competitors;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Competitors {
    private static final String PATH = "C:\\java\\Bot\\competitors.json";

    public static void addCompetitors() throws IOException {
        String str;
        Gson json = new Gson();
        List<String> competitors = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new FileWriter(PATH))){
            while (!(str = br.readLine()).isEmpty()){
                competitors.add(str);
            }
            json.toJson(competitors, bw);
        }
    }

    public static List<String> getCompetitors() throws IOException {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH))) {
            Gson json = new Gson();
            List<String> competitors = json.fromJson(bufferedReader, ArrayList.class);
            return competitors;
        }
    }
}
