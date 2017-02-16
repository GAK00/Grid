package grid.model;

public class Meme
{
	private int dankLevel;
	public Meme()
	{
		dankLevel = (int)(Math.random()*51);
	}
	public int getDankLevel()
	{
		return dankLevel;
	}
	public void setDankLevel(int dankLevel)
	{
		this.dankLevel = dankLevel;
	}
	public String toString()
	{
		return "Dankness: " + dankLevel;
	}
	
}
