package Collections;

import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

/**
 * @author deepak.jayaprakash
 */
public class ArrayListDemo {

    public static void arrayListDemo() {
        //Create arraylist
        List<String> names = new ArrayList<>();
        names.add("Lokesh");    //[lokesh]

        List<String> names2 = null;

//        names.forEach(name -> {
//            System.out.println(name);
//        });

        System.out.println(Stream.concat(names.stream(), names2.stream())
                .collect(Collectors.toList()));
    }

    public void java8Collections() {
        SampleObject s1 = new SampleObject("Ramesh", 1);
        SampleObject s2 = new SampleObject("Suresh", 1);
        SampleObject s3 = new SampleObject("Ramesh", 2);
        SampleObject s4 = new SampleObject("Ramesh", 3);
        SampleObject s5 = new SampleObject("Suresh", 5);
        List<SampleObject> sampleObjects = Arrays.asList(s1, s2, s3, s4, s5);

        Map<String, List<SampleObject>> groupedMap = new HashMap<>();
        // how kids do stuff
        for (SampleObject sampleObject : sampleObjects) {
            List<SampleObject> list;
            if (groupedMap.get(sampleObject.getName()) == null) {
                list = new ArrayList<>();
                list.add(sampleObject);
            } else {
                list = groupedMap.get(sampleObject.getName());
                list.add(sampleObject);
            }
            groupedMap.put(sampleObject.getName(), list);
        }

        // how legends to stuff
        groupedMap = sampleObjects.stream().collect(groupingBy(SampleObject::getName));
        System.out.println(groupedMap);

    }

    @Data
    class SampleObject {
        public String name;
        Integer number;

        SampleObject(String name, Integer number) {
            this.name = name;
            this.number = number;
        }
    }
}
