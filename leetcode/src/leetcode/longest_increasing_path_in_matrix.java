package leetcode;
import java.util.*;
public class longest_increasing_path_in_matrix {
	public int longestIncreasingPath(int[][] matrix) {
		int width = matrix.length;
		if(width==0||matrix[0].length==0) return 0;
		int length = matrix[0].length;
		int res = 0;
		int[][] store = new int[width][length];
		for(int i=0;i<width;i++) {
			for(int j=0;j<length;j++) {
				res = Math.max(res, helper(matrix,i,j,store));
			}
		}
		return res;
	}
	public int helper(int[][] matrix, int i, int j, int[][] res) {
		int width = matrix.length;
		int length = matrix[0].length;
		if(i<0||j<0||i>=width||j>=length) return 0;
		int r = 1;
		if(i>0&&matrix[i-1][j]>matrix[i][j]) {
			if(res[i-1][j]!=0) r = Math.max(r, 1+res[i-1][j]);
			else r = Math.max(r, 1+helper(matrix,i-1,j,res));			
		}
		if(j>0&&matrix[i][j-1]>matrix[i][j]) {
			if(res[i][j-1]!=0) r = Math.max(r, 1+res[i][j-1]);
			else r = Math.max(r, 1+helper(matrix,i,j-1,res));			
		}
		if(i<width-1&&matrix[i+1][j]>matrix[i][j]) {
			if(res[i+1][j]!=0) r = Math.max(r, 1+res[i+1][j]);
			else r = Math.max(r, 1+helper(matrix,i+1,j,res));		
		}
		if(j<length-1&&matrix[i][j+1]>matrix[i][j]) {
			if(res[i][j+1]!=0) r = Math.max(r, 1+res[i][j+1]);
			else r = Math.max(r,1+ helper(matrix,i,j+1,res));			
		}
		res[i][j] = r;
		return r;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		longest_increasing_path_in_matrix r = new longest_increasing_path_in_matrix();
		int[][] nums = new int[][] {{9,9,4},{6,6,8},{2,1,1}};
		System.out.println(r.longestIncreasingPath(nums));
  
	}

}
