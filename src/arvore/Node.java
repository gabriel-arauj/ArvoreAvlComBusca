package arvore;

/**
 * @author antonio081014
 * @time Jul 5, 2013, 9:31:32 PM
 */
public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {

	private String data; //index da arvore
	private int indice; // indice do dado
	private Node<T> left;
	private Node<T> right;
	public int level;
	private int depth;

	public Node(String data, int indice) {
		this(data, null, null, indice);
	}

	public Node(String data, Node<T> left, Node<T> right, int indice) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
		this.indice = indice;
		if (left == null && right == null)
			setDepth(1);
		else if (left == null)
			setDepth(right.getDepth() + 1);
		else if (right == null)
			setDepth(left.getDepth() + 1);
		else
			setDepth(Math.max(left.getDepth(), right.getDepth()) + 1);
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Node<T> getLeft() {
		return left;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	public Node<T> getRight() {
		return right;
	}

	public void setRight(Node<T> right) {
		this.right = right;
	}

	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}

	/**
	 * @return the depth
	 */
	public int getDepth() {
		return depth;
	}

	/**
	 * @param depth
	 *            the depth to set
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}

	@Override
	public int compareTo(Node<T> o) {
		return this.data.compareTo(o.data);
	}

	@Override
	public String toString() {
		return "Level " + level + ": " + data;
	}

}