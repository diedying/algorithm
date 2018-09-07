package leetcode;
import java.util.*;
public class LFU {
	public class Node{
		int key;
		int val;
		int frequency;
		Node pre;
		Node next;		
		public Node(int k,int v,int f,Node p,Node n) {
			key = k;
			val = v;
			frequency = f;
			pre = p;
			next = n;
		}
	}
	public class DList{
		Node head;
		Node tail;
		int size;
		public DList(Node h,Node t) {
			head = h;
			tail = t;
			size = 0;
		}
		public void insertFirst(Node n) {
			Node nx = head.next;
			head.next = n;
			n.pre = head;
			n.next = nx;
			nx.pre = n;
			size++;
		}
		public void remove(Node n) {
			Node nx = n.next;
			Node pr = n.pre;
			pr.next = nx;			
			nx.pre = pr;
			size--;
		}
	}
	public HashMap<Integer,Node> hm;
	public HashMap<Integer,	DList> fre;
	int cachesize;
	int leastfre;
	public LFU(int cap) {
		cachesize = cap;
		hm = new HashMap<Integer,Node>();
		this.fre = new HashMap<Integer,DList>();	
        leastfre = Integer.MAX_VALUE;
	}
	
	public int get(int key) {
        //System.out.println(leastfre);

		if(hm.containsKey(key)) {
			update(key,hm.get(key).val);///
			return hm.get(key).val;
		}
		else return -1;
	}
	
	public void put(int key, int value) {
       // 
        if(cachesize==0) return;
        if(hm.containsKey(key)){            
            update(key,value);
        }
        else{
            if(hm.size()==cachesize){
                delete(fre.get(leastfre).tail.pre);///
            }
            Node toadd = new Node(key,value,1,null,null);
            add(toadd);
        }				
	}
	
    public void update(int key,int value){
        Node toupdate = hm.get(key);
        //System.out.println(toupdate.key);
        toupdate.val = value;
        fre.get(toupdate.frequency).remove(toupdate);///
        if(fre.get(toupdate.frequency).size==0) {
            fre.remove(toupdate.frequency);
            if(leastfre==toupdate.frequency) leastfre = toupdate.frequency+1;
        }
    
        if(!fre.containsKey(toupdate.frequency+1)) {
            Node h = new Node(0,0,0,null,null);
            Node t = new Node(0,0,0,null,h);
            h.next = t;
            fre.put(toupdate.frequency+1,new DList(h,t));           
        }
        fre.get(toupdate.frequency+1).insertFirst(toupdate);
        toupdate.frequency++;
        
    }
    public void add(Node n){
        hm.put(n.key,n);
        leastfre = 1;
        if(!fre.containsKey(1)){
            Node h = new Node(0,0,0,null,null);
            Node t = new Node(0,0,0,null,h);
            h.next = t;
            fre.put(1,new DList(h,t));            
        }
        fre.get(1).insertFirst(n);
    }
    public void delete(Node n){
        hm.remove(n.key);
        if(fre.get(n.frequency).size==1) fre.remove(n.frequency);
        else {
            fre.get(n.frequency).remove(n);
        }
        if(leastfre==n.frequency&&!fre.containsKey(n.frequency)) leastfre = Integer.MAX_VALUE;
    }
}
