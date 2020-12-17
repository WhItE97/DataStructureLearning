package 平衡二叉树;

import java.util.Stack;

public class Node {
	int value;
	Node left;
	Node right;
	
	public Node(int value) {
		this.value = value;
	}
	
	/**
	 * height用于返回当前节点的高度
	 * core:当前节点高=max(左子树,右子树)
	 * @return
	 */
	public int height() {
//		return Math.max(left.height(), right.height())+1;//但是左右子树可能为空，所以修改如下
		return Math.max(left==null?0:left.height(), right==null?0:right.height())+1;
	}
	
	/**
	 * 获取左子树的高度
	 * ATT:
	 * 上面的height只处理了求左右子树的高度max，能调用他的节点一定是存在的！
	 * 但是在我们计算左子树or右子树高度时，可能根本就没有左or右子树，也就没办法调用height方法，所以会报NullPointerException
	 * @return
	 */
	public int leftHeight() {
		if(left==null)
			return 0;
		return left.height();
	}
	
	/**
	 * 获取右子树的高度
	 * @return
	 */
	public int rightHeight() {
		if(right==null)
			return 0;
		return right.height();
	}
	
	//中序遍历BST得到一个有序数组（非递归）
	//访问与处理顺序不一致（访问要一直到树的左边最底部，处理从中间节点开始）
	public void NonRecursionInTraversal() {
		Node cur = this;//用于记录访问顺序
		Stack<Node> st = new Stack<Node>();
		while(!st.isEmpty()||cur!=null) {
			if(cur!=null) {
				st.push(cur);
				cur = cur.left;
			}
			else {
				cur = st.pop();//中
				System.out.print(cur.value+" ");
				cur = cur.right;
			}
		}
	}

	/**
	 * 向子树中添加节点
	 * 法一：
	 * 自己的非递归解法
	 * 通过一个while循环找到该节点应该插入的位置（每轮都和一个节点进行比较，大了就继续和右子比，小了就继续和左子比，直到无子）
	 * 使用一个pre Node记录该无子节点，再通过一个boolean记录插入节点的value和pre Node的大小关系，插入节点大就往右子放，小就往左子放
	 * @param node
	 */
	static Node pre;
	static Boolean leftflag = null;
	public void selfadd(Node node) {
		if(node==null) {
			return;
		}
		Node n = this;
		//找到自己该在的位置
		while(n!=null) {
			if(n.value<node.value) {
				//附加node的值大于当前值
				//如果加在当前node，则加在右子，则leftflag=false
				leftflag = false;
				pre = n;
				n = n.right;
				continue;
			}
			else {
				//附加node的值小于当前值
				leftflag = true;
				pre = n;
				n = n.left;
			}
		}
		//跳出来
		if(leftflag) {
			pre.left = node;
		}
		else {
			pre.right = node;
		}
	}
	
	/**
	 * 向二叉排序树中添加节点
	 * 法二：递归添加
	 * @param node
	 */
	public void add(Node node) {
		if(node==null) {
			return;
		}
		//判断传入节点的value和当前子树！的根节点的value大小
		if(node.value<this.value) {
			//如果node值更小,分两种情况处理
			//1）this没有左子了，直接嵌上去
			if(this.left==null) {
				this.left=node;
			}
			else {
				this.left.add(node);
			}
		}
		else {
			//如果node值更大,同样分两种
			//1）this没有右子，直接嵌上去
			if(this.right==null) {
				this.right = node;
			}
			else {
				this.right.add(node);
			}
		}
		
		/**
		 * 上面是普通的BST构建，插入节点的过程，可能会造成不平衡，影响BST查找性能
		 * 所以下面开始作BST——>AVL
		 */
		//每添加一个节点，都要检查该BST 是否还平衡(其左子和右子的高度差是否<=1)——>所以需要一个方法来求当前节点的高度
		//1.LL型：左子树的height-右子树的height>=2
		//右旋转α节点
//		if(left.height()-right.height()>=2) {//左边的树和右边树可能是空的，所以这里会报空指针异常，新增两个专门求leftheight和rightheight的方法，换成如下
		if(leftHeight()-rightHeight()>=2) {
			//新增LR型判断
			//1.2 LR型:先对L子进行左旋，再对this本身进行右旋
			//判断条件：左子的右子树高度大于左子树高度
			if(left.leftHeight()<left.rightHeight()) {
				left.leftRotate();
				rightRotate();
			}
			else {//否则就是LL型,只用右旋即可
				rightRotate();
			}
		}
		//2.RR型
		//左旋转α节点
		else if(leftHeight()-rightHeight()<=-2){
			//2.2 RL型判断:若是RL型，则先对右子进行右旋，再左旋
			//判断条件：右子的左子树高度大于右子树高度
			if(right.leftHeight()>right.rightHeight()) {
				right.rightRotate();
				leftRotate();
			}
			else {//否则就是RR型,直接左旋
				leftRotate();
			}
		}
	}
	
	/**
	 * 右旋转
	 */
	private void rightRotate() {
		//1.拷贝当前节点的值，创建一个新的节点
		Node node = new Node(this.value);
		//2.新节点的右子=当前节点的右子
		node.right = this.right;
		//3.新节点的左子=当前节点左子的右子
		node.left = this.left.right;//可能不存在,null也一样可以拷贝！
		//4.当前节点的值设置为其左子的值
		this.value = left.value;
		//5.跳过当前节点的左子（因为其值已经拷贝到当前节点中）,将当前节点的左子设置为左子的左子
		left = left.left;
		//6.当前节点的右子设置为新节点
		right = node;
	}
	
	/**
	 * 左旋转
	 */
	private void leftRotate() {
		Node node = new Node(this.value);
		node.left = this.left;
		node.right = this.right.left;
		this.value = right.value;
		right = right.right;
		left = node;
	}

	/**
	 * 输入一个value，查找对应节点，如果存在则返回该节点
	 * @param value
	 * @return
	 */
	public Node search(int value) {
		if(this.value==value) {
			return this;
		}
		if(this.value>value&&this.left!=null) {
			return left.search(value);
		}
		if(this.value<value&&this.right!=null){
			return right.search(value);
		}
		//找完了都没有
		return null;
	}

	public Node searchParent(int value) {
		if((this.left!=null&&this.left.value==value)||(this.right!=null&&this.right.value==value)) {
			return this;
		}
		else {
			//如果value比当前节点小，则往左子找
			if(this.value>value&&this.left!=null) {
				return this.left.searchParent(value);
			}
			//如果value大于当前节点，往右子找
			if(this.value<value&&this.right!=null) {
				return this.right.searchParent(value);
			}
			//都没找到
			return null;
		}
	}
}
