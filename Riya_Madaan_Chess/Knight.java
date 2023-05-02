import greenfoot.*;
import java.util.List;
import java.util.ArrayList;

public class Knight extends Piece
{
    Knight(int cd) {
        super(cd);  
        if (cd == 1) setImage("knight-black-50.png");
        else setImage("knight-white-50.png");
    }
  
    public List<Position> getLegalPositions(){
        List<Position> list = new ArrayList<Position>();
       if (!inspect(getX() +2, getY() +1)) {
            Position p = new Position(getX() +2, getY() +1);
           list.add(p);
        }
        if (inspect(getX() +2, getY() +1) && grab(getX() +2, getY() +1).cd() == -cd()) {
            Position p = new Position(getX() +2, getY() +1);
           list.add(p);
        }
        
        if (!inspect(getX() +2, getY() -1)) {
            Position p1 = new Position(getX()+2, getY() -1);
           list.add(p1);
        }
        if (inspect(getX()+2, getY() -1) && grab(getX()+2, getY() -1).cd() == -cd()) {
            Position p1 = new Position(getX()+2, getY() -1);
           list.add(p1);
        }
        
        if (!inspect(getX() -2, getY()+1)) {
            Position p2 = new Position(getX() -2, getY()+1);
           list.add(p2);
        }
        if (inspect(getX() -2, getY()+1) && grab(getX() -2, getY()+1).cd() == -cd()) {
            Position p2 = new Position(getX() -2, getY()+1);
           list.add(p2);
        }
        
         if (!inspect(getX() - 2, getY()-1)) {
             Position p2 = new Position(getX() - 2, getY()-1);
           list.add(p2);
        }
        if (inspect(getX() - 2, getY()-1) && grab(getX() - 2, getY()-1).cd() == -cd()) {
            Position p2 = new Position(getX() - 2, getY()-1);
           list.add(p2);
        }
        
        if (!inspect(getX()+ 1, getY() +2)) {
            Position p4 = new Position(getX()+1, getY() +2);
           list.add(p4);
        }
        if (inspect(getX()+1, getY() +2) && grab(getX()+1, getY() +2).cd() == -cd()) {
             Position p4 = new Position(getX()+1, getY() +2);
           list.add(p4);
        }
        
        if (!inspect(getX()- 1, getY() +2)) {
            Position p5 = new Position(getX()-1, getY() +2);
           list.add(p5);
        }
        if (inspect(getX()-1, getY() +2) && grab(getX()-1, getY() +2).cd() == -cd()) {
            Position p5 = new Position(getX()-1, getY() +2);
           list.add(p5);
        }
        
        if (!inspect(getX()- 1, getY() -2)) {
            Position p6 = new Position(getX()-1, getY() -2);
           list.add(p6);
        }
        if (inspect(getX()-1, getY() -2) && grab(getX()-1, getY() -2).cd() == -cd()) {
           Position p6 = new Position(getX()-1, getY() -2);
           list.add(p6);
        }
        
        if (!inspect(getX()+ 1, getY() -2)) {
            Position p7 = new Position(getX()+1, getY() -2);
           list.add(p7);
        }
        if (inspect(getX()+1, getY() -2) && grab(getX()+1, getY() -2).cd() == -cd()) {
            Position p7 = new Position(getX()+1, getY() -2);
           list.add(p7);
        }
        System.out.println(list);
        return list;
    } 
}
