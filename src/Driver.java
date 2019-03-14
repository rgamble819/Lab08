
public class Driver
{

    public static void main(String[] args)
    {
        BoardGame bg = new BoardGame();
        
        bg.addPlayer("Ryan", GamePiece.RED_RACECAR, Location.HALL);
        bg.addPlayer("Jon", GamePiece.BLUE_BOOT, Location.BILLIARD_ROOM);
        
        bg.movePlayer("Ryan", Location.KITCHEN);
        
        System.out.println(bg.getPlayerWithGamePiece(GamePiece.RED_RACECAR));
        System.out.println(bg.getGamePiecesAtLocation(Location.KITCHEN));
    }

}
