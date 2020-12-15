package EleTest;

public class 进制 {
	public static void main(String[] args) {
		int i1 = 0x11;//0x 16进制，后面的每位数字转为4位2进制 所以=00010001=十进制1+16=17
		System.out.println("0x11二进制形式："+Integer.toBinaryString(i1));
		System.out.println(i1);
		int i2 = 022;//0 8进制，后面的每位数字转为3位二进制 所以=010010=十进制2+16=18
		System.out.println("022二进制形式："+Integer.toBinaryString(i2));
		System.out.println(i2);
		
		int i3 = -17;//负数不能限制进制
		System.out.println(Integer.toBinaryString(i3));
		System.out.println(Integer.toHexString(i3));
		System.out.println(Integer.toOctalString(i3));
	}
}
