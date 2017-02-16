package grid.controller;

import javax.swing.JOptionPane;

import grid.model.Meme;
import grid.view.GridFrame;

public class GridController
{
	Meme[][] memes;
	GridFrame baseFrame;

	public GridController()
	{
		memes = new Meme[5][5];
		for (int row = 0; row < 5; row++)
		{
			for (int col = 0; col < 5; col++)
			{
				Meme currentMeme = new Meme();
				memes[row][col] = currentMeme;
			}
		}
		baseFrame = new GridFrame(this);
	}

	public void start()
	{
		JOptionPane.showMessageDialog(baseFrame,"Welcome to MemeManager 2017 made by Geran Kunz","Welcome", 1);
	}

	public Meme[][] getGrid()
	{
		return memes;
	}

	public GridFrame getFrame()
	{
		return baseFrame;
	}

	public void setGridValue(String strRow, String strCol, String strInput)
	{
		int row = testIsInt(strRow) - 1;
		int col = testIsInt(strCol) - 1;
		int input = testIsInt(strInput);
		if (row < 0 || row > 4 || col < 0 || col > 4 || input < 0)
		{
			JOptionPane.showMessageDialog(baseFrame, "Error invalid input","Error", 0);
		} else
		{
			memes[row][col].setDankLevel(input);
		}
	}

	private int testIsInt(String input)
	{
		int parsed = -1;
		try
		{
			parsed = Integer.parseInt(input);
		} catch (NumberFormatException e)
		{
			JOptionPane.showMessageDialog(baseFrame, "Please enter only integers","Error", 0);
		}
		return parsed;
	}
}
