package EleTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ListTest {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		List<ListTestNode> ls = new ArrayList<ListTestNode>();
		int[] arr = new int[] {3,2,5,1,6,9};
		//插入list
		for(int val:arr) {
			ls.add(new ListTestNode(val));
		}
		//排序
		Collections.sort(ls);
		
		//遍历输出
		System.out.println("1***************************");
		for(ListTestNode s:ls) {
			System.out.println(s);
		}
		
		
		//删除最后两个节点，而后遍历
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
		
		//获取最后一个节点的值，将其赋给一个新节点，通过Object方式将其remove掉
		ListTestNode no = ls.get(ls.size()-1);
		ls.remove(no);
		System.out.println("4***************************");
		for(ListTestNode s:ls) {
			System.out.println(s);
		}
		
		//插入一个新节点
		ListTestNode nn = new ListTestNode(10);
		ls.add(nn);
		Collections.sort(ls);
		System.out.println("5***************************");
		for(ListTestNode s:ls) {
			System.out.println(s);
		}
	}

}
