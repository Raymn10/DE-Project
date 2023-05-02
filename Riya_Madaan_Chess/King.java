import greenfoot.*;
import java.util.List;
import java.util.ArrayList;

public class King extends Piece
{
    King(int cd) {
        super(cd);  
        if (cd == 1) setImage("king-black-50.png");
        else setImage("king-white-50.png");
    }
   
    public List<Position> getLegalPositions(){
        List<Position> list = new ArrayList<Position>();
        
      //i do understand i could have done this easy with like 4 loops but my braincells stopped working and i realized only after that this was completely inneficient 
       
        if (!inspect(getX(), getY() +1)) {
            Position p = new Position(getX(), getY() +1);
           list.add(p);
        }
        if (inspect(getX(), getY() +1) && grab(getX(), getY() +1).cd() == -cd()) {
             Position p = new Position(getX(), getY() +1);
           list.add(p);
        }
        
        if (!inspect(getX(), getY() -1)) {
            Position p1 = new Position(getX(), getY() -1);
           list.add(p1);
        }
        if (inspect(getX(), getY() -1) && grab(getX(), getY() -1).cd() == -cd()) {
            Position p1 = new Position(getX(), getY() -1);
           list.add(p1);
        }
        
        if (!inspect(getX() +1, getY())) {
            Position p2 = new Position(getX() +1, getY());
           list.add(p2);
        }
        if (inspect(getX() +1, getY()) && grab(getX() +1, getY()).cd() == -cd()) {
            Position p2 = new Position(getX() +1, getY());
           list.add(p2);
        }
        
         if (!inspect(getX() - 1, getY())) {
             Position p3 = new Position(getX() - 1, getY());
           list.add(p3);
        }
        if (inspect(getX() - 1, getY()) && grab(getX() - 1, getY()).cd() == -cd()) {
             Position p3 = new Position(getX() - 1, getY());
           list.add(p3);
        }
        
        if (!inspect(getX()+ 1, getY() +1)) {
            Position p4 = new Position(getX()+1, getY() +1);
           list.add(p4);
        }
        if (inspect(getX()+1, getY() +1) && grab(getX()+1, getY() +1).cd() == -cd()) {
             Position p4 = new Position(getX()+1, getY() +1);
           list.add(p4);
        }
        
        if (!inspect(getX()- 1, getY() +1)) {
            Position p5 = new Position(getX()-1, getY() +1);
           list.add(p5);
        }
        if (inspect(getX()-1, getY() +1) && grab(getX()-1, getY() +1).cd() == -cd()) {
            Position p5 = new Position(getX()-1, getY() +1);
           list.add(p5);
        }
        
        if (!inspect(getX()- 1, getY() -1)) {
            Position p6 = new Position(getX()-1, getY() -1);
           list.add(p6);
        }
        if (inspect(getX()-1, getY() -1) && grab(getX()-1, getY() -1).cd() == -cd()) {
           Position p6 = new Position(getX()-1, getY() -1);
           list.add(p6);
        }
        
        if (!inspect(getX()+ 1, getY() -1)) {
            Position p7 = new Position(getX()+1, getY() -1);
           list.add(p7);
        }
        if (inspect(getX()+1, getY() -1) && grab(getX()+1, getY() -1).cd() == -cd()) {
            Position p7 = new Position(getX()+1, getY() -1);
           list.add(p7);
        }
        
          /* Position p = new Position(getX(), getY() +1);
           list.add(p);
           Position p1 = new Position(getX(), getY() -1);
           list.add(p1);
           Position p2 = new Position(getX() +1, getY());
           list.add(p2);
           Position p3 = new Position(getX() - 1, getY());
           list.add(p3);
       */
        System.out.println(list);
        return list;
    } 
}
