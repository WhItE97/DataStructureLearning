package �˴�����;
import java.util.Arrays;

public class QuickSort {
/**
 * �˴�����֮1����������֮1.2����������
 * ˼�룺ÿ��ȡһ��pivot��С�ķ�������ߣ���ķ������ұ�...�ݹ���ȥ
 * @param args
 */
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int[] arr = {2,4,1,5,2,3};
		QuickSort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
	/**
	 * ��Ƶ�ϵ����������Լ��ķ���������һ��˼·������д�ĸ����
	 * ���ǣ��ٽ�ֵ������Ҫע�⣡����д���ڴ�while�µ�����Сwhile��һ��Ҫ��arr[xxx]>=��<=!!!
	 * ��=�����ܶ�����Ȼ���������ע�͵���ѭ������
	 * @param arr
	 * @param start
	 * @param end
	 */
	public static void quickSort(int[] arr,int start,int end) {
		//Ҫע�⿼�ǵݹ����ʱ����б�����
		//�����ں�������Χ����һ��start end�б�
		if(start<end) {
			int left = start;
			int right = end;
			int pivot = arr[start];
			while(left<right) {
				//����arr[right] >= pivot
				//�����С�=������Ϊ��
				//����ڶ���Сwhile�� arr[left]==pivot�������������û�
				//��arr[right]=arr[left]==pivot,��rightû����--����������һ�δ�ѭ����ʱ��arr[right]��ʼ��==pivot
				//Сwhile 1��Сwhile 2�������left��right���и��ģ��Ӷ��������޵�arr[left]��arr[right]���ำֵ����>������ѭ��
				/**
				 * 2021.1.25 ��ָoffer39�������г��ִ�������һ�������->�ÿ��ŵķ���partition��review���֣�
				 * �����partitionÿ�������Ƶ�ʱ���ܶ�ȡ�ȣ�ֻ������һ��ȡ��=>
				 * һ�ֹ�ȥ���ض��е����Լ��Ķ���С����һ��or�����һ�ߣ�
				 * ������֮���Կ��Զ�ȡ��=>������Լ���ȵķֲ����Լ������࣬�����ĵݹ�Ҳ�����ո�Ϊ��ȷ˳��
				 * ��Con�������ж�ȡ�ȣ���ָoffer40.��С��k����Ҳ��ȡ�ȣ�ֻcare������k����С�ڵ����ұߵģ���
				 * ��ָoffer39.�����г��ִ�������һ�������[����ֻ��]һ��ȡ�ȣ��Ա�֤���ֽ��������к��Լ���ȵĶ���һ�ߡ�
				 * ��2021.1.25 con:����˼·�У�ÿ�����Ҽ�����[ȡ�����]ȡ�������Ԫ�آٷ�ɢ��pivot���ߢڼ�����pivotһ�� 
				 * �᲻�������Ľ�����Ӱ�죡���Ծ�����������������
				 */
				while(left<right && arr[right]>=pivot){
					right--;
				}
				arr[left] = arr[right];
				
				while(left<right && arr[left]<=pivot) {
					left++;
				}
				arr[right] = arr[left];
			}
			arr[left] = pivot;
			quickSort(arr,start,left-1);
			quickSort(arr,left,end);
		}
	}
	
	
	/**
	 * ϰ�ߵ�����
	 * �ѿ��ŵ��������̲�ֳ�ÿ��pivotһ��sort + return ��pivot����λ�� �Ӷ�����ݹ�ĵݹ麯��
	 * @param arr
	 * @param left
	 * @param right
	 * @return
	 */
	//partitionּ�����һ��pivot�ķָ�
	//���أ�һ������pivotλ�õ�intֵ�������ڵݹ�
	public static int partition(int[] arr,int left,int right) {
		int pivot = arr[left];
		while(left<right) {
//			���ҵ���������ұ�pivotС�ģ��ŵ���߿�λ����ʼ��λ��pivot��λ�ã�
			while(left<right) {
				if(arr[right]<pivot) {
					arr[left] = arr[right];
					//��ʱrightλ�õ�Ԫ���Ѿ�copy��leftλ�ã����Ը�λ�ÿ������յ�
					left++;
					break;
				}
				right--;
			}
			
			
			//�����ұ������ұ�pivot��ģ��ŵ��ұ߿�λ
			while(left<right) {
				if(arr[left]>pivot) {
					arr[right] = arr[left];
					right--;
					break;
				}
				left++;
			}
		}
		arr[left] = pivot;
		return left;
	}
	
	
	public static void QuickSort(int[] arr,int left,int right) {
		int mid = 0;
		if(left<right) {
			mid = partition(arr,left,right);
			QuickSort(arr,left,mid);
			QuickSort(arr,mid+1,right);
		}
		else {
			return;
		}
	}
}
