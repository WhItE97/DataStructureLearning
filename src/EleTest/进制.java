package EleTest;

public class ���� {
	public static void main(String[] args) {
		int i1 = 0x11;//0x 16���ƣ������ÿλ����תΪ4λ2���� ����=00010001=ʮ����1+16=17
		System.out.println("0x11��������ʽ��"+Integer.toBinaryString(i1));
		System.out.println(i1);
		int i2 = 022;//0 8���ƣ������ÿλ����תΪ3λ������ ����=010010=ʮ����2+16=18
		System.out.println("022��������ʽ��"+Integer.toBinaryString(i2));
		System.out.println(i2);
		
		int i3 = -17;//�����������ƽ���
		System.out.println(Integer.toBinaryString(i3));
		System.out.println(Integer.toHexString(i3));
		System.out.println(Integer.toOctalString(i3));
	}
}
