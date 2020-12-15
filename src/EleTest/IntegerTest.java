package EleTest;

public class IntegerTest {
	public static void main(String[] args) {
		Integer t2 = new Integer(100);
		Integer t1 = 100;
		System.out.println("t1==t2:"+(t1==t2));
		t2--;
		System.out.println("after t2--,t1="+t1+",t2="+t2);
	}
}
