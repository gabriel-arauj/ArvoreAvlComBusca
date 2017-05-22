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
import javax.swing.JFileChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
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
		setBounds(100, 100, 694, 536);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(253, 31, 312, 24);
		
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
					
					nomeDosItens = controller.Controller.criaArvores(fs);
					for(String a : nomeDosItens){
						comboBox.addItem(a);
						System.out.println(a);
					}
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
		lblBuscarPor.setBounds(111, 31, 109, 24);
		contentPane.add(lblBuscarPor);
		
		JLabel lblPalavraChave = new JLabel("Palavra Chave:");
		lblPalavraChave.setBounds(111, 96, 109, 24);
		contentPane.add(lblPalavraChave);
		
		textField = new JTextField();
		textField.setBounds(253, 97, 218, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setBackground(Color.ORANGE);
		btnBuscar.setBounds(483, 96, 82, 25);
		contentPane.add(btnBuscar);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(111, 188, 454, 182);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int comboBoxIndex = comboBox.getSelectedIndex();
				String text = textField.getText();
				
				if(text != null && text != "" && comboBoxIndex != -1){
					ArrayList<Integer> ind = controller.Controller.getArvores().get(comboBoxIndex).search(text);
		
					if(!ind.isEmpty()){
						for(int i : ind){
							String dado = controller.Controller.getDados().get(i);
						textArea.setText(dado);
						}
						
					}else{
						textArea.setText("");
					}
				}
//				
//				System.out.println(text);
//				
//					
//					int ind =item.search(text);
//					
//					System.out.println(ind);
//					if(ind != -1){
//						String dado = controller.Controller.getDados().get(ind);
//						textArea.setText(dado);
//					}else{
//						textArea.setText("");
//					}
//				}
				
			}
		});
		
		contentPane.add(textArea);
	}
}
