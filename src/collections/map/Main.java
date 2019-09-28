package collections.map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by son on 2019-09-27.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("-- null test");
//        nullTest();

        System.out.println("-- duplicate test");
        duplicate();
    }

    private static void nullTest() {
        Map<String, Integer> hashMap = new HashMap<>();
        Map<String, Integer> hashTable = new Hashtable<>();
        Map<String, Integer> treeMap = new TreeMap<>();

        hashMap.put(null, null); // => {null=null}
        hashTable.put("a", null); // => java.lang.NullPointerException 발생
        hashTable.put(null, 1); // => java.lang.NullPointerException 발생
        treeMap.put(null, 1); // => Key 기준으로 정렬하기 때문에
    }

    private static void duplicate() {
        Map<String, Integer> hashMap = new HashMap<>();
        Map<String, Integer> hashTable = new Hashtable<>();
        Map<String, Integer> treeMap = new TreeMap<>();

        hashMap.put("a", 1);
        hashMap.put("a", 2);
        hashMap.put("b", 1);
        hashMap.put("c", 2);

        hashTable.put("a", 1);
        hashTable.put("a", 2);
        hashTable.put("b", 1);
        hashTable.put("c", 2);

        treeMap.put("a", 1);
        treeMap.put("a", 2);
        treeMap.put("b", 1);
        treeMap.put("c", 2);

        System.out.println("hashMap: " + hashMap.toString());
        System.out.println("hashTable: " + hashTable.toString());
        System.out.println("treeMap: " + treeMap.toString());
    }
}
