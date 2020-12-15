package 递归;

public class TestHanoi {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		hanoi(9,'A','C','B');
	}
	/**
	 * 
	 * @param n：共n块待移动板子
	 * @param from：从from出发
	 * @param to：到to去
	 * @param buf：中转柱子
	 */
	public static void hanoi(int n,char from,char to,char buf) {
		if(n==1) {
			System.out.println("第1个盘子从"+from+"移动到"+to);
		}
		//无论多少盘子，要想把最底下的移到最终目标位置
		//都得先把除了当时最下面的，全部移到中转柱子
		else {
			//把除了当时最下面的，全部移到中转柱子
			hanoi(n-1,from,buf,to);
			System.out.println("第"+n+"个盘子从"+from+"移动到"+to);
			//把中转柱子上的全部移到目标柱子
			hanoi(n-1,buf,to,from);
		}
	}
}
