package 二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//一个节点
public class TreeNode {
	//节点值/权
	int value;
	//每个节点的左儿子和右儿子
	TreeNode leftNode;//ctrl+1可以快速生成该属性的getter/setter方法
	TreeNode rightNode;
	
	public TreeNode(int value) {
		this.value = value;
	}
	//设置左儿子
	public void setleftNode(TreeNode node) {
		this.leftNode = node;
	}
	//设置右儿子
	public void setrightNode(TreeNode node) {
		this.rightNode = node;
	}
	
	//非递归前序遍历——>（递归都是靠栈来实现的）所以可以使用迭代法（借助栈）来实现递归的效果
	public void NonRecursionPre() {
		//用到栈先进后出
		//思路：
		//先把root压进栈，开始以栈是否为空进入循环
		//每pop一个，都要将其右儿子、左儿子依序压入栈
		//重复直至栈空
		Stack<TreeNode> st = new Stack<TreeNode>();
		st.push(this);
		while(!st.isEmpty()) {
			TreeNode t = st.pop();
			System.out.print(t.value+" ");//中D
			if(t.rightNode!=null) {//左L
				st.push(t.rightNode);
			}
			if(t.leftNode!=null) {//右R
				st.push(t.leftNode);
			}
		}
	}
	
	//非递归中序遍历
	/**
	 * 思路：
	 * 每个节点的第一次经过，都不访问，而是入栈
	 * 一直到左子树遍历、访问完后，才对自己访问并出栈
	 * 然后再对自己的右子进行相同操作
	 * HDP:
	 * 结束循环的条件：栈不为空 || 节点指针不为空
	 * 
	 * 和非递归先序相比：
	 * 非递归先序遍历：DLR，要访问的节点和要处理（输出并出栈）的节点都是中间节点，访问和处理的元素顺序一致，所以代码简洁
	 * 非递归中序遍历：LDR，先访问的是二叉树顶部的节点，直到访问到树左侧最底部，才开始处理（输出并出栈）节点；so：用指针遍历帮助访问，栈负责处理节点上的元素
	 */
	public void NonRecursionIn() {
		Stack<TreeNode> st = new Stack<TreeNode>();//用来处理
		TreeNode node = this;//用来帮助遍历访问
		while(!st.isEmpty()||node!=null) {
			//优先访问leftNode
			if(node!=null) {
				st.push(node);
				node = node.leftNode;//左L
			}
			//此节点没有leftNode了，那就把自己访问并出栈掉
			else {
				node = st.pop();
				System.out.print(node.value+" ");//中D
				//HDP:自己初次没有考虑到的
				//node.rightNode如果为空，且——>①栈也无元素（右子树的父节点无了），右子树也空了，那就break出while了；②栈有元素，则回到上一个父节点
				node = node.rightNode;//右R
			}
		}
	}
	
	//非递归后序遍历
	/**
	 * 思路：
	 * 先序遍历是DLR，后序遍历是LRD，所以只要把先序的DLR——>DRL，就能得到反序的后续遍历！（只用存起来，反序输出即可）
	 */
	public void NonRecursionPost() {
		Stack<TreeNode> st = new Stack<TreeNode>();
		List<Integer> list = new ArrayList<Integer>();//用于存放DRL的结果，以便后续反序输出LRD
		TreeNode node = this;
		st.push(node);
		
		while(!st.isEmpty()) {
			//类似DLR实现DRL
			//所以来一个访问一个
			node = st.pop();
			list.add(node.value);
			//DRL所以要先压入L
			if(node.leftNode!=null) {
				st.push(node.leftNode);
			}
			if(node.rightNode!=null) {
				st.push(node.rightNode);
			}
		}
		//循环完得到一个DRL的list，反序输出即为LRD
		for(int i=list.size()-1;i>=0;i--) {
			System.out.print(list.get(i)+" ");
		}
	}
	
	//DLR先序遍历 当前节点
	public void preorderTraversal() {
		System.out.print(value+" ");
		//递归先序左子树
		if(leftNode!=null) {
			leftNode.preorderTraversal();
		}
		//再递归右子树
		if(rightNode!=null) {
			rightNode.preorderTraversal();
		}
	}
	
	//LDR中序遍历 当前节点
	public void inorderTraversal() {
		//递归先序左子树
		if(leftNode!=null) {
			leftNode.inorderTraversal();
		}
		System.out.print(value+" ");
		//再递归右子树
		if(rightNode!=null) {
			rightNode.inorderTraversal();
		}
	}
		
	//LRD后序遍历 当前节点
	public void postorderTraversal() {
		//递归先序左子树
		if(leftNode!=null) {
			leftNode.postorderTraversal();
		}
		//再递归右子树
		if(rightNode!=null) {
			rightNode.postorderTraversal();
		}
		System.out.print(value+" ");
	}
	
	//前序查找DLR
	public TreeNode frontSearch(int i) {
		TreeNode target = null;
		//对比当前节点的值
		if(value==i)
			return this;
		//没有匹配成功，则找左儿子
		//先判断有没有左儿子
		if(leftNode!=null) {
			//用target装左儿子的值，没找到则target==null————>自己的错误点！
			//自己写的时候没有用target吃返回值，而是像之前遍历一样直接递归调用了
			//ATT java基础上的理解错误！
			//【子递归中的return，只结束了该【子】递归（不能结束整个递归流程！），返回值传给了他的上一级递归调用，如果上一级不对这个返回值做处理，则此返回值实际没起作用】
			//所以这里必须要吃下返回值，并且层层返回
			//########画图尝试一个流程进行理解，理解难点在于：
			//当找到了value后，该节点是被自己的上一级调用的，并且上一级用target吃了这个返回值；然后上上一级又会吃掉上一级的返回值...
			//直至根节点的父调用——>吃到返回之后直接return该target，结束了父递归，从而结束了整轮递归
			target = leftNode.frontSearch(i);
		}
		//判断target找到没————>如果不用target装返回值，以进行判断，那么即使左儿子找到了，
		if(target!=null) {
			return target;
		}
		//如果左儿子也没找到，再来找右儿子
		if(rightNode!=null) {
			target = rightNode.frontSearch(i);
		}
		return target;//此时右儿子无论找到与否，都可以直接return
	}
	
	public void delete(int i) {
		// 树中已经帮我们判别过了，删除的不是根节点
		// 删除节点只需要——>将其父节点指向它的箭头去掉
		// myidea：随便选一种遍历先找到他，再找到他的父节点，删掉该箭头————>实际上操作起来不简单，单向的树找父节点并不容易。
		// 思路：
		// 从根节点开始，取节点做parent，对parent的左右儿子进行匹配，删除
		// 如果不匹配，则分别递归parent为parent的左儿子和右儿子
		TreeNode parent = this;
		//判断左儿子
		if(leftNode!=null) {
			if(leftNode.value == i) {
				this.leftNode = null;
				return;
			}
		}
		//判断右儿子
		if(rightNode!=null) {
			if(rightNode.value == i) {
				this.rightNode = null;
				return;
			}
		}
		//可能左儿子右儿子都没匹配上，那就递归
		//先将左儿子做parent递归
		if(leftNode!=null) {
			parent = leftNode;
			parent.delete(i);
		}
		//再将右儿子做parent递归
		if(rightNode!=null) {
			parent = rightNode;
			parent.delete(i);
		}
	}
}
