package ����������;

public class Node implements Comparable<Node>{
	Byte data;//�ýڵ���������ַ�����>���Ǹ�huffmantree���������нڵ㶼��data�ģ���Щ�ںϵ㣬�ǲ����ַ��ģ�����Ҫ����=null��������byte�ķ�װ��Byte��д
	int weight;//Ȩֵ������Ƶ��
	Node left;
	Node right; 
	
	public Node(Byte data,int weight) {
		this.data = data;
		this.weight = weight;
	}
	
	public String toString() {
		return "data:"+data+",weight:"+weight;
	}
	
	public int compareTo(Node o) {
		if(this.weight<o.weight) return 1;//�������ǴӴ�С������������һ��-1��ʵ�ִ�С��������
		if(this.weight==o.weight) return 0;
		else return -1;
//		return o.weight-this.weight;
	}
}
