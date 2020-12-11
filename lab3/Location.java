package lab3;


public class Location
{
    public int xCoord;
    public int yCoord;


    public Location(int x, int y)
    {
        xCoord = x;
        yCoord = y;
    }

    public Location()
    {
        this(0, 0);
    }
    
    public boolean equals(Object obj) 
    { 

        if (obj instanceof Location)
        {
            Location other = (Location) obj; 
            
            if (xCoord == other.xCoord && 
                yCoord == other.yCoord) 
            { 
                    return true; 
            } 
        } 
        
        return false; 
    }
    
    public int hashCode() 
    { 
        int result = 20;

        result = 16 * result + (xCoord * 13);
        result = 22 * result + (yCoord * 11);
        
        return result; 
    }
}
