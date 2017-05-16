package view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import arvore.ArvoreAvl;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class UserInterface extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface frame = new UserInterface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JComboBox<ArvoreAvl> comboBox = new JComboBox<ArvoreAvl>();
		comboBox.setBounds(143, 31, 252, 24);
		
		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser fs = new JFileChooser(new File("C:\\"));
				fs.setDialogTitle("Abrir arquivo");
				//fs.setFileFilter(new FileTypeFilter(".txt","Aquivo de texto"); //filtro
				
				//Abrir Arquivo
				int result = fs.showOpenDialog(null);
				if(result == JFileChooser.APPROVE_OPTION){
					ArrayList<ArvoreAvl> arvores;
					arvores = controller.Controller.abrirArquivo(fs);
					//try{
						//File fi = fs.getSelectedFile();
						//BufferedReader arq = new BufferedReader( new FileReader(fi.getPath()));
						//String linha = arq.readLine(); // lê a primeira linha
						//String[] colunas = linha.split(";");
						
						for(ArvoreAvl a : arvores){
							comboBox.addItem(a);
						}
						//arq.close();
					//}catch(IOException ef){
						//JOptionPane.showMessageDialog(null, ef.getMessage());
					//}
				}
			}
		});
		menuBar.add(mntmAbrir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		contentPane.add(comboBox);
		
		JLabel lblBuscarPor = new JLabel("Buscar Por:");
		lblBuscarPor.setBounds(35, 31, 109, 24);
		contentPane.add(lblBuscarPor);
		
		JLabel lblPalavraChave = new JLabel("Palavra Chave:");
		lblPalavraChave.setBounds(35, 96, 109, 24);
		contentPane.add(lblPalavraChave);
		
		textField = new JTextField();
		textField.setBounds(143, 97, 158, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setBackground(Color.ORANGE);
		btnBuscar.setBounds(313, 96, 82, 25);
		contentPane.add(btnBuscar);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(35, 132, 360, 106);
		btnBuscar.addActionListener(new ActionListener() {//Ação do butão
			public void actionPerformed(ActionEvent arg0) {
				//String item = (String)comboBox.getSelectedItem();
				//textArea.setText(item);
			}
		});
		
		contentPane.add(textArea);
	}
}
