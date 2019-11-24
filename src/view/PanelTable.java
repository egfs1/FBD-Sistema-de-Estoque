package view;

import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;

public class PanelTable extends JPanel {

	private JTable table_1;

	public PanelTable(String[][]data, String[]columnNames, String titulo) {
		setBorder(new LineBorder(Color.DARK_GRAY));
		setBackground(Color.WHITE);
		setSize(518, 448);
		setBounds(176,23, 518, 448);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 498, 364);
		add(scrollPane);
		
		table_1 = new JTable(data, columnNames);
		table_1.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table_1.setColumnSelectionAllowed(false);
		table_1.setBackground(Color.LIGHT_GRAY);
		scrollPane.setViewportView(table_1);
		table_1.enable(false);
		
		JLabel lblTitulo = new JLabel(titulo);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTitulo.setBounds(0, 0, 520, 42);
		add(lblTitulo);
		
		setVisible(false);
	}

	public JTable getTable_1() {
		return table_1;
	}

	public void setTable_1(JTable table_1) {
		this.table_1 = table_1;
	}
	
	
}
