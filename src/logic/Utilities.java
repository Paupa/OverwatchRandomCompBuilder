package logic;

import java.util.ArrayList;
import java.util.List;

public class Utilities {
	
	public static List<String> arrayToList(String[] array) {
		List<String> list = new ArrayList<>();
		
		for(int i = 0; i < array.length; i++) {
			list.add(array[i]);
		}
		
		return list;
	}
	
	public static void shuffleArray(String[] array) {
	    for (int i = array.length - 1; i > 0; i--) {
	        int j = (int) Math.floor(Math.random() * (i + 1));
	        String temp = array[i];
	        array[i] = array[j];
	        array[j] = temp;
	    }
	}
	
	public static void shuffleList(List<String> list) {
	    for (int i = list.size() - 1; i > 0; i--) {
	        int j = (int) Math.floor(Math.random() * (i + 1));
	        String temp = list.get(i);
	        list.set(i, list.get(j));
	        list.set(j, temp);
	    }
	}

}
