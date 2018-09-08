package leetcode;
import java.util.*;
public class decode_string {
	public String decodeString(String s) {
		if(s.length()==0) return "";
		Stack<Integer> nums = new Stack<Integer>();
		Stack<String> patterns = new Stack<String>();
		char[] cc = s.toCharArray();
		int j=0;
		StringBuilder temp = new StringBuilder();
		String res = "";
		while(j<s.length()) {
			char c = cc[j];
			if(Character.isDigit(c)) {
				int count = 0;
				while(Character.isDigit(cc[j])) {
					count = count*10+cc[j]-'0';
					j++;
				}
				nums.push(count);
			}
			else if(c=='[') {				
				patterns.push(new String(res));
				res = "";
				j++;
			}
			else if(c==']') {
				StringBuilder pre = new StringBuilder(patterns.pop());
				int times = nums.pop();
				for(int i=0;i<times;i++) {
					pre.append(res);
				}
				res = pre.toString();
				j++;
			}
			else {
				res+=c;
				j++;
			}
		}
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		decode_string r = new decode_string();
		String str = "3[a2[c]]";
		System.out.println(r.decodeString(str));

	}

}
