package EleTest;

public class �ݹ��е�return {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
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
