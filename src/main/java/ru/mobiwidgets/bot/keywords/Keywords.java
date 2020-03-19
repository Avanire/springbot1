package ru.mobiwidgets.bot.keywords;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Keywords {
    private static final String PATH = "C:\\java\\Bot\\keyword.json";

    public static String getKeyword(int position) throws IOException {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH))){
            Gson json = new Gson();
            List<String> keywordList = json.fromJson(bufferedReader, ArrayList.class);
            return keywordList.get(position);
        }
    }

    public static List<String> getKeywords() throws IOException {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH))) {
            Gson json = new Gson();
            List<String> keywordList = json.fromJson(bufferedReader, ArrayList.class);
            return keywordList;
        }
    }

    public static void addKeyword(String keyword) throws IOException {
        List<String> keywordList = getKeywords();
        Gson json = new Gson();
        keywordList.add(keyword);
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(PATH))){
            json.toJson(keywordList, bw);
        }
    }

    public void deleteKeyword(String keyword) throws IOException {
        List<String> keywordList = getKeywords();
        Gson json = new Gson();
        keywordList.remove(keyword);
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(PATH))){
            json.toJson(keywordList, bw);
        }
    }

    public static void clear() throws IOException {
        List<String> keywordList = getKeywords();
        Gson json = new Gson();
        keywordList.clear();
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(PATH))){
            json.toJson(keywordList, bw);
        }
    }

    public static String getRandomKeyword() throws IOException {
        Random rnd = new Random();
        int i = rnd.nextInt(getKeywords().size() - 1);
        return getKeyword(i);
    }

    public static void addKeywords() throws IOException {
        String str;
        Gson json = new Gson();
        List<String> keywords = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new FileWriter(PATH))){
            while (!(str = br.readLine()).isEmpty()){
                keywords.add(str);
            }
            json.toJson(keywords, bw);
        }

    }

}
