package String;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class NameComparator implements Comparator<String>{

	public NameComparator() {
		super();
		init();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		NameComparator romanComparator = new NameComparator();

		TreeSet<String> kingName = new TreeSet<>(romanComparator);
		kingName.add("Henry II");
		kingName.add("Edward VII");
		kingName.add("Henry I");
		kingName.add("Edward X");

		System.out.println(kingName);
		
		
		List<String> kings = Arrays.asList(new String[]{"Louis IX","Louis VIII"});	
		Collections.sort(kings);	
		for(String king: kings)
		System.out.print(king+" ");
		
		
		
		
	}

	@Override
	public int compare(String name1, String name2) {
		// TODO Auto-generated method stub
		String[] name1Split = name1.split(" ");
		String[] name2Split = name2.split(" ");

		if (name1Split[0].compareTo(name2Split[0]) == 0) {
			int roman1 = convertRomanToInt(name1Split[1]);
			int roman2 = convertRomanToInt(name2Split[1]);

			return (roman1 == roman2 ? 0 : (roman1 > roman2 ? 1 : -1));

		} else {
			return name1Split[0].compareTo(name2Split[0]);
		}
	}
	
	private int convertRomanToInt(String roman) {
		char[] arr = roman.toCharArray();

		int total = 0;
		int maxNumeral = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			int val = intForRoman.get(arr[i]);
			if (val >= maxNumeral) {
				maxNumeral = val;
				total += val;
			} else {
				total -= val;
			}
		}
		return total;
	}
	
	
	private Map<Character, Integer> intForRoman = new HashMap<>();

	private void init() {
		intForRoman.put('I', 1);
		intForRoman.put('V', 5);
		intForRoman.put('X', 10);
		intForRoman.put('L', 50);
	}

}
