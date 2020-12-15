package 数组;

public class MyArrayTest {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		//创建一个可变数组
		MyArray a = new MyArray();
		
		//获取长度
		int len = a.size();
		System.out.println("len:"+len);
		a.show();
		
		//往可变数组中添加一个元素到末尾
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		a.add(5);

		//显示可变数组中元素到控制台
		a.show();
		
		//根据下标删除某个元素
		a.delete(3);
		a.show();
		
		//取出指定位置的元素
		int out = a.get(0);
		System.out.println("out:"+out);
		
		//插入元素到指定位置
		a.insert(3, 10);
		a.show();
		a.insert(4, 77);
		a.show();
		
		//替换指定位置的元素
		a.replace(7, 66);
		a.show();
	}
}
