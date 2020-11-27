package oj.hot200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q249 {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String string : strings) {
            if (string.length() == 1) {
                if (!map.containsKey("_")) map.put("_", new ArrayList<>());
                map.get("_").add(string);
            } else {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < string.length() - 1; i++) {
                    int tmp = string.charAt(i) - string.charAt(i + 1);
                    if (tmp < 0) tmp += 26;
                    builder.append(tmp + "_");
                }
                if (!map.containsKey(builder.toString())) map.put(builder.toString(), new ArrayList<>());
                map.get(builder.toString()).add(string);
            }


        }
        return new ArrayList<>(map.values());
    }
}
