package org.ssglobal.training.codes.itemC;

public class TestRandomList {

	public static void main(String[] args) {
		RandomList<String> randomList = new RandomList<>();	
		randomList.add("Simon");
		randomList.add("James");
		randomList.add("Hatamosa");
		randomList.add("Villarin");
		
		System.out.println(randomList);
		System.out.println(randomList.remove(1));
		System.out.println(randomList);

	}

}
