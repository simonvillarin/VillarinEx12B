package org.ssglobal.training.codes.itemC;

public class TestRandomList {

	public static void main(String[] args) {
		RandomList<String> randomList = new RandomList<>();
		randomList.add(0, "Simon");
		randomList.add(1, "James");
		randomList.add(2, "Hatamosa");
		randomList.add(3, "Villarin");
		randomList.add(3, "Mon");
		
		System.out.println(randomList);
		System.out.println(randomList.remove(1));
		System.out.println(randomList.remove(2));
		System.out.println(randomList);

	}

}
