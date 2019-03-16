import org.junit.Assert;
import org.junit.Test;
 
public class ColorShapeAndGamePieceTest
{
    
    @Test
    public void getRColorTest() 
    {
        Assert.assertEquals("RED: Incorrect Value for color: RED", 255, Color.RED.getR());
    }
    
    @Test
    public void getGColorTest() 
    {
        Assert.assertEquals("RED: Incorrect Value for color: GREEN", 0, Color.RED.getG());
    }
    
    @Test
    public void getBColorTest() 
    {
        Assert.assertEquals("RED: Incorrect Value for color: BLUE", 0, Color.RED.getB());
    }
    
    @Test
    public void toStringShapeTest() 
    {
        Assert.assertEquals("Incorrect toString for Shape : Racecar", "racecar", Shape.RACECAR.toString());
    }
    
    @Test
    public void getColorGPTest() 
    {
        Assert.assertEquals("Incorrect Color : GamePiece", Color.RED, GamePiece.RED_RACECAR.getColor());
    }
    
    @Test
    public void getShapeGPTest() 
    {
        Assert.assertEquals("Incorrect Shape : GamePiece", Shape.BOOT, GamePiece.BLUE_BOOT.getShape());
    }
    
    @Test
    public void toStringGPTest() 
    {
        Assert.assertEquals("Incorrect toString for GamePiece", "RED_RACECAR: a RED racecar with priority 0", GamePiece.RED_RACECAR.toString());
    }
    
    @Test
    public void movesFirstTest() 
    {
        Assert.assertEquals("Incorrect GamePiece priority order in GamePiece", GamePiece.RED_RACECAR, GamePiece.movesFirst(GamePiece.RED_RACECAR, GamePiece.RED_THIMBLE));
        Assert.assertEquals("Incorrect GamePiece priority order in GamePiece", GamePiece.RED_RACECAR, GamePiece.movesFirst(GamePiece.RED_THIMBLE, GamePiece.RED_RACECAR));
    }
}
