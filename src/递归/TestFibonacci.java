package �ݹ�;

public class TestFibonacci {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		//fibonacci:1 1 2 3 5 8 13
		int res = fibonacci(7);
		System.out.println(res);
	}

	//����i��ʾFibonacci�ĵ�i����ظ����ֵ
	public static int fibonacci(int i) {
		if(i==1||i==2) {
			return 1;
		}
		
		return fibonacci(i-1)+fibonacci(i-2);
	}
}
