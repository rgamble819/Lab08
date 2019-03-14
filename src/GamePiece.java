
public enum GamePiece
{
    RED_RACECAR(new GamePieceAppearance(Color.RED, Shape.RACECAR), 0), BLUE_RACECAR(new GamePieceAppearance(Color.BLUE, Shape.RACECAR), 2), MAGENTA_RACECAR(new GamePieceAppearance(Color.MAGENTA, Shape.RACECAR), 1), RED_THIMBLE(new GamePieceAppearance(Color.RED, Shape.THIMBLE), 10), BLUE_BOOT(new GamePieceAppearance(Color.BLUE, Shape.BOOT), 5), GREEN_BOOT(new GamePieceAppearance(Color.GREEN, Shape.BOOT), 8), YELLOW_BOOT(new GamePieceAppearance(Color.YELLOW, Shape.BOOT), 7);
    
    private GamePieceAppearance gpa;
    private int priority;
    
    private GamePiece(GamePieceAppearance gpa, int priority) 
    {
        this.gpa = gpa;
        this.priority = priority;
    }

    public GamePieceAppearance getGpa()
    {
        return gpa;
    }

    public int getPriority()
    {
        return priority;
    }
    
    public GamePiece movesFirst(GamePiece a, GamePiece b) 
    {
        if(a.getPriority() > b.getPriority()) 
        {
            return b;
        }
        return a;
    }
    
    public String toString() 
    {
        return String.format("%s: a %s %s with priority %d", 
                this.name(), this.gpa.getColor(), this.gpa.getShape(), this.priority);
    }
}
