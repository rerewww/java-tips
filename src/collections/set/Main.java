package collections.set;

import utils.StopWatch;

import java.util.*;

/**
 * Created by son on 2019-09-23.
 * Set: 순서를 신경쓰지 않으며, 중복을 허용하지 않는 집합
 * HashSet: Set Interface를 상속받고 순서에 상관없이 데이터가 삽입된다.
 * TreeSet: SortedSet Class를 상속받는 NavigableSet 인터페이스를 상속받으며 red-black 이진트리 구조로 기본적으로 오름차순으로 정렬된다.
 * LinkedHashSet: HashSet Class 상속받으며 삽입된 순서대로 데이터가 정렬된다. (오름차순이나 내림차순 아님)
 */
public class Main {
	public static void main(String[] args) {
		System.out.println("--- duplicate test");
		duplicateTest();
		System.out.println("--- sort test");
		sortTest();
		System.out.println("--- add performance test");
		performanceTest();
	}

	private static void sortTest() {
		Set<Integer> hashSet = new HashSet<>();
		Set<Integer> treeSet = new TreeSet<>();
		Set<Integer> linkedHashSet = new LinkedHashSet<>();
		int[] arr = {10, 20, 30, 40, 80, 50, 60, 70};

		for (int i : arr) {
			hashSet.add(i);
		}
		System.out.println("[hashSet]" + hashSet.toString());

		for (int i : arr) {
			treeSet.add(i);
		}
		System.out.println("[treeSet]" + treeSet.toString());

		for (int i : arr) {
			linkedHashSet.add(i);
		}
		System.out.println("[linkedHashSet]" + linkedHashSet.toString());
	}

	private static void duplicateTest() {
		HashSet<Integer> hashSet = new HashSet<>();

		int[] arr = {10, 10, 20, 20, 30, 30};

		for (int i : arr) {
			hashSet.add(i);
		}

		System.out.println(hashSet.toString());
	}

	private static void performanceTest() {
		Set<String> hashSet = new HashSet<>();
		Set<String> treeSet = new TreeSet<>();
		Set<String> linkedHashSet = new LinkedHashSet<>();

		// 1,000000개의 데이터 삽입
		String data = "DATA";
		int size = 1000000;

		StopWatch hashSetWatch = new StopWatch("add hashSet");
		hashSetWatch.start();
		for (int i = 0; i < size; i++) {
			hashSet.add(data + i);
		}
		hashSetWatch.stopAndPrint();

		StopWatch treeSetWatch = new StopWatch("add treeSet");
		treeSetWatch.start();
		for (int i = 0; i < size; i++) {
			treeSet.add(data + i);
		}
		treeSetWatch.stopAndPrint();

		StopWatch linkedHashSetWatch = new StopWatch("add linkedHashSet");
		linkedHashSetWatch.start();
		for (int i = 0; i < size; i++) {
			linkedHashSet.add(data + i);
		}
		linkedHashSetWatch.stopAndPrint();

		System.out.println("--- revmoe performance test");
		StopWatch hashSetWatch2 = new StopWatch("remove hashSet");
		hashSetWatch2.start();
		for (int i = 0; i < hashSet.size(); i++) {
			hashSet.remove(data + i);
		}
		hashSetWatch2.stopAndPrint();

		StopWatch treeSetWatch2 = new StopWatch("remove treeSet");
		treeSetWatch2.start();
		for (int i = 0; i < hashSet.size(); i++) {
			treeSet.remove(data + i);
		}
		treeSetWatch2.stopAndPrint();

		StopWatch linkedHashSetWatch2 = new StopWatch("remove linkedHashSet");
		linkedHashSetWatch2.start();
		for (int i = 0; i < hashSet.size(); i++) {
			treeSet.remove(data + i);
		}
		linkedHashSetWatch2.stopAndPrint();
	}
}
