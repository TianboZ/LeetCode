package MianJing.thumbtack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dianmian2 {
    public static void main(String args[]) {
        Map<String, String> input = new HashMap<>();
        input.put("Name", "Peter");
        input.put("Age", "27");
        input.put("Gender", "M");
        List<Map<String, String>> result = questionOne(input);

        for (int i = 0; i < result.size(); i++) {
            System.out.println("-------Number: " + i);
            Map<String, String> map = result.get(i);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                System.out.println(entry.getKey() + "--" + entry.getValue());
            }
        }
    }


    // DFS
    public static List<Map<String, String>> questionOne(Map<String, String> input) {
        List<Map<String, String>> res = new ArrayList<>();
        if (input == null || input.size() == 0) return res;
        List<Map.Entry<String, String>> list = new ArrayList<>();
        for (Map.Entry<String, String> entry : input.entrySet()) {
            list.add(entry);
        }

        dfs(list, 0, new HashMap<>(), res);
        return res;
    }

    private static void dfs(List<Map.Entry<String, String>> input, int index, Map<String, String> temp, List<Map<String, String>> res) {
        res.add(new HashMap<>(temp));
        for (int i = index; i < input.size(); i++) {
            temp.put(input.get(i).getKey(), input.get(i).getValue());
            dfs(input, i + 1, temp, res);
            temp.remove(input.get(i).getKey());

        }

    }
}
