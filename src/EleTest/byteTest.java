package EleTest;

import java.util.Arrays;

public class byteTest {
/**
 * 1.getBytes()可以指定编码方式，默认unicode
 * 2.unicode编码中：A~Z 65-90//a~z 97-122//0~9 48-57
 * @param args
 */
	public static void main(String[] args) {
		String msg = "what";
		byte[] bytes = msg.getBytes();
//		System.out.println(bytes.length);
//		for(int i=0;i<bytes.length;i++) {
//			System.out.println(bytes[i]);
//		}
		
		byte a = 11;//
		System.out.println(a);

		byte b = 'a';
		System.out.println(b);
		
		byte[] c = "a".getBytes();
		System.out.println(Arrays.toString(c));
		
		byte d = '1';
		System.out.println("d:"+d);
		
		//byte e = 'wo';
		//java中单引号是 char型——>只能引一个字符
		//双引号是 String型——>可以引0个及以上
	}
}
