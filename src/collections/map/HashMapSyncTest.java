package collections.map;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by son on 2019-09-29.
 */
public class HashMapSyncTest {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    hashMap.put(String.format("Apple%s", j), j);
                }
                System.out.println(hashMap.size());
            }).start();
        }
    }
}
