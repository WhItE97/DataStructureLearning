package �ݹ�;

public class TestHanoi {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		hanoi(9,'A','C','B');
	}
	/**
	 * 
	 * @param n����n����ƶ�����
	 * @param from����from����
	 * @param to����toȥ
	 * @param buf����ת����
	 */
	public static void hanoi(int n,char from,char to,char buf) {
		if(n==1) {
			System.out.println("��1�����Ӵ�"+from+"�ƶ���"+to);
		}
		//���۶������ӣ�Ҫ�������µ��Ƶ�����Ŀ��λ��
		//�����Ȱѳ��˵�ʱ������ģ�ȫ���Ƶ���ת����
		else {
			//�ѳ��˵�ʱ������ģ�ȫ���Ƶ���ת����
			hanoi(n-1,from,buf,to);
			System.out.println("��"+n+"�����Ӵ�"+from+"�ƶ���"+to);
			//����ת�����ϵ�ȫ���Ƶ�Ŀ������
			hanoi(n-1,buf,to,from);
		}
	}
}
