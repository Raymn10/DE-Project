import greenfoot.*;  
import java.util.List;
import java.util.ArrayList;

public class Queen extends Piece {
    Queen(int cd) {
        super(cd);  
        if (cd == 1) setImage("queen-black-50.png");
        else setImage("queen-white-50.png");
    }
     
    public List<Position> getLegalPositions(){
        List<Position> list = new ArrayList<Position>();
          int n = 1;
          int x = getX();
       int y = getY();
       int row1 = x+1;
       int row2 = x-1;
       int col1 = y+1;
       int col2 = y-1;
       boolean collidedXvert= false;
       boolean collidedYvert= false;
       boolean collidedXhoriz= false;
       boolean collidedYhoriz= false;
       
       //bishop
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
        
    //rook
        while (!collidedXvert && row1<8){
            if(getObjectAt(row1, y) != null){
              if (getObjectAt(row1, y).cd != cd){
                list.add(new Position(row1, getY()));
                }  
                collidedXvert = true;
            }
            else{
                list.add(new Position(row1, getY()));
                row1++;
            }
        }
        while (!collidedXhoriz && row2>=0 && col2 <10){
            if(getObjectAt(row2, y) != null){
              if (getObjectAt(row2, y).cd != cd){
                list.add(new Position(row2, getY()));
                }  
                collidedXhoriz = true;
            }
            else{
                list.add(new Position(row2, getY()));
                row2--;
            }
        }
        while (!collidedYvert && col1<8){
            if(getObjectAt(x, col1) != null){
              if (getObjectAt(x, col1).cd != cd){
                list.add(new Position(x, col1));
                }  
                collidedYvert = true;
            }
            else{
                list.add(new Position(getX(), col1));
                col1++;
            }
        }
        while (!collidedYhoriz && col2>=0 && col2 <10){
            if(getObjectAt(x, col2) != null){
              if (getObjectAt(x, col2).cd != cd){
                list.add(new Position(x, col2));
                }  
               collidedYhoriz = true;
            }
            else{
                list.add(new Position(getX(), col2));
                col2--;
            }
        }
        System.out.println(list);
        return list;
    } 
}
