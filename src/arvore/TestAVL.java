package arvore;

public class TestAVL {

	//essa arvore não funciona
	
	public static void main(String[] args) {

		String[] lista = {"0","1","2","3","4","5","6","7","8","9"};
		
		
		AVLTree<String> tree = new AVLTree<String>("arvore 1");
		for (int i = 0; i <= 100; i++){
			tree.insert(Integer.toString(i), i);
			System.out.println(i);
		}
		tree.insert("10", 11);
		tree.insert("99", 20);
		tree.PrintTree();
		int j = tree.search("0");
		System.out.println(j);
		
	}
}
	


