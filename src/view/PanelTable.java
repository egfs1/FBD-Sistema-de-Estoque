package view;

import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelTable extends JPanel {

	private JTable table_1;
	private JTextField textField;
	private JButton btnBuscar;

	public PanelTable(String[][]data, String[]columnNames, String titulo) {
		setBorder(new LineBorder(Color.DARK_GRAY));
		setBackground(Color.WHITE);
		setBounds(176,23, 718, 497);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 104, 698, 382);
		add(scrollPane);
		
		table_1 = new JTable(data, columnNames);
		table_1.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table_1.setColumnSelectionAllowed(false);
		table_1.setBackground(Color.LIGHT_GRAY);
		scrollPane.setViewportView(table_1);
		table_1.enable(false);
		
		JLabel lblTitulo = new JLabel(titulo);
		lblTitulo.setBounds(0, 0, 718, 42);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblTitulo);
		
		textField = new JTextField();
		textField.setBounds(90, 66, 419, 27);
		add(textField);
		textField.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBuscar.setBounds(529, 68, 89, 23);
		add(btnBuscar);
		
		setVisible(false);
	}

	public JTable getTable_1() {
		return table_1;
	}

	public void setTable_1(JTable table_1) {
		this.table_1 = table_1;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}
	
	
	
	
}
