package leetcode;

public class reverse_words {
	    public String reverseWords(String s) {
	        s = s.trim();
	        char[] ss = s.toCharArray();
	        reverse(ss,0,ss.length-1);
	        int i=0; int j=0;
	        while(j<ss.length){
	            if(ss[j]!=' '){
	                j++;
	                continue;
	            }
	            reverse(ss,i,j-1);            
	            j++;
	            i = j;
	            
	        }
	        reverse(ss,i,j-1);
	        StringBuilder sb = new StringBuilder();
	        for( i=0;i<ss.length;){
	            if(ss[i]!=' ') {
	                sb.append(ss[i]);
	                i++;
	            }
	            else{
	                sb.append(' ');
	                while(ss[i]==' ') i++;
	            }
	        }
	        return sb.toString();
	    }
	    public void reverse(char[] c, int s, int e){
	        if(s>=e) return;
	        while(s<e){
	            char temp = c[s];
	            c[s] = c[e];
	            c[e] = temp;
	            s++;
	            e--;
	        }
	    }

}
