
public class Main {
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(3);
		cache.set(3, 3);
		cache.print();
		System.out.println("============================");
		
		cache.set(6, 6);
		cache.print();
		System.out.println("============================");
		
		cache.set(9, 9);
		cache.print();
		System.out.println("============================");
		
		cache.set(7, 7);
		cache.print();
		System.out.println("============================");
		
		cache.set(9, 9);
		cache.print();
		System.out.println("============================");
		
	}
}
