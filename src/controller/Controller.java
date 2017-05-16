package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import arvore.ArvoreAvl;

public class Controller {
	
	static ArrayList<ArvoreAvl> arvores = new ArrayList<ArvoreAvl>(); //array list de arvores
	
	
	
	
	static public ArrayList<ArvoreAvl> abrirArquivo(JFileChooser fs){
		try{
			File fi = fs.getSelectedFile();
			BufferedReader arq = new BufferedReader( new FileReader(fi.getPath()));
			String linha = arq.readLine(); // lê a primeira linha
			String[] colunas = linha.split(";");
			for(String a : colunas){
				ArvoreAvl raiz = new ArvoreAvl(a);
				arvores.add(raiz);				
			}
			//inserir todas as linhas nas arvores
			
			arq.close();
			return arvores; //arvores lista
		}catch(IOException ef){
			JOptionPane.showMessageDialog(null, ef.getMessage());
			return null;
		}
	}
}
