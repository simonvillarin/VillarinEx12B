package org.ssglobal.training.codes.itemA;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class HTMLChecker {
	private Stack<String> stack = new Stack<>();

	public boolean validate(String htmlFile) {	
		try (BufferedReader br = new BufferedReader(new FileReader(htmlFile))) {
			String line = br.readLine();
			try {
				while (line != null) {
					String[] tags = line.split(" ");
					
					for (String tag : tags) {
						if (tag.startsWith("<") && !tag.startsWith("</")) {
							stack.push(tag.substring(1));
						} else if (tag.startsWith("</")) {
							if (stack.isEmpty() || !stack.pop().equals(tag.substring(2))) {
								return false;
							}
						}
					}
					line = br.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		return true;
	}
}
