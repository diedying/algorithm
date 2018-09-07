package leetcode;
import java.util.*;
public class word_break_ii {
	HashMap<String,List<String>> hm = new HashMap<String,List<String>>();
	public List<String> wordBreak(String s,List<String> wordDict){
		List<String> res = new ArrayList<String>();
		if(s.length()==0) return res;
		if(wordDict.contains(s)) res.add(s);
		for(int i=0;i<s.length()-1;i++) {
			String left = s.substring(0, i+1);
			if(wordDict.contains(left)) {
				String right = s.substring(i+1,s.length());
				List<String> rr = new ArrayList<String>();
				if(hm.containsKey(right)) rr = hm.get(right);
				else rr = wordBreak(right,wordDict);
				hm.put(right, rr);
				for(String str:rr) {
					res.add(left+" "+str);
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
