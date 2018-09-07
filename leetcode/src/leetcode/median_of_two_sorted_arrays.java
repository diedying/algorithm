package leetcode;
import java.util.*;
public class median_of_two_sorted_arrays {
	public double median(int[] nums1, int[] nums2) {
		int l1 = nums1.length;
		int l2 = nums2.length;
		int[] up = nums1;
		int[] down = nums2;
		if(l1>l2) {
			up = nums2;
			down = nums1;
		}
        l1 = up.length;
        l2 = down.length;

		int half =( l1+l2+1)/2;
		int left = 0;
		int right = l1;
		int leftmax = 0;
		int rightmin = 0;
		while(left<=right) {
			int i = left+(right-left)/2;
			int j = half-i;
            // System.out.println(i);
            // System.out.println(j);
			if(i>0&&up[i-1]>down[j]) {
				right = i-1;
			}else if(i<l1&&up[i]<down[j-1]){
				left = i+1;
			}
			else {
                
				if(i==0) leftmax = down[j-1];
                else if(j==0) leftmax = up[i-1];
                else leftmax = Math.max(down[j-1],up[i-1]);
                if((l1+l2)%2==1) return leftmax;
                if(i==l1) rightmin = down[j];
                else if(j==l2) rightmin = up[i];
                else rightmin = Math.min(down[j],up[i]);
				
				return (leftmax+rightmin)/2.0;
			}
		}
		return 0;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
