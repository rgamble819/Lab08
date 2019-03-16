
public enum Shape
{
    THIMBLE, BOOT, RACECAR;
    
    /**
     * @return String - The enum object's name (either thimble, boot, racecar) in lowercase. (Look at the documentation for java enums to figure out how to get the enum value's name).
     */
    public String toString() 
    {
        return name().toLowerCase();
    }
}
