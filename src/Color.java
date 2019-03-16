
public enum Color
{
    RED(255, 0, 0), GREEN(0, 255, 0), BLUE(0, 0, 255), YELLOW(255, 255, 0), CYAN(0, 255, 255), MAGENTA(255, 0, 255);
    
    private int r;
    private int g;
    private int b;
    
    /**
     * 
     * @param r
     * @param g
     * @param b
     */
    private Color(final int r, final int g, final int b) 
    {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    /**
     * 
     * @return int - The color's red component.
     */
    public int getR()
    {
        return r;
    }

    /**
     * 
     * @return int - The color's green component.
     */
    public int getG()
    {
        return g;
    }

    /**
     * 
     * @return int - The color's blue component.
     */
    public int getB()
    {
        return b;
    }  
}


