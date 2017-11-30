import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LRUCache {
	int capacity;
	HashMap<Integer, Node> map = new HashMap<Integer, Node>();
	Node head;
	Node end;
	public LRUCache(int capacity) {
		this.capacity = capacity;
	}
	public void remove(Node n) {
		if(n.pre != null) {
			n.pre.next = n.next;
		}else {
			head = n.next;
		}
		if(n.next != null) {
			n.next.pre = n.pre;
		}else {
			end = n.pre;
		}
	}
	public void setHead(Node n) {
		n.next = head;
		n.pre = null;
		
		if(head != null)
			head.pre = n;
		head = n;
		
		if(end == null) {
			end = head;
		}
	}
	public int get(int key) {
		if(map.containsKey(key)) {
			Node n = map.get(key);
			remove(n);
			setHead(n);
			return n.value;
		}else {
			return -1;
		}
	}
	public void set(int key, int value) {
		if(map.containsKey(key)) {
			Node n = map.get(key);
			n.value = value;
			remove(n);
			setHead(n);
		}else {
			Node n = new Node(key,value);
			System.out.println("size : "+ map.size()+" , capacity : "+ capacity);
			if(map.size() >= capacity) {
				map.remove(end.key);
				remove(end);
			}
			setHead(n);
			map.put(key, n);
		}
	}
	public void print() {
		for(Integer key : map.keySet()) {
			System.out.println("key : "+key+", Value : "+map.get(key).value);
		}
	}
}
