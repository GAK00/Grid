package grid.view;

import javax.swing.JFrame;

import grid.controller.GridController;

public class GridFrame extends JFrame
{
	GridController baseController;
	GridPanel basePanel;
	public GridFrame(GridController baseController)
	{
		this.baseController = baseController;
		basePanel = new GridPanel(baseController);
		setupFrame();
	}
	private void setupFrame()
	{
		this.setTitle("MemeManagar");
		this.setSize(800,500);
		this.setContentPane(basePanel);
		this.setVisible(true);
	}
	public GridController getBaseController()
	{
		return baseController;
	}

}
