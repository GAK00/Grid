package grid.veiw;


import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

import grid.controller.Controller;

public class GridPanel extends JPanel
{
	private SpringLayout baseLayout;
	private JTable gridTable;
	private JScrollPane gridPane;
	private Controller controller;
	private JTextField colField;
	private JTextField rowField;
	private JTextField entryFeild;
	private JLabel colLabel;
	private JLabel rowLabel;
	private JLabel entryLabel;
	
	public GridPanel()
	{
	}

	
	private void setupTable()
	{
		Integer[][] grid = {};
		DefaultTableModel data = new DefaultTableModel(grid,new String[]{"one","two","three","four","five"});
		gridTable = new JTable();
		gridTable.setModel(data);
		gridPane = new JScrollPane();
		gridPane.setViewportView(gridTable);
	}
private void setupPanel()
{
	this.setLayout(baseLayout);
	this.setMinimumSize(new Dimension(700,700));
	this.setBackground(Color.CYAN);
	this.add(gridPane);
}
}
