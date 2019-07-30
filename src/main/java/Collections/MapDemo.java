package Collections;

import java.util.*;

/**
 * @author deepak.jayaprakash
 */
public class MapDemo {

    public static void hashMapDemo() {
        HashMap<Integer, String> map = new HashMap<>();

        map.put(1, "A");
        System.out.println(map.put(2, "B"));
        System.out.println(map.put(3, "C"));
        System.out.println(map.put(3, "C"));
        System.out.println(map.getOrDefault(4, "Default"));

        System.out.println(map.putIfAbsent(3, "D"));

//        Using keySet() and iterator
        Iterator<Integer> itr = map.keySet().iterator();

        while (itr.hasNext()) {
            Integer key = itr.next();
            String value = map.get(key);

            System.out.println("The key is :: " + key + ", and value is :: " + value);
        }

        System.out.println("//Iterate over entries set");

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("The key is :: " + entry.getKey() + ", and value is :: " + entry.getValue());
        }
    }

    public static void linkedHashMapDemo() {
        LinkedHashMap<Integer, String> pairs = new LinkedHashMap<>();
        pairs.put(1, "A");
        pairs.put(2, "B");
        pairs.put(3, "C");
        pairs.put(4, "D");

        pairs.forEach((key, value) -> {
            System.out.println("Key:" + key + ", Value:" + value);
        });
    }

    public static void accessOrderLinkedHashMap() {
        //3rd parameter set access order
        LinkedHashMap<Integer, String> pairs = new LinkedHashMap<>(2, .75f, true);

//        Collections.synchronizedSet()
        pairs.put(1, "A");
        pairs.put(2, "B");
        pairs.put(3, "C");
        pairs.put(4, "D");

        //Access 3rd pair
        pairs.get(3);

        //Access 1st pair
        pairs.getOrDefault(2, "oops");

        pairs.forEach((key, value) -> {
            System.out.println("Key:" + key + ", Value:" + value);
        });
    }
}
