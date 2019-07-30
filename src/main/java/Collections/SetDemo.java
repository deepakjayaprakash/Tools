package Collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author deepak.jayaprakash
 */
public class SetDemo {

    public static void treeSetDemo() {
        TreeSet<Integer> tree = new TreeSet<>();
        tree.add(12);
        tree.add(63);
        tree.add(34);
        tree.add(45);

        Iterator<Integer> iterator = tree.iterator();
        System.out.print("Tree set data: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }

    public static void hashSetDemo() {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("A");
        hashSet.add("B");
        hashSet.add("C");
        hashSet.add("D");
        System.out.println(hashSet.add("E"));
        System.out.println(hashSet.add("E"));

        System.out.println(hashSet);

        Iterator<String> itr = hashSet.iterator();

        while (itr.hasNext()) {
            String value = itr.next();
            System.out.println("Value: " + value);
        }
    }

}
