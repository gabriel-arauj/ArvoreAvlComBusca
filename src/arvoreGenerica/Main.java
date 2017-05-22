package arvoreGenerica;

import java.util.ArrayList;

public class Main {

	  public static void main(String[] args) {
			AVLTree<String> tree = new AVLTree<String>();
			for (int i = 1; i <= 10; i++){
				tree.insert(new String(Integer.toString(i)), i);
			}
			
//			tree.insert(new String(Integer.toString(1)));
//			tree.insert(new String(Integer.toString(1)));
//			tree.insert(new String(Integer.toString(1)));
//			tree.insert(new String(Integer.toString(1)));
//			tree.insert(new String(Integer.toString(1)));
//			tree.insert(new String(Integer.toString(9)));
//			tree.insert(new String(Integer.toString(9)));
//			tree.insert(new String(Integer.toString(6)));
			
			//String palavra = "gaBriel";
			//palavra = palavra.toUpperCase();
			ArrayList<Integer> result = new ArrayList<Integer>();
			result = tree.search("6");
			for(Integer i : result){
				System.out.println(i);
			}
			tree.PrintTree();
			//System.out.println(palavra);
			//String num = "1";
			//System.out.println(num.compareTo("10"));
			
		}
	  
	}