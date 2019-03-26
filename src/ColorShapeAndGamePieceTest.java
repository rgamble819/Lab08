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
        Assert.assertEquals("Incorrect toString for Shape : Racer", "racecar", Shape.RACECAR.toString());
    }
    
    @Test
    public void getColorGPTest() 
    {
        Assert.assertEquals("Incorrect Color : GamePiece", Color.RED, GamePiece.RED_RACER.getColor());
    }
    
    @Test
    public void getShapeGPTest() 
    {
        Assert.assertEquals("Incorrect Shape : GamePiece", Shape.BOOT, GamePiece.BLUE_BOOT.getShape());
    }
    
    @Test
    public void toStringGPTest() 
    {
        System.out.println(GamePiece.RED_RACER.toString());
        Assert.assertEquals("Incorrect toString for GamePiece", "RED_RACER: a RED RACECAR with priority 0", GamePiece.RED_RACER.toString());
    }
    
    @Test
    public void movesFirstTest() 
    {
        Assert.assertEquals("Incorrect GamePiece priority order in GamePiece", GamePiece.RED_RACER, GamePiece.movesFirst(GamePiece.RED_RACER, GamePiece.RED_THIMBLE));
        Assert.assertEquals("Incorrect GamePiece priority order in GamePiece", GamePiece.RED_RACER, GamePiece.movesFirst(GamePiece.RED_THIMBLE, GamePiece.RED_RACER));
    }
    
    @Test
    public void testEnumerationTypes() 
    {
        Assert.assertEquals(Shape.valueOf("BOOT").name().toLowerCase(), Shape.BOOT.name().toLowerCase());
        Assert.assertEquals(Location.valueOf("STUDY").name().toLowerCase(), Location.STUDY.name().toLowerCase());
        Assert.assertEquals(GamePiece.valueOf("BLUE_BOOT").name().toLowerCase(), GamePiece.BLUE_BOOT.name().toLowerCase());
        Assert.assertEquals(Color.valueOf("BLUE").name().toLowerCase(), Color.BLUE.name().toLowerCase());
    }
}
