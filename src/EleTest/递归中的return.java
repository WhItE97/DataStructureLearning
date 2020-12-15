package EleTest;

public class 递归中的return {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int ret = digui(7);
		System.out.println(ret);
	}

	public static int digui(int i) {
		if(i<5) {
			return i;
		}
		digui(--i);
		return 0;
	}
}
