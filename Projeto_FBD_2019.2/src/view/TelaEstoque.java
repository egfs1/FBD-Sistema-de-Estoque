package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.BaseDados;

import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class TelaEstoque extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;
	private JScrollPane scrollPane;

	public TelaEstoque() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 225, 215);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setText(BaseDados.dadosEstoque());
		
		textArea.setBounds(-91, 1, 300, 174);
		contentPane.add(textArea);
		
		scrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 0, 219, 186);
		contentPane.add(scrollPane);
		
		setVisible(false);
	}
}
