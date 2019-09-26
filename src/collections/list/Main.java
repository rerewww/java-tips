package collections.list;

import utils.StopWatch;

import java.util.*;

/**
 * Created by son on 2019-09-25.
 */
public class Main {
	public static void main(String[] args) {
		duplicateTest();
		performanceTest();
	}

	private static void duplicateTest() {
		List<Integer> arrayList = new ArrayList<>();
		List<Integer> linkedList = new LinkedList<>();

		arrayList.add(1);
		arrayList.add(1);
		linkedList.add(2);
		linkedList.add(2);

		System.out.println("--- duplicate test");
		System.out.println("array: " + Arrays.toString(arrayList.toArray()));
		System.out.println("linkedList: " + Arrays.toString(linkedList.toArray()));
	}

	private static void performanceTest() {
		int size = 300000;
		List<Integer> arrayList = new ArrayList<>(size);
//		List<Integer> arrayList = new ArrayList<>();
		List<Integer> linkedList = new LinkedList<>();

		StopWatch arrayStopWatch = new StopWatch("add arrayList");
		arrayStopWatch.start();
		for (int i = 0; i < size; i++) {
			arrayList.add(i);
		}
		arrayStopWatch.stopAndPrint();

		StopWatch linkedListStopWatch = new StopWatch("add linkedList");
		linkedListStopWatch.start();
		for (int i = 0; i < size; i++) {
			linkedList.add(i);
		}
		linkedListStopWatch.stopAndPrint();

		System.out.println(String.format("--- search performance test[index: %s]", size / 2));
		arrayStopWatch.start();
		arrayList.get(size / 2);
		arrayList.add(0, 1);
		arrayStopWatch.stopAndPrint();

		StopWatch linkedListStopWatch2 = new StopWatch("search linkedList");
		linkedListStopWatch2.start();
		linkedList.get(size / 2);
		linkedList.add(0, 1);
		linkedListStopWatch2.stopAndPrint();

		System.out.println(String.format("--- remove performance test[data size: %s]", size));
		StopWatch arrayStopWatch2 = new StopWatch("remove arrayList");
		arrayStopWatch2.start();

		removeAll(arrayList, arrayList.iterator());
		arrayStopWatch2.stopAndPrint();

		StopWatch linkedListStopWatch3 = new StopWatch("remove linkedList");
		linkedListStopWatch3.start();

		removeAll(linkedList, linkedList.iterator());
		linkedListStopWatch3.stopAndPrint();
	}

	private static void removeAll(List<Integer> list, Iterator<Integer> iter) {
		while(iter.hasNext()) {
			int n = iter.next();
			if (list.contains(n)) {
				iter.remove();
			}
		}
	}
}
