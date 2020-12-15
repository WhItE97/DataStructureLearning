package 八大排序;
import java.util.Arrays;

public class HeapSort {
/**
 * 八大排序之3.选择排序 之3.2堆排序
 * 堆排序会用到大顶堆，小顶堆，都是树结构，所以安排在树学习之后
 * 思想：
 * 1.将数组转为一颗完全二叉树
 * 2.对该树进行大顶堆的转换
 * （大顶堆转换：从最后一个非叶子节点开始，将其与其子比较，如果父节点非max，则交换；
 * 如果被交换上来的儿子节点还有儿子，则还需要在交换后进行比较与交换；
 * 依倒序遍历所有非叶子节点，进行如上操作，直至根节点）
 * 3.将根与末尾的叶子交换，然后剪掉最后一个叶子，即为max
 * 4.对剩下的树重复2.3步骤，直至树空
 * @param args
 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] arr = new int[]{9,6,8,7,0,1,10,4,2,22,2};
		HeapSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	//maxHeap实现的只是针对index一个位置，进行大顶堆调整，要想整个堆都调整，还得在调用的时候进行循环遍历所有非叶子节点！！！
	//因为要多次进行大顶堆的调整过程，还需要传入该轮堆的大小size
	//以及本次maxHeap调整哪个节点——>其数组下标index
	public static void maxHeap(int[] arr,int size,int index) {
		//用于将该数组所代表的树转为大顶堆
		//取其左子和右子（可能不存在），以及用一个max来装父与子中最大的节点下标
		int leftNode = 2*index+1;
		int rightNode = 2*index+2;
		int max = index;//先让这个max=爹
		//开始分别与左右子比较
		if(leftNode<size&&arr[leftNode]>arr[max]) {
			max = leftNode;
		}
		if(rightNode<size&&arr[rightNode]>arr[max]) {
			max = rightNode;
		}
		if(max!=index) {
			//如果爹不是最大的，进行节点权值的交换
			int temp = arr[index];
			arr[index] = arr[max];
			arr[max] = temp;
			//HDP：交换位置后可能会破坏之前排好的序号靠后的堆##########################
			maxHeap(arr,size,max);//因为max记录的是被换了位置的节点的原坐标，所以要对该位置进行maxHeap
		}
	}
	
	public static void HeapSort(int[] arr) {
		for(int size=arr.length;size>0;size--) {//用j遍历堆的size
			for(int i=(size-2)/2;i>=0;i--) {
				maxHeap(arr,size,i);
			}
			//本轮大顶堆变换完成，开始剪枝
			int temp = arr[size-1];
			arr[size-1] = arr[0];
			arr[0] = temp;
		}
	}
}
