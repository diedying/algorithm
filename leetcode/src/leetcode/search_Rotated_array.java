package leetcode;
import java.util.*;
public class search_Rotated_array {
	public int search(int[] nums,int target) {
        if(nums.length==0) return -1;
		int start = start(nums);
		int i = start;       
		int j = start-1+nums.length;
		while(i<=j) {
			int mid = i+(j-i)/2;
            int realmid = mid % nums.length;
            if(nums[realmid]==target) return realmid;
			if(nums[realmid]<target) i=mid+1;
			else j=mid-1;
		}        
        return -1;
	}
	public int start(int[] nums) {
		int i = 0; int j = nums.length-1;
		while(i<j) {
			int mid = i+(j-i)/2;
			if(nums[i]<nums[j]) {
				return i;
			}
			else {
				if(nums[mid]<nums[i]) j = mid;
				else if(nums[mid]>nums[j]) i = mid + 1;
			}
		}
		return i;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
