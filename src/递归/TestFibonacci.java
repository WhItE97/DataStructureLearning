package 递归;

public class TestFibonacci {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		//fibonacci:1 1 2 3 5 8 13
		int res = fibonacci(7);
		System.out.println(res);
	}

	//输入i表示Fibonacci的第i项，返回该项的值
	public static int fibonacci(int i) {
		if(i==1||i==2) {
			return 1;
		}
		
		return fibonacci(i-1)+fibonacci(i-2);
	}
}
