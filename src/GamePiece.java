
public enum GamePiece
{
    RED_RACER(new GamePieceAppearance(Color.RED, Shape.RACECAR), 0), BLUE_RACER(new GamePieceAppearance(Color.BLUE, Shape.RACECAR), 2), MAGENTA_RACER(new GamePieceAppearance(Color.MAGENTA, Shape.RACECAR), 1), RED_THIMBLE(new GamePieceAppearance(Color.RED, Shape.THIMBLE), 10), BLUE_BOOT(new GamePieceAppearance(Color.BLUE, Shape.BOOT), 5), GREEN_BOOT(new GamePieceAppearance(Color.GREEN, Shape.BOOT), 8), YELLOW_BOOT(new GamePieceAppearance(Color.YELLOW, Shape.BOOT), 7);
    
    private GamePieceAppearance gpa;
    private int priority;
    
    /**
     * 
     * @param gpa
     * @param priority
     */
    private GamePiece(GamePieceAppearance gpa, int priority) 
    {
        this.gpa = gpa;
        this.priority = priority;
    }
    
    /**
     * 
     * @param a
     * @param b
     * @return GamePiece - Given two game pieces, determines which one takes its turn first.
     */
    public static GamePiece movesFirst(GamePiece a, GamePiece b) 
    {
        if(a.priority> b.priority) 
        {
            return b;
        }
        return a;
    }
    
    /**
     * 
     * @return Color - Gets the color of the game piece.
     */
    public Color getColor()
    {
        return gpa.getColor();
    }

    /**
     * 
     * @return Shape - Gets the color of the game piece.
     */
    public Shape getShape()
    {
        return gpa.getShape();
    }
    
    /**
     * @return String - Gets information about the game piece.
     */
    public String toString() 
    {
        return String.format("%s: a %s %s with priority %d", 
                this.name(), this.gpa.getColor().name(), this.gpa.getShape().name(), this.priority);
    }
}
