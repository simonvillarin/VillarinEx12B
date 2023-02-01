package org.ssglobal.training.codes.itemA;

public class TestHTMLChecker {

	public static void main(String[] args) {
		HTMLChecker htmlChecker = new HTMLChecker();
		System.out.println(htmlChecker.validate("./src/files/index.html"));
	}

}
