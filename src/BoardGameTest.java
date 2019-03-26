import org.junit.Assert;
import org.junit.Test;

public class BoardGameTest
{

    @Test
    public void addPlayerTest() 
    {
        // Create new board game
        BoardGame bg = new BoardGame();
       
        //Test Case 1
        Assert.assertEquals("Incorrect player or player info in addPlayer", true, bg.addPlayer("Ryan", GamePiece.BLUE_BOOT, Location.BALLROOM));
        //Test case 2
        Assert.assertEquals("Incorrect player or player info in addPlayer", false, bg.addPlayer("Ryan", GamePiece.BLUE_BOOT, Location.BALLROOM));
    }
    
    @Test
    public void getPlayerGamePieceTest()
    {
        BoardGame bg = new BoardGame();
        
        bg.addPlayer("Ryan", GamePiece.BLUE_BOOT, Location.BALLROOM);
        
        Assert.assertEquals("Incorrect gamepiece returned", GamePiece.BLUE_BOOT, bg.getPlayerGamePiece("Ryan"));
    }
    
    @Test
    public void getPlayerWithGamePieceTest() 
    {
        BoardGame bg = new BoardGame();
        
        bg.addPlayer("Ryan", GamePiece.BLUE_BOOT, Location.BALLROOM);
        
        Assert.assertEquals("Incorrect player returned", "Ryan", bg.getPlayerWithGamePiece(GamePiece.BLUE_BOOT));    
        Assert.assertEquals("Incorrect player returned", null, bg.getPlayerWithGamePiece(GamePiece.YELLOW_BOOT));    

    }
    
    @Test
    public void movePlayerTest() 
    {
        BoardGame bg = new BoardGame();
        
        bg.addPlayer("Ryan", GamePiece.BLUE_BOOT, Location.BALLROOM);
        
        bg.movePlayer("Ryan", Location.BILLIARD_ROOM);
        
        Assert.assertEquals("Incorrect location", Location.BILLIARD_ROOM, bg.playerLocations.get("Ryan"));
    }
    
    @Test
    public void moveTwoPlayersTest() 
    {
        String[] players = {"Ryan", "Jonathan"};
        Location[] locs = {Location.DINING_ROOM, Location.STUDY};
        
        BoardGame bg = new BoardGame();
        
        bg.addPlayer("Ryan", GamePiece.BLUE_BOOT, Location.BALLROOM);
        bg.addPlayer("Jonathan", GamePiece.BLUE_RACER, Location.BILLIARD_ROOM);
        bg.addPlayer("Gill", GamePiece.RED_RACER, Location.BILLIARD_ROOM);
        
        String[] players2 = {"Gill", "Ryan"};
        
        bg.movePlayer("Ryan", Location.BILLIARD_ROOM);

        Assert.assertArrayEquals(new String[] {"Jonathan", "Ryan"}, bg.moveTwoPlayers(players, locs));
        Assert.assertArrayEquals(new String[] {"Gill", "Ryan"}, bg.moveTwoPlayers(players2, locs));

    }
    
    @Test
    public void getPlayerLocationTest() 
    {
        BoardGame bg = new BoardGame();
        
        bg.addPlayer("Ryan", GamePiece.BLUE_BOOT, Location.BALLROOM);
        
        bg.movePlayer("Ryan", Location.BILLIARD_ROOM);
        
        Assert.assertEquals("Incorrect location", bg.playerLocations.get("Ryan"), bg.getPlayersLocation("Ryan"));
    }
    
    @Test
    public void getPlayersAtLoctionTest() 
    {
        String[] players = {"Ryan", "Jonathan"};
        Location[] locs = {Location.STUDY, Location.STUDY};
        
        BoardGame bg = new BoardGame();
        
        bg.addPlayer("Ryan", GamePiece.BLUE_BOOT, Location.BALLROOM);
        bg.addPlayer("Jonathan", GamePiece.BLUE_RACER, Location.BILLIARD_ROOM);
        bg.addPlayer("Gill", GamePiece.MAGENTA_RACER, Location.CONSERVATORY);
        
        bg.moveTwoPlayers(players, locs);
        
        Assert.assertEquals("Incorrect players", "Ryan", bg.getPlayersAtLocation(Location.STUDY).get(0));
        Assert.assertEquals("Incorrect players", "Jonathan", bg.getPlayersAtLocation(Location.STUDY).get(1));
    }
    
    @Test
    public void getGamePiecesAtLocationTest() 
    {
        String[] players = {"Ryan", "Jonathan"};
        Location[] locs = {Location.STUDY, Location.STUDY};
        
        BoardGame bg = new BoardGame();
        
        bg.addPlayer("Ryan", GamePiece.BLUE_BOOT, Location.BALLROOM);
        bg.addPlayer("Jonathan", GamePiece.BLUE_RACER, Location.BILLIARD_ROOM);
        bg.addPlayer("Gill", GamePiece.MAGENTA_RACER, Location.CONSERVATORY);
        
        bg.moveTwoPlayers(players, locs);
        
        Assert.assertEquals("Incorrect pieces", GamePiece.BLUE_BOOT, bg.getGamePiecesAtLocation(Location.STUDY).get(0));
        Assert.assertEquals("Incorrect pieces", GamePiece.BLUE_RACER, bg.getGamePiecesAtLocation(Location.STUDY).get(1));
    }
    
    @Test
    public void getPlayersTest() 
    {
        BoardGame bg = new BoardGame();
        
        bg.addPlayer("Ryan", GamePiece.BLUE_BOOT, Location.BALLROOM);
        bg.addPlayer("Jonathan", GamePiece.BLUE_RACER, Location.BILLIARD_ROOM);
        bg.addPlayer("Gill", GamePiece.MAGENTA_RACER, Location.CONSERVATORY);
        
        Assert.assertEquals("Incorrect location", 3, bg.getPlayers().size());
        Assert.assertEquals("Incorrect location", "Ryan", bg.getPlayers().stream().findFirst().get());
    }
    
    @Test
    public void getPlayerLocationsTest() 
    {
        BoardGame bg = new BoardGame();
        
        bg.addPlayer("Ryan", GamePiece.BLUE_BOOT, Location.BALLROOM);
        bg.addPlayer("Jonathan", GamePiece.BLUE_RACER, Location.BILLIARD_ROOM);
        bg.addPlayer("Gill", GamePiece.MAGENTA_RACER, Location.CONSERVATORY);
        
        Assert.assertEquals("Incorrect location", 3, bg.getPlayerLocations().size());
        Assert.assertEquals("Incorrect location", true, bg.getPlayerLocations().contains(Location.CONSERVATORY));
    }
    
    @Test
    public void getPlayerPiecesTest() 
    {
        BoardGame bg = new BoardGame();
        
        bg.addPlayer("Ryan", GamePiece.BLUE_BOOT, Location.BALLROOM);
        bg.addPlayer("Jonathan", GamePiece.BLUE_RACER, Location.BILLIARD_ROOM);
        bg.addPlayer("Gill", GamePiece.MAGENTA_RACER, Location.CONSERVATORY);
        
        Assert.assertEquals("Incorrect location", 3, bg.getPlayerPieces().size());
        Assert.assertEquals("Incorrect location", true, bg.getPlayerPieces().contains(GamePiece.BLUE_RACER));
    
    }
}
