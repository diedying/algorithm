package leetcode;
import java.util.*;
public class alien_dict {
	public String alienOrder(String[]words) {
		HashMap<Character,ArrayList<Character>> hm = new HashMap<Character,ArrayList<Character>>();
		HashMap<Character,Integer> degree = new HashMap<Character,Integer>();
		HashSet<Character> allChar = new HashSet<Character>();
		for(String word:words) {
			for(char c:word.toCharArray()) {
				allChar.add(c);
			}
		}
		for(int i=0;i<words.length-1;i++) {
			String w1 = words[i];
			String w2 = words[i+1];
			
			for(int j=0;j<w1.length()&&j<w2.length();j++) {
				char c1 = w1.charAt(j);
				char c2 = w2.charAt(j);
				if(c1!=c2) {
					if(!hm.containsKey(c1)) hm.put(c1, new ArrayList<Character>());
					hm.get(c1).add(c2);
					if(!degree.containsKey(c2)) degree.put(c2, 0);
					degree.put(c2, degree.get(c2)+1);
					break;
				}
			}
		}
		Queue<Character> q = new LinkedList<Character>();
		for(char c:allChar) {
			if(!degree.containsKey(c)) q.offer(c);
		}
		StringBuilder res = new StringBuilder();
		while(!q.isEmpty()) {
			char c = q.poll();
			res.append(c);
			if(hm.containsKey(c)) {
				ArrayList<Character> nexts = hm.get(c);
				for(char next:nexts) {
					degree.put(next, degree.get(next)-1);
					if(degree.get(next)==0) {
						q.offer(next);
						degree.remove(next);
					}
				}
				//hm.remove(c);
			}		
		}
		if(degree.size()!=0) return "";
		return res.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		alien_dict r = new alien_dict();
		String[] words = new String[] {"z","x","c"};
		System.out.println(r.alienOrder(words));

	}

}
