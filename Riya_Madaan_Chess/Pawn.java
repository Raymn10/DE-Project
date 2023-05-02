import greenfoot.*;  
import java.util.List;
import java.util.ArrayList;

public class Pawn extends Piece {



    Pawn(int cd) {
        super(cd);  
        if (cd == 1) setImage("pawn-black-50.png");
        else setImage("pawn-white-50.png");
    }

    public List<Position> getLegalPositions(){
        List<Position> list = new ArrayList<Position>();
        Position now = new Position(getX(), getY());
        if (super.cd() == 1) {
                if (inspect(getX(), getY() + 1) == true){
                  if(super.getObjectAt(now.getX()+ 1, now.getY()-1) != null && super.getObjectAt(now.getX()+ 1, now.getY()-1).cd() != cd()){
           list.add(new Position (now.getX() + 1, now.getY()-1));
        }
        if(super.getObjectAt(now.getX()- 1, now.getY()-1) != null && super.getObjectAt(now.getX()- 1, now.getY()-1).cd() != cd()){
            list.add(new Position (now.getX() - 1, now.getY()-1));
        }
            }
               else{
                   if(now.getY() == 1){
                    Position p = new Position(getX(), getY() +1);
                    Position p2 = new Position(getX(), getY() +2);
                    list.add(p);
                    list.add(p2);
                }
               if (now.getY() != 0 && now.getY() != 1){
                    Position p3 = new Position (getX(), getY() +1);
                    list.add(p3);
                
                } 
                 if(super.getObjectAt(now.getX()+ 1, now.getY()-1) != null && super.getObjectAt(now.getX()+ 1, now.getY()-1).cd() != cd()){
           list.add(new Position (now.getX() + 1, now.getY()-1));
        }
        if(super.getObjectAt(now.getX()- 1, now.getY()-1) != null && super.getObjectAt(now.getX()- 1, now.getY()-1).cd() != cd()){
            list.add(new Position (now.getX() - 1, now.getY()-1));
        }
               }
                //en passant
                if (now.getY() == 4 && inspect(getX() +1 , getY()) == true && grab(getX() +1 , getY()).cd() == -cd() ){
                       Position p5 = new Position (getX() +1 , getY()+1);
                       list.add(p5);
                   }
                if (now.getY() == 4 && inspect(getX() -1 , getY()) == true && grab(getX() -1 , getY()).cd() == -cd() ){
                       Position p6 = new Position (getX() -1 , getY()+1);
                       list.add(p6);
                   }
                if(super.getObjectAt(now.getX()- 1, now.getY()+1) != null && super.getObjectAt(now.getX()- 1, now.getY()+1).cd() != cd()){
            list.add(new Position (now.getX() - 1, now.getY()+1));
        }
        if(super.getObjectAt(now.getX()+ 1, now.getY()+1) != null && super.getObjectAt(now.getX()+ 1, now.getY()+1).cd() != cd()){
            list.add(new Position (now.getX() + 1, now.getY()+1));
        }

        }
        else{
               if (inspect(getX(), getY() - 1) == true){
                    if(super.getObjectAt(now.getX()+ 1, now.getY()-1) != null && super.getObjectAt(now.getX()+ 1, now.getY()-1).cd() != cd()){
           list.add(new Position (now.getX() + 1, now.getY()-1));
        }
        if(super.getObjectAt(now.getX()- 1, now.getY()-1) != null && super.getObjectAt(now.getX()- 1, now.getY()-1).cd() != cd()){
            list.add(new Position (now.getX() - 1, now.getY()-1));
        }
               }
            else{
                     if(now.getY() == 6) {
                    Position p = new Position(getX(), getY() - 2);
                    Position p2 = new Position(getX(), getY() - 1);
                    list.add(p);
                    list.add(p2);
                }
                if (now.getY() != 7 && now.getY() != 6){
                    Position p3 = new Position (getX(), getY() -1);
                    list.add(p3);
                } 
                 if(super.getObjectAt(now.getX()+ 1, now.getY()-1) != null && super.getObjectAt(now.getX()+ 1, now.getY()-1).cd() != cd()){
           list.add(new Position (now.getX() + 1, now.getY()-1));
        }
        if(super.getObjectAt(now.getX()- 1, now.getY()-1) != null && super.getObjectAt(now.getX()- 1, now.getY()-1).cd() != cd()){
            list.add(new Position (now.getX() - 1, now.getY()-1));
        }
            }
                
                //en passant 
                if (now.getY() == 3 && inspect(now.getX() +1 , now.getY()) == true && grab(now.getX() +1 , now.getY()).cd() == -cd() ){
                   Position p4 = new Position (now.getX() +1 , now.getY()-1);
                   list.add(p4);
               }
                if (now.getY() == 3 && inspect(now.getX() -1 , now.getY()) == true && grab(now.getX() -1 , now.getY()).cd() == -cd() ){
                   Position p7 = new Position (now.getX() -1 , now.getY()-1);
                   list.add(p7);
               }
            
              
            /* if (inspect(getX(), getY() + 1) == true){
                diagonalBS();
            }
            else{
                
            }
            */
            //figure this out 
        }
        
        /*if(pawn(1).isTouching​(Piece.class)){
            capture();
        }
        */
        System.out.println(list);
        return list;
    } 
/*public Position diagonalBS(){
    Position p = getPosition();
    List<Position> purple = new ArrayList<Position>();
    if (cd ==1){
        if(super.getObjectAt(now.getX()- 1, now.getY()+1) != null && super.getObjectAt(now.getX()- 1, now.getY()+1).cd() != cd()){
            purple.add(new Position (p.getX() - 1, p.getY()+1));
        }
        if(super.getObjectAt(now.getX()+ 1, now.getY()+1) != null && super.getObjectAt(now.getX()+ 1, now.getY()+1).cd() != cd()){
            purple.add(new Position (now.getX() + 1, now.getY()+1));
        }
        
    }
    else{
         
        if(super.getObjectAt(now.getX()+ 1, now.getY()-1) != null && super.getObjectAt(now.getX()+ 1, now.getY()-1).cd() != cd()){
           purple.add(new Position (p.getX() + 1, p.getY()-1));
        }
        if(super.getObjectAt(now.getX()- 1, now.getY()-1) != null && super.getObjectAt(now.getX()- 1, now.getY()-1).cd() != cd()){
            purple.add(new Position (p.getX() - 1, p.getY()-1));
        }
    }
    return purple;
    System.out.println(purple);
    return null;
}
*/

    
}
