package EleTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ListTest {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		List<ListTestNode> ls = new ArrayList<ListTestNode>();
		int[] arr = new int[] {3,2,5,1,6,9};
		//����list
		for(int val:arr) {
			ls.add(new ListTestNode(val));
		}
		//����
		Collections.sort(ls);
		
		//�������
		System.out.println("1***************************");
		for(ListTestNode s:ls) {
			System.out.println(s);
		}
		
		
		//ɾ����������ڵ㣬�������
		ls.remove(ls.size()-1);
		System.out.println("2***************************");
		for(ListTestNode s:ls) {
			System.out.println(s);
		}
		ls.remove(ls.size()-1);
		System.out.println("3***************************");
		for(ListTestNode s:ls) {
			System.out.println(s);
		}
		
		//��ȡ���һ���ڵ��ֵ�����丳��һ���½ڵ㣬ͨ��Object��ʽ����remove��
		ListTestNode no = ls.get(ls.size()-1);
		ls.remove(no);
		System.out.println("4***************************");
		for(ListTestNode s:ls) {
			System.out.println(s);
		}
		
		//����һ���½ڵ�
		ListTestNode nn = new ListTestNode(10);
		ls.add(nn);
		Collections.sort(ls);
		System.out.println("5***************************");
		for(ListTestNode s:ls) {
			System.out.println(s);
		}
	}

}
