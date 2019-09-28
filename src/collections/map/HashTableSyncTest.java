package collections.map;

import java.util.Hashtable;
import java.util.Map;

/**
 * Created by son on 2019-09-29.
 */
public class HashTableSyncTest {
    public static void main(String[] args) {
        Map<String, Integer> hashTable = new Hashtable<>();

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    hashTable.put(String.format("Banana%s", j), j);
                }
                System.out.println(hashTable.size());
            }).start();
        }
    }
}
