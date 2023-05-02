
public class Position {
   
    int xPos;
    int yPos;
    
    public Position(int x, int y) {
        xPos = x;
        yPos = y;
    }
    
    public Position(greenfoot.Actor p) {
        xPos = p.getX();
        yPos = p.getY();
    }   
    
    public boolean correspondsTo(int x, int y) {
        return xPos == x && yPos == y;
    }
    
    public boolean correspondsTo(Position p) {
        return xPos == p.getX() && yPos == p.getY();
    }
    
    public int getX() {
        return xPos;
    }

    public int getY() {
        return yPos;
    }
    
    public String toString(){
        return "Position:" + getX()+", "+getY();
    }
    
    
}
