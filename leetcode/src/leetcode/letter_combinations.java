package leetcode;
import java.util.*;
public class letter_combinations {
	private String[] stores = new String[] {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	public List<String> letterCombinations(String digits){
		List<String> res= new ArrayList<String>();
        if(digits.length()==0) return res;
		StringBuilder temp = new StringBuilder();
		helper(res,temp,0,digits);
		return res;
	}
	public void helper(List<String> res, StringBuilder temp,int pos, String digits) {
		if(pos==digits.length()) {
			res.add(temp.toString());
			return;
		}		
		String possibilities = stores[digits.charAt(pos)-'0'];
		for(int j=0;j<possibilities.length();j++) {
			temp.append(possibilities.charAt(j));
			helper(res,temp,pos+1,digits);
			temp.setLength(temp.length()-1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		letter_combinations r = new letter_combinations();
		String digits = "12";
		System.out.println(r.letterCombinations(digits));

	}

}
