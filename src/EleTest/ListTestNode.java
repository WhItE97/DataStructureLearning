package EleTest;

public class ListTestNode implements Comparable<ListTestNode>{
	int value;
	
	public ListTestNode(int value){
		this.value = value;
	}

	@Override
	public int compareTo(ListTestNode o) {
		// TODO �Զ����ɵķ������
		if(this.value>o.value) return -1;
		else return 1;
	}

	@Override
	public String toString() {
		return "ListTestNode [value=" + value + "]";
	}
	
}
