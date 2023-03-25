import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        int len = numbers.length;
		String[] str = new String[len];
		
		for(int i = 0; i < len; i++) {
			str[i] = Integer.toString(numbers[i]);
		}
		
		Arrays.sort(str, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return (o2+o1).compareTo(o1+o2);
			}
			
		});
		
		if(str[0].equals("0"))return"0";
		
		return String.join("",str);
    }
}
