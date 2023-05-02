import greenfoot.*;
import java.util.List;

public abstract class Piece extends Actor {
    int cd;
    boolean isSelected;

    Piece() {
        super();
    }

    Piece(int cd) {
        super();
        this.cd = cd;
        isSelected = false;
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            select();
        }
    }  

    public void select() {
        if (((MyWorld)getWorld()).select(this, cd)) {
            isSelected = true;
        }
        adjustAppearance();
    }
    
    public void unselect() {
        isSelected = false;
        adjustAppearance();
    }

    private void adjustAppearance() {
        if (isSelected) getImage().setTransparency(50);
        else getImage().setTransparency(255); 
    }
    
    public int cd() {
        return cd;
    }

    public void move(Position p) {
        isSelected = false;
        setLocation(p.getX(),p.getY());

    }
    public Position getPosition(){
        Position p = new Position(getX(), getY());
        return p;
    }
    public String toString(){
        
        return getX() + ", " + getY() + ", " + getImage() ;
    }
    public Piece getObjectAt(int x, int y){
        Position p = new Position( x,  y);
        if (getWorld().getObjectsAt(p.getX(), p.getY(), Piece.class).size()!= 0){
            return getWorld().getObjectsAt(p.getX(), p.getY(), Piece.class).get(0);
        }
        else{
           return null; 
        }
    }
    public void capture(Piece p) {
        //removeObject(getObjectsAt(p.getX(), p.getY(), Piece.class).get(0));
        p.removeTouching(Piece.class);
    }
    public boolean inspect(int x, int y){
        return (getWorld().getObjectsAt(x, y, Piece.class).size() != 0 );
    }
    public Piece grab(int x, int y){
        return getWorld().getObjectsAt(x, y, Piece.class).get(0);
    }
    
    /* public void capture(int x, int y){
        Position p = new Position (x, y);
        if(getWorld().getObjectsAt(p.getX(), p.getY(), Piece.class).isTouching(Piece.class) == true){
            
        }
    }
    */
    public abstract List<Position> getLegalPositions();


}
