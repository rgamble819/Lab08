
public class GamePieceAppearance
{
    private Color color;
    private Shape shape;
    
    /**
     * 
     * @param color
     * @param shape
     * 
     *  Stores the color and shape describing the appearance of a game piece
     */
    public GamePieceAppearance(Color color, Shape shape) 
    {
        this.color = color;
        this.shape = shape;
    }

    /**
     * 
     * @return Color - Gets the color of the game piece.
     */
    public Color getColor()
    {
        return color;
    }

    /**
     * 
     * @return Shape - Gets the shape of the game piece.
     */
    public Shape getShape()
    {
        return shape;
    }
}
