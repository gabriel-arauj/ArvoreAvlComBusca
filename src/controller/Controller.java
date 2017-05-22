package controller;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import arvoreGenerica.AVLTree;

public class Controller {
	
	static ArrayList<AVLTree<String>> arvores = new ArrayList<AVLTree<String>>(); //array list de arvores
	static ArrayList<String> dados = new ArrayList<String>();
	
	
	
	static public String[] criaArvores(JFileChooser fs){
		try{
			File fi = fs.getSelectedFile();
			
			Scanner scanner = new Scanner(new FileReader(fi.getPath())).useDelimiter("\\n");
			String linha = scanner.next();
			String[] colunas = linha.split(";");
			String[] nomeDosItens = colunas;
			//criar as arvores
			for(String a : colunas){
				AVLTree<String>raiz = new AVLTree<String>();
				arvores.add(raiz);				
			}
			//ler o arquivo com o arraylist
			int tamC = colunas.length;
			while (scanner.hasNext()) {
				dados.add(scanner.next());
			}
			scanner.close();
			//inserir os elementos na arvore
			int tamL = dados.size();
			for(int i = 0; i < tamL; i++){
				colunas = dados.get(i).split(";");
				for(int j = 0; j < tamC; j++){
					//cada arvore será inserido um dado da coluna e o indice do array
					arvores.get(j).insert(colunas[j], i);
				}
			}
			
			return nomeDosItens;
		}catch(IOException ef){
			JOptionPane.showMessageDialog(null, ef.getMessage());
			return null;
		}
	}



	public static ArrayList<AVLTree<String>> getArvores() {
		return arvores;
	}



	public static void setArvores(ArrayList<AVLTree<String>> arvores) {
		Controller.arvores = arvores;
	}



	public static ArrayList<String> getDados() {
		return dados;
	}



	public static void setDados(ArrayList<String> dados) {
		Controller.dados = dados;
	}
	
	
}
