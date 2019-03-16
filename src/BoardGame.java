import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class BoardGame
{
    protected LinkedHashMap<String, GamePiece> playerPieces;
    protected LinkedHashMap<String, Location> playerLocation;
    
    // Constructs and initializes board game object
    public BoardGame() 
    {
        playerPieces = new LinkedHashMap<String, GamePiece>();
        playerLocation = new LinkedHashMap<String, Location>();

    }
    
    /**
     * 
     * @param String playerName
     * @param GamePiece gamePiece
     * @param Loctation initialLocation
     * @return If a player is correlated with the game piece, return that player name. Else, return null.
     */
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
    
    /**
     * 
     * @param String playerName
     * @return The game piece associated with the player.
     */
    public GamePiece getPlayerGamePiece(String playerName) 
    {
        return playerPieces.get(playerName);
    }
    
    public String getPlayerWithGamePiece(GamePiece gamepiece) 
    {
       Set<String> players = playerPieces.keySet();
       
       for(String p : players) 
       {
           if(playerPieces.get(p).equals(gamepiece)) 
           {
               return p;
           }
       }
    return null;
    }
    
    /**
     * 
     * @param playerName
     * @param newLocation
     */
    public void movePlayer(String playerName, Location newLocation) 
    {
        playerLocation.put(playerName, newLocation);
    }
    
    /**
     * 
     * @param String[] playerNames
     * @param Location[] newLocations
     * @return String[] The players, sorted in the order in which the two players move (the first player to move is at index 0 of the returned array).
     */
    public String[] moveTwoPlayers(String[] playerNames, Location[] newLocations) 
    {
        String[] order = new String[playerNames.length];
    
        order[0] = this.getPlayerWithGamePiece(
                GamePiece.movesFirst(
                        playerPieces.get(playerNames[0]), playerPieces.get(playerNames[1])));
        
        if(order[0].equalsIgnoreCase(playerNames[0])) 
        {
            order[1] = playerNames[1];
        }
        else 
        {
            order[1] = playerNames[0];
        }
        
        int count = 0;
        for(String player : playerNames) 
        {
            this.movePlayer(player, newLocations[count]);
            count++;
        }
        return order;
    }
    
    /**
     * 
     * @param String playerName
     * @return The location of the player.
     */
    public Location getPlayersLocation(String playerName) 
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
    
    /**
     * 
     * @param Location loc
     * @return ArrayList<GamePiece> of the game pieces for which an associated player is at the given location.
     */
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
    
    /**
     * 
     * @return Set<String> The list of players in the board game.
     */
    public Set<String> getPlayers()
    {
        return playerPieces.keySet();
    }
    
    /**
     * 
     * @return Set<Location> The set of locations (i.e. no duplicate elements) at which at least one player is present. Hint: look at the javadocs for the HashSet.
     */
    public Set<Location> getPlayerLocations() 
    {
        return new HashSet<Location>(playerLocation.values());
    }
    
    /**
     * 
     * @return Set<GamePieces> The set of game pieces (i.e. no duplicate elements) that have been associated with a player. Hint: look at the javadocs for the HashSet.
     */
    public Set<GamePiece> getPlayerPieces()
    {
        return new HashSet<GamePiece>(playerPieces.values());
    }
}
