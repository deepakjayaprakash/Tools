package Collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author deepak.jayaprakash
 */
public class Demo {
    public static void main(String[] args) {
        ArrayListDemo.arrayListDemo();
//        SetDemo.hashSetDemo();
//        SetDemo.treeSetDemo();
//        MapDemo.hashMapDemo();
//        MapDemo.linkedHashMapDemo();
//        MapDemo.accessOrderLinkedHashMap();
//        commonMistakes();
        ArrayListDemo sample = new ArrayListDemo();
//        sample.java8Collections();
    }


    public static void commonMistakes() {
        List<String> hats = new ArrayList<>();
        hats.add("Hat1");
        hats.add("Hat2");
        hats.add("hat3");
        // wroong way :(
        for (String hat : hats) {
            if (hat.equals("Hat1")) {
                hats.remove(hat);
            }
        }

        // correct way :)
        Iterator<String> hatIterator = hats.iterator();
        while (hatIterator.hasNext()) {
            String hat = hatIterator.next();
            if (hat.equals("Hat1")) {
                hatIterator.remove();
            }
        }
        for (String hat : hats) {
            System.out.println(hat);
        }
    }

}
