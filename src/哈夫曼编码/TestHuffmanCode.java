package ����������;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TestHuffmanCode {

	public static void main(String[] args) {
//		//Huffman����ʵ�ֶ�String�ı���ͽ��� 
//		String msg = "teacher's code is wrong because of the lacking dispose of the last byte which may get a zero start.";
//		//Ҫ���й��������룬������ֱ�ӶԸ�String���б��룻����Ҫ�Ը��ַ�����byte������б���
//		//1.��ȡ���ַ�����byte����[getBytesĬ��unicode���룬�õ�ÿһ���ַ���Ӧ��unicode���룬byte���鳤�ȼ��ַ�����]
//		byte[] bytes = msg.getBytes(); 
//		//2.���й��������� 
//		byte[] b = huffmanZip(bytes);
//		System.out.println("2.������������b:");//����b[]��ÿһλ����huffcodes�����ÿ��λ�������������������û������
//		System.out.println("ԭbytes.length:"+bytes.length+"\nѹ����length:"+b.length);
//		//3.���н��� 
//		byte[] newBytes = decode(huffCodes,b);//��Ҫ�������õ����ĸ��������>huffCodes
//		//�����ص�bytes����ת��String
//		String s = new String(newBytes);
//		System.out.println("after decode:"+s);
		 

		/**
		 * ��������huffman��������� ʵ��ͨ��huffman���������ļ�ѹ������
		 */
		//1.ѹ���ļ�
		String src = "F:\\JAVA\\huffmanzipTest\\zz.png";
		String dst = "F:\\JAVA\\huffmanzipTest\\zz.zip";
		String newdst = "F:\\JAVA\\huffmanzipTest\\zz2.png";
		try {
			zipFile(src, dst);
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		//2.��ѹ�ļ�
		try {
			unZip(dst,newdst);
		} catch (FileNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	
	/**
	 * �ļ��Ľ�ѹ
	 * @param src
	 * @param dst
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void unZip(String src,String dst) throws IOException, ClassNotFoundException {
		//�ȴ�src�ж�ȡ����
		FileInputStream fis = new FileInputStream(src);
		ObjectInputStream ois = new ObjectInputStream(fis);
			//��ȡҪ�����������Ұ���д���˳����ж�ȡ
		//1����ȡ��д���byte����
		byte[] b = (byte[])ois.readObject();
		//2����ȡ��д���huffCodes
		HashMap<Byte,String> huffcodes = (HashMap)ois.readObject();
		ois.close();
		fis.close();
		
		//��ʼ����
		byte[] by = decode(huffcodes,b);
		
		//д���ļ�
		FileOutputStream fos = new FileOutputStream(dst);
		fos.write(by);
		fos.close();
	}

	/**
	 * ѹ���ļ�
	 * 
	 * @param src
	 * @param dst
	 */
	private static void zipFile(String src, String dst) throws IOException {
		// ���ȴ���һ��������,��src�ļ��ж�ȡ
		FileInputStream fis = new FileInputStream(src);
		// Ȼ������һ����Ŀ���ļ�һ�����byte���飬����һ���Զ�ȡ
		byte[] b = new byte[fis.available()];
		// ��ȡ
		fis.read(b);
		fis.close();
		// �Զ�ȡ���ļ�byte�������huffman����
		byte[] byteZip = huffmanZip(b);
		System.out.println("b.length:"+b.length);
		System.out.println("byteZip.length:"+byteZip.length);

		// ���������������codesд�뵽�ļ�dst��
		FileOutputStream fos = new FileOutputStream(dst);
		// ��ATTTT:FileOutputStream���ֽ�����д�������ǻ�Ҫ���Զ������͵�huffcodesд�룬�������ܽ��룬������Ҫ�õ�ObjectOutputStream!��
		// ObjectOutputStream�Ĺ��췽���У�����Ĳ��������ļ�������output�������Ի��ǵ�����FileOutputStream����һ���ļ������
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		//д���˳�����֮��Ķ�ȡ˳��
		oos.writeObject(byteZip);
		oos.writeObject(huffCodes);
		oos.close();
		fos.close();
	}

	/**
	 * ʹ��ָ���Ĺ�������������й���������
	 * 
	 * @param huffCodes �����������
	 * @param bytes     ������
	 * @return
	 */
	static ArrayList<Byte> decodes = new ArrayList<Byte>();

	private static byte[] decode(Map<Byte, String> huffCodes, byte[] bytes) {
		StringBuilder sb = new StringBuilder();// ����װת�����ƺ�����ַ���
		// 1.��byte����תΪһ�������Ƶ��ַ���
		for (int i = 0; i < bytes.length; i++) {
			byte b = bytes[i];
			boolean flag = (i == bytes.length - 1);
//			String s = Integer.toBinaryString(b);//����ֱ��ת����ΪInteger.toBinaryString(int i)����Ĭ�ϴ��������תint��ת�����ơ���>��int�ڼ������ռ32λ
			// �Ҽ���������������ò����ʾ�ģ����Ը����ͻ���32λ;������ǰ���0��ȫ�����ˣ�����8λ����>��Ҫȫ����8λ
			// solve way������ȡ����λ��ǰ���ȫ1����������������λ�Ĳ�0
			String s = byteToBitStr(!flag, b);
			// �����ֳ�����һ�����⣬bytes�����һ��Ԫ�ؿ��ܲ���8λ���Ҳ��ܲ�0����>��byteToBitStr������һ��flag������Ҫ��Ҫ��
			sb.append(s);
		}
		System.out.println("Huanyuan:" + sb.toString());//�ҵ������ˣ����һ���ַ�����Ϊ��8λ���������λ��0���������ֲ���ȫ8λ���ͻ�ɾ������λ��0�����Դӻ�ԭ�Ϳ�ʼ���ˣ�
		//����Ҫ�Ӹ��磺��һ��ʼ��0111�������������ֵ�λ�ã���Ҫ��¼���һ�Σ�����8λ������
		// 2.���ַ�������ָ���Ĺ�����������н���
		// (1)����Ҫ�ѹ����������HashMap��ֵ�Ե�������>ʵ��ͨ��key�ı��� get����Ӧ�����value�ַ�
		Map<String, Byte> map = new HashMap<String, Byte>();
		Set<Entry<Byte, String>> entry = huffCodes.entrySet();
		for (Entry<Byte, String> en : entry) {
			map.put(en.getValue(), en.getKey());
		}
		// (2)�����ַ���������
		for (int i = 0; i < sb.length();) {
			int count = 1;// ��Ϊ��֪������λ���ֻ�����һ��ԭ�ַ�������Ҫ��¼һ��
			boolean flag = true;// �����ж� ÿ��ȡһ���ַ� �Ƿ�ƥ��ɹ����ɹ���������������һ�֣�����count++������
			// ÿ��while�ܳɹ�����һ��kv match
			while (flag) {
				// ͨ����ǰ���ȵ�����keyȥget�����Ϊnull��ƥ�䲻�ɹ�
				String s = sb.substring(i, i + count);// subString��ȡ��i+count��ǰһ��
				Byte b = map.get(s);
				if (b == null) {
					// ƥ��ʧ��
					count++;
				} else {
					// ƥ��ɹ�
//					System.out.println(b);//���Դ������ӡ�۲쵽ȡ�û�����������ԭ��Ӧ�ַ���unicode�룬ֻ��Ҫ����byte���飬�ٱ任���ַ�������
					// ������һ�����⣺byte����ĳ���δ֪...����>���Բ�����byte����ţ���֪�������޷���ʼ������>��һ����������
					System.out.println("���ͳ��ַ���"+b);
					decodes.add(b);
					flag = false;
				}
			}
			i += count;
		}
		System.out.println("decodes list:" + decodes.toString());// �����ӡ���Կ����Ѿ�������һ��list���پݴ˷�����ַ�����
		byte[] res = new byte[decodes.size()];
		for (int i = 0; i < decodes.size(); i++) {
			res[i] = decodes.get(i);
		}
		return res;
	}

	// ʵ�ֲ�ȫ
	public static String byteToBitStr(boolean flag, byte b) {
		int temp = b;
		if (flag) {// ��������һ��byte����Ҫ��
//			System.out.println("temp��ǰ��"+Integer.toBinaryString(temp));
			temp |= 256;// 256��1 0000 0000;���԰�λ������ĺ��λ��������Ҫ�ġ���>��Ҫ��Ե��ǲ���8λ����������ȫ����9λ���ҵ�һλ=1�����Ժ��λ����Ҫ�ã�����0��ͷ��Ҳ���ᱻ����
//			System.out.println("temp���"+Integer.toBinaryString(temp));
		}
		String s = Integer.toBinaryString(temp); //��������һ��byte��ֱ��ת�����Ƹ�s(���һ��byteΪ8λʱҪ��������)�������Ⱥ�256��λ��
		if (flag) {// ��������һ��byte
			System.out.println("bytes:"+s.substring(s.length() - 8));
			return s.substring(s.length() - 8);
		} else {
			//����Ҫ����lastbyteLength���ԭ���һλ�ĳ��Ƚ��л�ԭ����Ϊ�������0��ͷ�������һ��ò���8λ�����п�ͷ��0���ᱻ�������Ӷ������������
			//���ǻ�Ҫ���ǣ�������һ��byteΪ������ǰ��ȫ1������Ҫ
			System.out.println("lastbyteLength:"+lastbyteLength);
			if(lastbyteLength==8) {//������һ��byteǡ��ʣ8λ��������ֱ��ȡ
				return s.substring(s.length()-8);
			}
			if(s.length()<lastbyteLength) {
				StringBuilder strb = new StringBuilder(s);
				for(int i=0;i<lastbyteLength-s.length();i++) {
					strb.insert(0,"0");
				}
				s = strb.toString();
			}
			System.out.println("last bytes"+s);
			return s;
		}
	}

	/**
	 * ����huffman����ѹ���ķ���
	 * 
	 * @param bytes
	 * @return
	 */
	private static byte[] huffmanZip(byte[] bytes) {
		// �����Ĳ����ϸ��ӣ����Ը�дһ������
		// 1.ͳ��ԭbyte�����и��ַ����ֵ�Ƶ��,������һ�������С���>�ڵ�Ȩֵweight;���Ұ���Ȩֵ��������
		List<Node> nodes = getNodes(bytes);
//		for(int i=0;i<nodes.size();i++) {
//			System.out.println(nodes.get(i));
//		}
		// 2.����һ��huffman��
		Node tree = createHuffmanTree(nodes);
		// 3.����һ�������������
		Map<Byte, String> huffCodes = getCodes(tree);
		System.out.println("huffCodes:" + huffCodes);
		// 4.����
		byte[] b = zip(bytes, huffCodes);
		return b;
	}

	/**
	 * ���й��������� ��ÿһ��byte����huffCodes����ת����Ȼ��ƴ��
	 * 
	 * @param bytes
	 * @param huffCodes
	 * @return
	 */
	static int lastbyteLength = 8;//���ڼ�¼���һ�������λ��byte��length���Է�����Ӷ�������תΪ����ʱ����λ��0��ʧ//default=8�����ܴ������һ��byte����8λ�����
	private static byte[] zip(byte[] bytes, Map<Byte, String> huffCodes) {
		// ��sbȥװ������byte,����Ҫѹ����byte��������һ���������ַ���
		StringBuilder sb = new StringBuilder();
		for (byte b : bytes) {
			sb.append(huffCodes.get(b));
		}
		System.out.println("����������󣬶�Ӧhuffcode(length:" + sb.length() + "):" + sb);
		// ��������Ҫ�ѱ������ַ���תΪһ��byte���飨ÿ8λת��һ��byte��
		int len = (sb.length() + 7) / 8;
		byte[] by = new byte[len];
		// ʹ��һ��index��¼��ǰ����by������±�
		int index = 0;
		for (int i = 0; i < sb.length(); i += 8) {
			String subStr;
			if ((i + 8) > sb.length()) {//���ǡ�����Ҳʣ8λ���Ͳ����������
				subStr = sb.substring(i);
				lastbyteLength = sb.length()-i;//��¼�����λ��0��������Ϊ����ȫ8λ�ͱ�����
				System.out.println("subStr last:"+subStr);
			} else {
				subStr = sb.substring(i, i + 8);
			}
			// ���и�õģ�ÿ��λ���ֵ��ַ������Զ�����ת����һ���µ�����
			byte byt = (byte) Integer.parseInt(subStr, 2);
//			System.out.println("subStr:"+subStr+",byte:"+byt);
			by[index] = byt;
			index++;
		}
		return by;
	}

	/**
	 * ����һ��huffman��������һ��huffman����� Ҫ����룬��Ҫ���������Աض����õ��ݹ�
	 * 
	 * @param tree
	 * @return
	 */
	// Ҫ�Խڵ���룬������¼ÿһ���߹���ÿһ��·������������������һ��StringBuilder��̬��Ա���������ڼ�¼
	static StringBuilder sb = new StringBuilder();

	private static Map<Byte, String> getCodes(Node tree) {
		if (tree == null) {
			return null;
		}
		getCodes(tree.left, "0", sb); // ÿ����������0�������ڵݹ���ڴ���֮ǰ·���ļ�¼����>����һ���������ڵݹ�
		getCodes(tree.right, "1", sb);
		return huffCodes;
	}

	// ����huffman������̵ĵݹ����
	// ��Ҫһ��HashMap��Ա�������洢�Ѿ�����õ��ַ������Ӧ·��
	static Map<Byte, String> huffCodes = new HashMap<Byte, String>();

	private static void getCodes(Node node, String code, StringBuilder sb) {
		if (node == null) {
			return;
		}
		StringBuilder sb2 = new StringBuilder(sb);
		sb2.append(code);
		// ÿ�εݹ��һ���ڵ㣬��Ҫ���˽ڵ��data�Ƿ�Ϊnull�������Ϊnull����Ҫ�������huffman�����Map��
		if (node.data == null) {
			getCodes(node.left, "0", sb2);
			getCodes(node.right, "1", sb2);
		} else {
			// ���˽ڵ㼰��ǰ·��String����һ��hashmap
			huffCodes.put(node.data, sb2.toString());
		}
	}

	/**
	 * ���ڴ���huffman��
	 * 
	 * @param nodes
	 * @return
	 */
	private static Node createHuffmanTree(List<Node> nodes) {
		// ѭ��ȡ������ĩβ�����ڵ�
		while (nodes.size() > 1) {
			// ��list��������
			Collections.sort(nodes);
			// ȡ��С�������ֱ��������ӽ����ں�
			Node left = nodes.get(nodes.size() - 1);
			Node right = nodes.get(nodes.size() - 2);
			Node parent = new Node(null, left.weight + right.weight);
			// �Ƴ��������ںϵ�
			nodes.remove(left);
			nodes.remove(right);
			// �޸�parentָ��
			parent.left = left;
			parent.right = right;
			// �ںϺ�Ľڵ����list
			nodes.add(parent);
		}
		return nodes.get(0);
	}

	/**
	 * ��byte����תΪnode����
	 * 
	 * @param bytes
	 * @return
	 */
	private static List<Node> getNodes(byte[] bytes) {
		// 1.��byteװ��node����>ע��������ظ��ģ����Բ���ֻ��list����>hashmap
		List<Node> nodes = new ArrayList<Node>();
		// 2.HashMapͳ��ÿһ��byte���ֵĴ�����key��byte value�����ִ�����
		Map<Byte, Integer> counts = new HashMap<Byte, Integer>();
		for (byte b : bytes) {
			// ���ȸ���b�����keyȥȡvalue
			Integer count = counts.get(b);
			// ���������1�������ǵ�һ�γ��ֵ��������b����
			if (count == null)// ����java��װ���Ĭ�ϳ�ʼֵ��=null
			{
				count = 1;
				counts.put(b, count);
			}
			// ��2�����ǵ�һ�γ����ˣ�ֱ�Ӷ�count++
			else {
				count++;
				counts.put(b, count);
			}
			// ������������ͳ�Ƴ����ַ����ֵ�Ƶ��
		}
		// ��ӡ���������һ��HashMap��д��toString���������Կ���ֱ�Ӵ�ӡ��HashMap����
		System.out.println("each byte weight:" + counts);
		/**
		 * //��ӡ���������һ��ͨ��HashMap��entrySet()������ȡ����ֵ�Ե�Set��������Set //ABOUT
		 * Entry����������һ����̬�࣬ʵ��Map.Entry< K ,V>,ͨ���ҿ��Թ���һ������������java�����ĵ���û���ҵĵ�λ����ֻ��һ���ڲ��ࡣ
		 * Set<Entry<Byte,Integer>> se = counts.entrySet(); //Set�е�ÿһ��Ԫ�ض���Entry��Ķ���
		 * for(Entry<Byte,Integer> s:se) {
		 * System.out.println("key:"+s.getKey()+",value:"+s.getValue()); }
		 * 
		 * //��ӡ���������Ƽ���ֻ��ӡ��value��û�ж�Ӧ��key Iterator<Integer> it =
		 * counts.values().iterator(); while(it.hasNext()) {
		 * System.out.println(it.next()); }
		 */
		// 3.ͳ������ִ�������ҪתΪ�ڵ�
		for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
			// ��ÿ����ֵ�ԣ����data��weight�����봴����ArrayList�У��Ա�������ݸ�list���ɹ�������
			nodes.add(new Node(entry.getKey(), entry.getValue()));
		}
		return nodes;
	}
}
