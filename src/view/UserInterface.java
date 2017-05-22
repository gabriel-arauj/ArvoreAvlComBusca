package view;
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
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.Controller;
import javax.swing.JScrollPane;


public class UserInterface extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

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

	
	
	
	public void limparTabela(DefaultTableModel modelo){
		int row = modelo.getRowCount();
		for(int i = 0; i < row; i++)
			modelo.removeRow(0);
	}
	public void preencheTabela(DefaultTableModel modelo){
		int tamL = controller.Controller.dados.size();
		for(int i = 0; i < tamL; i++){
			String [] colunas = controller.Controller.dados.get(i).split(";");
			
			modelo.addRow(colunas);
		}
	}
	
	
	/**
	 * Create the frame.
	 */
	public UserInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 536);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(253, 31, 625, 24);
		DefaultTableModel modelo = new DefaultTableModel();
		
		
		
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
					String[] nomeDosItens;
					comboBox.removeAllItems();
					limparTabela(modelo);
					nomeDosItens = controller.Controller.criaArvores(fs);
					modelo.setColumnIdentifiers(nomeDosItens);
					
					for(String a : nomeDosItens){
						comboBox.addItem(a);
						//System.out.println(a);
					}
					preencheTabela(modelo);
				}
			}
		});
		menuBar.add(mntmAbrir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(111, 155, 767, 276);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(modelo);
		scrollPane.setViewportView(table);
		contentPane.add(comboBox);
		
		JLabel lblBuscarPor = new JLabel("Buscar Por:");
		lblBuscarPor.setBounds(111, 31, 109, 24);
		contentPane.add(lblBuscarPor);
		
		JLabel lblPalavraChave = new JLabel("Palavra Chave:");
		lblPalavraChave.setBounds(111, 96, 109, 24);
		contentPane.add(lblPalavraChave);
		
		textField = new JTextField();
		textField.setBounds(253, 97, 421, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setBackground(Color.ORANGE);
		btnBuscar.setBounds(718, 96, 160, 25);
		contentPane.add(btnBuscar);
		
		// buscar
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int comboBoxIndex = comboBox.getSelectedIndex();
				String text = textField.getText();
				
				if(text != null && text != "" && comboBoxIndex != -1){
					ArrayList<Integer> ind = controller.Controller.getArvores().get(comboBoxIndex).search(text.toUpperCase());
					
					/***botar um butão carregar todos os dados***/
					
					if(ind != null){
						limparTabela(modelo);
						for(int i : ind){
							String dado = controller.Controller.getDados().get(i);
							modelo.addRow(dado.split(";"));
						}
						
					}else{
						JOptionPane.showMessageDialog(null, "Palavra chave não encontrada");
					}
				}			
				
			}
		});
	}
}
