package grid.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

import grid.controller.GridController;

public class GridPanel extends JPanel
{
	private GridController baseController;
	private SpringLayout baseLayout;
	private JTable gridTable;
	private JScrollPane gridPane;
	private JTextField colField;
	private JTextField rowField;
	private JTextField entryField;
	private JLabel colLabel;
	private JLabel rowLabel;
	private JLabel entryLabel;
	private JLabel gridLabel;
	private JButton entryButton;

	public GridPanel(GridController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		gridTable = new JTable();
		gridPane = new JScrollPane();
		colField = new JTextField();
		rowField = new JTextField();
		entryField = new JTextField();
		colLabel = new JLabel("Col:");
		rowLabel = new JLabel("Row:");
		entryLabel = new JLabel("Input:");
		gridLabel = new JLabel("Dankness:");
		entryButton = new JButton("Enter");
		setupTable();
		setupPanel();
		setupLayout();
		setupListeners();
	}

	private void setupTable()
	{
		Integer[][] grid = {};
		DefaultTableModel data = new DefaultTableModel(grid, new String[] { "1", "2", "3", "4", "5" });
		for (int index = 0; index < 5; index++)
		{
			String[] dankness = new String[6];
			dankness[0] = Integer.toString(index + 1);
			for (int innerIndex = 0; innerIndex < 5; innerIndex++)
			{
				dankness[innerIndex + 1] = baseController.getGrid()[index][innerIndex].toString();
			}
			data.addRow(dankness);
		}
		gridTable = new JTable();
		gridTable.setModel(data);
		gridPane = new JScrollPane();
		gridPane.setViewportView(gridTable);
		this.add(gridPane);
	}

	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setMinimumSize(new Dimension(700, 700));
		this.setBackground(Color.CYAN);
		this.add(colField);
		this.add(rowField);
		this.add(entryField);
		this.add(colLabel);
		this.add(rowLabel);
		this.add(entryLabel);
		this.add(entryButton);
		this.add(gridLabel);
	}

	public GridController getBaseController()
	{
		return baseController;
	}

	private void setupListeners()
	{
		this.entryButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				baseController.setGridValue(rowField.getText(), colField.getText(), entryField.getText());
				remove(gridPane);
				setupTable();
				setupLayout();
				repaint();
				validate();
			}
		});
	}

	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, colField, 30, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, rowField, 0, SpringLayout.WEST, colField);
		baseLayout.putConstraint(SpringLayout.WEST, entryField, 0, SpringLayout.WEST, colField);
		baseLayout.putConstraint(SpringLayout.SOUTH, colLabel, -150, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, colLabel, -6, SpringLayout.WEST, colField);
		baseLayout.putConstraint(SpringLayout.NORTH, colField, -3, SpringLayout.NORTH, colLabel);
		baseLayout.putConstraint(SpringLayout.WEST, rowLabel, 0, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, rowField, -3, SpringLayout.NORTH, rowLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, rowLabel, 18, SpringLayout.SOUTH, colLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, entryField, -3, SpringLayout.NORTH, entryLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, entryLabel, 203, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, entryLabel, 0, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, entryButton, 0, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, entryField, -6, SpringLayout.WEST, gridPane);
		baseLayout.putConstraint(SpringLayout.EAST, rowField, -6, SpringLayout.WEST, gridPane);
		baseLayout.putConstraint(SpringLayout.EAST, colField, -6, SpringLayout.WEST, gridPane);
		baseLayout.putConstraint(SpringLayout.SOUTH, entryButton, 0, SpringLayout.SOUTH, gridPane);
		baseLayout.putConstraint(SpringLayout.NORTH, gridPane, 50, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, gridPane, 100, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, gridPane, -50, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, gridPane, -50, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, gridLabel, 0, SpringLayout.WEST, gridPane);
		baseLayout.putConstraint(SpringLayout.SOUTH, gridLabel, -6, SpringLayout.NORTH, gridPane);

	}

}
