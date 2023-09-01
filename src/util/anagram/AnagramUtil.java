package util.anagram;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AnagramUtil {
	private String target;

	public AnagramUtil(String target) {
		this.target = target;
	}

	public void setTarget(String target) {
		this.target = target;
	}
	
    //Checks whether two strings are anagrams
	public boolean isAnagram(String str1, String str2) {
		Map<Character, Integer> letterCountMap = new HashMap<>();
		if (str1 == null || str2 == null || str1.length() != str2.length()) {
			return false;
		} else {
			//Find the count of all letters in first string
			for (int i = 0; i < str1.length(); i++) {
				char ch = str1.charAt(i);
				if (letterCountMap.containsKey(ch))
					letterCountMap.put(ch, letterCountMap.get(ch) + 1);
				else
					letterCountMap.put(ch, 1);
			}

			//Reduce the count when there is a match in second string
			for (int i = 0; i < str2.length(); i++) {
				char ch = str2.charAt(i);
				if (letterCountMap.containsKey(ch)) {
					if (letterCountMap.get(ch) == 1)
						letterCountMap.remove(ch);
					else
						letterCountMap.put(ch, letterCountMap.get(ch) - 1);
				} else
					return false;
			}

		}
		return letterCountMap.isEmpty();
	}

	//Return all anagrams of the given string
	public List<String> findAllAnagrams(String input) {

		return target == null ? Collections.emptyList()
				: Stream.of(target.split(" ")).filter(str -> !str.isEmpty()).map(str -> {
					return str.trim();
				}).distinct().filter(str -> !str.equals(input) && isAnagram(input, str)).sorted()
						.collect(Collectors.toList());

	}
}
