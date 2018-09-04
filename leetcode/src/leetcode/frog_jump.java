package leetcode;
import java.util.*;
public class frog_jump {
	public boolean canCross(int[] stones) {
		HashMap<Integer,HashSet<Integer>> hm = new HashMap<Integer,HashSet<Integer>>();
		//use hm to record till now all the possible stones to arrive and their next steps
		HashSet<Integer> t = new HashSet<Integer>();
		t.add(1);
		hm.put(0, t);
		HashSet<Integer> allStones = new HashSet<Integer>();
		for(int stone:stones) allStones.add(stone);
		for(int stone:stones) {
			if(!hm.containsKey(stone)) return false;//can not arrive till now, will not arrive next stones
			HashSet<Integer> steps = new HashSet<Integer>(hm.get(stone));
			for(int step:steps) {
				int next = stone+step;
				if(next==stones[stones.length-1]) return true;
				if(allStones.contains(next)) {
					if(!hm.containsKey(next)) hm.put(next, new HashSet<Integer>());
					hm.get(next).add(step-1);
					hm.get(next).add(step);
					hm.get(next).add(step+1);
				}
			}
		}
		return false;	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		frog_jump r = new frog_jump();
		int[] stones = new int[] {0,1,3,5,6,8,12,17};
		System.out.println(r.canCross(stones));
	}

}
