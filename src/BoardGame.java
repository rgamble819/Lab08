import java.util.LinkedHashMap;

public class BoardGame
{
    protected LinkedHashMap<String, GamePiece> playerPieces;
    protected LinkedHashMap<String, Location> playerLocation;
    
    public BoardGame() 
    {
        
    }
    
    public boolean addPlayer(String playerName, GamePiece gamePiece, Location initialLocation) 
    {
        if(!playerPieces.containsKey(playerName) && !playerPieces.get(playerName).equals(gamePiece)) {
            playerPieces.put(playerName, gamePiece);
            playerLocation.put(playerName, initialLocation);
            return true;
        }
        else 
        {
            return false;
        }
    }
    
    public String getPlayerWithGamePiece(GamePiece gamepiece) 
    {
        return null;
    }
}
