package ua.goit.prefs;

import com.google.gson.Gson;
import lombok.Data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;


public class Prefs {
    private static final String DEFAULT_PREFS_FILENAME = "prefs.json";
    private Map<String, Object> prefs = new HashMap<>();
    public Prefs() {
        this(DEFAULT_PREFS_FILENAME);
    }
    public Prefs(String filename) {
        try {
            String json = String.join(
                    "\n",
                    Files.readAllLines(Paths.get(filename))
            );

            prefs = new Gson().fromJson(json, Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getString(String key) {
        return getPref(key).toString();
    }
    public Object getPref(String key) {
        return prefs.get(key);
    }

    public Map<String, Object> getPrefs() {
        return prefs;
    }

    public static void main(String[] args) {
        Prefs prefs = new Prefs();
        System.out.println("prefs.getString(\"jdbcURL\") = " + prefs.getString("jdbcURL"));
    }

}
