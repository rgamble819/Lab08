import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class BoardGame
{
    protected LinkedHashMap<String, GamePiece> playerPieces;
    protected LinkedHashMap<String, Location> playerLocation;
    
    public BoardGame() 
    {
        playerPieces = new LinkedHashMap<String, GamePiece>();
        playerLocation = new LinkedHashMap<String, Location>();

    }
    
    public boolean addPlayer(String playerName, GamePiece gamePiece, Location initialLocation) 
    {
        if(!playerPieces.containsValue(gamePiece)) {
            playerPieces.put(playerName, gamePiece);
            playerLocation.put(playerName, initialLocation);
            return true;
        }
        else 
        {
            return false;
        }
    }
    
    public GamePiece getPlayerGamePiece(String playerName) 
    {
        return playerPieces.get(playerName);
    }
    
    public String getPlayerWithGamePiece(GamePiece gamepiece) 
    {
       return playerPieces.entrySet().stream().filter(piece 
               -> piece.getValue().equals(gamepiece)).findFirst().get().getKey();
    }
    
    public void movePlayer(String playerName, Location newLocation) 
    {
        playerLocation.put(playerName, newLocation);
    }
    
    public void moveTwoPlayers(String[] playerNames, Location[] newLocations) 
    {
        int count = 0;
        for(String player : playerNames) 
        {
            playerLocation.put(player, newLocations[count]);
            count++;
        }
    }
    
    public Location getPlayerLocation(String playerName) 
    {
        return playerLocation.get(playerName);
    }
    
    public ArrayList<String> getPlayersAtLocation(Location loc) 
    {
        Map<String, Location> map = playerLocation;
        ArrayList<String> players = new ArrayList<String>();
        
        for(Entry<String, Location> m : map.entrySet()) 
        {
            if(m.getValue().equals(loc)) 
            {
                players.add(m.getKey());
            }
        }
        return players;
    }
    
    public ArrayList<GamePiece> getGamePiecesAtLocation(Location loc)
    {
        Map<String, Location> mapPieces = playerLocation;
        ArrayList<GamePiece> players = new ArrayList<GamePiece>();
        
        for(Entry<String, Location> m : mapPieces.entrySet()) 
        {
            if(m.getValue().equals(loc)) 
            {
                players.add(playerPieces.get(m.getKey()));
            }
        }
        return players;
    }
    
    public Set<String> getPlayers()
    {
        return playerPieces.keySet();
    }
    
    public Set<Location> getPlayerLocations() 
    {
        return new HashSet<Location>(playerLocation.values());
    }
    
    public Set<GamePiece> getPlayerPieces()
    {
        return new HashSet<GamePiece>(playerPieces.values());
    }
}
