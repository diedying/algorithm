package leetcode;
import java.util.*;
public class LRU {
    HashMap<Integer,Node> hm;
    int size;
    Node head;
    Node tail;
    int count;
    public LRU(int cap) {
        hm = new HashMap<Integer,Node>();
    		size = cap;
        count = 0;
        head = new Node(0,0,null,null);
    		tail = new Node(0,0,null,null);
    		head.next = tail;
    		tail.pre = head;
    }
    public int get(int key) {
        if(hm.containsKey(key)) {
        		moveFirst(hm.get(key));//remember to move the node to first;
        		return hm.get(key).val;
        }
        return -1;    	
    }
    public void put(int key,int val) {       
    		if(hm.containsKey(key)) {//remember to move the node to first;
    			hm.get(key).val = val;
            moveFirst(hm.get(key));
    		}
    		else {
    			if(count==size) {
    				Node last = tail.pre;
    				moveFirst(last);
    				hm.remove(last.key);//remember to remove hm
    				hm.put(key, last);//remember to update hm
    				last.val = val;
    				last.key = key;	
    			}
    			else {
    				Node nnode = new Node(key,val,null,null);
    				add(nnode);
    			}
    		}
    }    
    public void moveFirst(Node n) {
    		Node pre = n.pre;
    		Node next = n.next;
    		pre.next = next;
    		next.pre = pre;
    		Node first = head.next;
    		head.next = n;
    		n.pre = head;
    		n.next = first;
    		first.pre = n;
    }
    public void add(Node n) {
    		hm.put(n.key, n);
    		count++;
    		Node prefirst = head.next;
    		head.next = n;
    		n.pre = head;
    		n.next =  prefirst;
    		prefirst.pre = n;
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
class Node{
	Node pre;
	Node next;
	int val;
	int key;
	public Node(int key,int val,Node p,Node n) {
		pre = p;
		next = n;
		this.val = val;
		this.key = key;
	}
}