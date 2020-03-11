package hometask03;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CountWords {
    public static void main(String[] args) {

    }

    public static void countThenPrint(String[] words) {
        Map<String, Integer> map = new HashMap<>(); //можно будет заменить на TreeMap, чтобы еще и отсортировать в нужном порядке
//        Map<String, Integer> map = new TreeMap<>(); //можно будет заменить на TreeMap, чтобы еще и отсортировать в нужном порядке

        Integer val;
        for (String word : words) {
            //есть ли уже в hashmap - word?
            if (!(map.containsKey(word))) {
                map.put(word, 1);
            } else {
                val = (Integer) map.get(word).intValue();
                map.put(word, new Integer(val + 1));
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue().toString());
            //если хочется вывести по порядку, то в начале надо использовать TreeMap
        }
    }

}
