package 平衡二叉树;

public class BinarySortTree {
	Node root;
	
	//添加节点（or构建二叉排序树）
	public void add(Node node) {
		//如果是空树
		if(root==null) {
			root = node;
		}
		else {
			root.add(node);
		}
	}
	
	//查找
	public Node search(int value) {
		if(root==null) {
			return null;
		}
		return root.search(value);
	}
	
	//删除节点
	/**
	 * 删除节点
	 * 思路：
	 * 要分三种情况①删的是叶子②删除节点只有一个子节点③删除节点有两个子节点
	 * @param value
	 */
	public void delete(int value) {
		if(root==null) {//不要忘了判树空！
			System.out.println("树空");
			return;
		}else {
			//先找到节点
			Node target = root.search(value);
			if(target==null) {
				//没找到这个节点
				System.out.println("没找到该节点");
				return;
			}
			//找到该节点后,再找到他的父节点,用于进行删除操作
			Node parent = searchParent(value);
			//拿到parent 就要开始分情况讨论了！！！！
			//1.要删除的是叶子节点
			//core：叶子节点，直接删除！(涉及到：判断他是parent的左子还是右子，才能直接剪断该枝)
			if(target.left==null&&target.right==null) {
				if(parent.left==target) {
					parent.left = null;
				}
				if(parent.right==target) {
					parent.right = null;
				}
			}
			
			//3.要删除的是有两个子节点的节点
			//core：找待删除节点的前驱或后继节点，用值替换掉该节点的值（但节点本身的指向不变），并且删掉用于取代它的节点的原节点
			//这里选择用待删除节点的后继节点来取代它(涉及到：待删除节点右子树中的最小值节点可能还有右儿子，要用右儿子取代删除的最小值节点的位置)
			else if(target.left!=null&&target.right!=null) {
				//3.1删除带删除节点右子树中最小值的节点，并且获取到他的节点值
				int min = deleteMin(target.right);//把target的右子树扔进去，删其最小节点并取值
				//3.2替换target的值为min即可
				target.value=min;
			}
			//2.要删除的是有一个子节点的非叶节点(判断条件写起来麻烦，所以把要删除有两个儿子的节点的分类放在上面，这里更好写判断条件)
			//core:直接把target的儿子接在他自己原来的位置即可(涉及到：①target是parent的左子还是右子②target的单儿子是其左子还是右子)
			else if(target.left!=null||target.right!=null) {
				//2.1先要判断target有的是左子还是右子
				if(target.left!=null) {//如果target的单儿子是左子
					//2.1.1还是不免要判断target是parent的左子还是右子
					if(parent.left==target) {//且target是其parent的左子
						parent.left = target.left;
					}
					if(parent.right==target) {
						parent.right = target.left;
					}
				}
				//2.2判断target有的是左子还是右子
				if(target.right!=null) {//如果target的单儿子是右子
					//2.2.1还是不免要判断target是parent的左子还是右子
					if(parent.left==target) {//且target是其parent的左子
						parent.left = target.right;
					}
					if(parent.right==target) {
						parent.right = target.right;
					}
				}
			}
		}
	}
	
	/**
	 * 删除一棵树中最小的节点
	 * @param node：target的右子，作子树根节点，找min删掉
	 * @return
	 */
	private int deleteMin(Node node) {
		Node target = node;
		//开始找这棵二叉排序树子树的min节点
		while(target.left!=null) {
			target = target.left;
		}
		//判断这个最小值节点还有没有右子——>以便后续删除此节点不会出错——>但其实并不用，我们上面写的delete方法就包含了删除 无子 或者 单儿子 的节点的情况，所以调用delete即可
		delete(target.value);
		return target.value;
	}

	/**
	 * 找到value节点的父节点
	 * @param value
	 * @return
	 */
	public Node searchParent(int value) {
		if(root==null) {
			return null;
		}else {
			return root.searchParent(value);
		}
	}
	
	//中序遍历
	public void inorderTraversal() {
		root.NonRecursionInTraversal();
	}
	
}
