import greenfoot.*;
import java.util.List;
import java.util.ArrayList;


public class Bishop extends Piece {
    
    Bishop(int cd) {
        super(cd);  
        if (cd == 1) setImage("bishop-black-50.png");
        else setImage("bishop-white-50.png");
    }
 
    public List<Position> getLegalPositions(){
        List<Position> list = new ArrayList<Position>();
       int n = 1;
        while(!inspect(getX() + n, getY() - n) && n < 10) {
            list.add(new Position(getX() + n, getY() - n));
            n++;
        }
        if (inspect(getX() + n, getY() - n) && grab(getX()+ n, getY() - n).cd() == -cd()) {
            list.add(new Position(getX()+ n, getY() - n));
        }
        
    
        n = 1;
        while (!inspect(getX() + n, getY() + n) && n < 10) {
            list.add(new Position(getX() + n, getY() + n));
            n++;
        }
        if (inspect(getX() + n, getY() + n) && grab(getX() + n, getY() + n).cd() == -cd()) {
            list.add(new Position(getX() + n, getY() + n));
        }
        
       
        n = 1;
        while ( !inspect(getX() - n, getY() + n) && n < 10) {
            list.add(new Position(getX() - n, getY() + n));
            n++;
        }
        if (inspect(getX() - n, getY() + n) && grab(getX() - n, getY() + n).cd() == -cd()) {
            list.add(new Position(getX() - n, getY() + n));
        }
        
        
        n = 1;
        while ( !inspect(getX() - n, getY() - n) && n < 10) {
            list.add(new Position(getX() - n, getY() - n));
            n++;
        }
        if (inspect(getX() - n, getY() - n) && grab(getX() - n, getY() - n).cd() == -cd()) {
            list.add(new Position(getX() - n, getY() - n));
        }
        
        System.out.println(list);
        // change signs 3 more times
        return list;
    } 
    
   
}
