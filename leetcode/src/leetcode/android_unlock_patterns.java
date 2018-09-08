package leetcode;
import java.util.*;
public class android_unlock_patterns {
	public int[][] connect ;
	public int[] used;
	public int max;
	public int min;
	public int res;
	public int numberOfPatterns(int m, int n) {
		connect = new int[10][10];
		connect[1][3]=connect[3][1] = 2;
		connect[1][7] = connect[7][1] = 4;
		connect[1][9] = connect[9][1] = connect[3][7] = connect[7][3] = connect[4][6] = connect[6][4]= connect[2][8]= connect[8][2] = 5;
		connect[3][9] = connect[9][3] = 6;
		connect[7][9] = connect[9][7] = 8;
		used = new int[10];
		max = n; min = m;
		for(int i=1;i<=9;i++) {
			res+=helper(i,used,1);
		}
		return res;
	}
	public int helper(int i,int[] used,int steps) {
		
		if(steps>max) return 0;
		int r = 0;
		if(steps>=min&&steps<=max) r=1;
		used[i] = 1;
		for(int j=1;j<=9;j++) {
			if(used[j]==0&&(connect[i][j]==0||used[connect[i][j]]==1)) {
				r+=helper(j,used,steps+1);
			}
		}
		used[i] = 0;
		return r;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		android_unlock_patterns r = new android_unlock_patterns();
		System.out.println(r.numberOfPatterns(2,5));

	}

}
