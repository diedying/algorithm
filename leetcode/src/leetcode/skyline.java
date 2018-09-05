package leetcode;
import java.util.*;
public class skyline {
	public List<int[]> getSkyline(int[][] buildings){
		List<int[]> res = new ArrayList<int[]>();
		PriorityQueue<Node> all = new PriorityQueue<Node>();
		for(int[] building:buildings) {
			Node b = new Node(building[0],-building[2]);
			Node e = new Node(building[1],building[2]);
			all.offer(b);
			all.offer(e);
		}
		PriorityQueue<Integer> heights = new PriorityQueue<Integer>(new Comparator<Integer>() {
			public int compare(Integer i1, Integer i2) {
				if(i1<i2) return 1;
				if(i1==i2) return 0;
				else return -1;
			}
		});
		heights.offer(0);
		int pre = 0;
		while(!all.isEmpty()) {
			Node cur = all.poll();
			if(cur.h<0) {
				heights.offer(-cur.h);
			}
			else {
				heights.remove(cur.h);
			}
			int peek = heights.peek();
			if(peek!=pre) {
				res.add(new int[] {cur.i,peek});
			}
			pre = peek;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class Node implements Comparable<Node>{
	int i;
	int h;
	public Node(int i,int h) {
		this.i = i;
		this.h= h;
	}
	@Override
	public int compareTo(Node n) {
		if(this.i==n.i) {
			if(this.h<n.h) return -1;
			if(this.h==n.h) return 0;
			else return 1;
		}
		else if(this.i<n.i) return -1;
		else return 1;
	}
}
