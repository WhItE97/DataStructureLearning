package ����;

public class MyArrayTest {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

		//����һ���ɱ�����
		MyArray a = new MyArray();
		
		//��ȡ����
		int len = a.size();
		System.out.println("len:"+len);
		a.show();
		
		//���ɱ����������һ��Ԫ�ص�ĩβ
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		a.add(5);

		//��ʾ�ɱ�������Ԫ�ص�����̨
		a.show();
		
		//�����±�ɾ��ĳ��Ԫ��
		a.delete(3);
		a.show();
		
		//ȡ��ָ��λ�õ�Ԫ��
		int out = a.get(0);
		System.out.println("out:"+out);
		
		//����Ԫ�ص�ָ��λ��
		a.insert(3, 10);
		a.show();
		a.insert(4, 77);
		a.show();
		
		//�滻ָ��λ�õ�Ԫ��
		a.replace(7, 66);
		a.show();
	}
}
