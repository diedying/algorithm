package leetcode;
import java.util.*;
public class count_of_smaller_numbers_after_itself {
	public class Pair{
		int val;
		int index;
		public Pair(int v,int i) {
			val = v;
			index = i;
		}
	}
	public List<Integer> countSmaller(int[] nums){
		List<Integer> res = new ArrayList<Integer>();
		int[] counts = new int[nums.length];
		Pair[] pairs = new Pair[nums.length];
		for(int i=0;i<nums.length;i++) {
			Pair p = new Pair(nums[i],i);
			pairs[i] = p;
		}

		helper(nums,0,nums.length-1,pairs,counts);
		for(int c:counts) res.add(c);
		return res;
	}
	public void helper(int[] nums,int s,int e,Pair[] pairs,int[] counts) {
		if(s>=e) {
			return;
		}
		int mid = s+(e-s)/2;
		helper(nums,s,mid,pairs,counts);
		helper(nums,mid+1,e,pairs,counts);
		Pair[] next = new Pair[pairs.length];
		int p=s;
		int left = s;
		int right = mid+1;
		int moves = 0;
		while(left<=mid||right<=e) {
			
			if(left>mid) {
				next[p] = pairs[right];
				right++;
				p++;
				continue;
			}
			if(right>e) {
				next[p] = pairs[left];
				counts[pairs[left].index]+=moves;
				left++;
				p++;
				continue;
			}
			if(pairs[left].val<=pairs[right].val) {
				next[p] = pairs[left];
				counts[pairs[left].index]+=moves;
				left++;
			}
			else {
				next[p] = pairs[right];
				right++;
				moves++;
			}
			p++;
		}
		
		for(int i=s;i<=e;i++) {
			pairs[i] = next[i];
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		count_of_smaller_numbers_after_itself r = new count_of_smaller_numbers_after_itself();
		int[] nums = new int[] {5,3,2,6,1,7,3,4,8};
		System.out.println(r.countSmaller(nums));

	}
	

} 
