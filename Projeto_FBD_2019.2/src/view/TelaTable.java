package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import model.BaseDados;

import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;

public class TelaTable extends JFrame {

	private JPanel contentPane;
	private JTable table_1;

	public TelaTable(String[][]data, String[]columnNames, String titulo) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 225, 215);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 199, 164);
		contentPane.add(scrollPane);
		
		table_1 = new JTable(data, columnNames);
		scrollPane.setViewportView(table_1);
		table_1.enable(false);
		
		JLabel lblTitulo = new JLabel(titulo);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTitulo.setBounds(78, 0, 71, 19);
		contentPane.add(lblTitulo);
		
		
		setLocationRelativeTo(null);
		setResizable(false);
		
		setVisible(false);
	}
}
