import greenfoot.*;  
import java.util.List;
import java.util.ArrayList;


public class MyWorld extends World {

    private boolean isPieceSelected;
    private Piece selectedPiece ;
    private int turn; //1 is Black, -1 is White
    private Piece whiteRookA = new Rook(-1);
    private Piece whiteRookB = new Rook(-1);
    private Piece blackRookA = new Rook(1);
    private Piece blackRookB = new Rook(1);
    
    public MyWorld() {    
        
        super(8, 8, 50, false); 
        for (int x = 0; x<8; x++){
        addObject(new Pawn(1), x, 1);
        addObject(new Pawn(-1), x, 6);
    }
        addObject(new Knight(1), 1, 0);
        addObject(new Knight(1), 6, 0); 
        addObject(new Knight(-1), 1, 7);
        addObject(new Knight(-1), 6, 7); 
        addObject(new Rook(1), 0, 0);
        addObject(new Rook(1), 7, 0); 
        addObject(new Rook(-1), 0, 7);
        addObject(new Rook(-1), 7, 7);
        addObject(new Bishop(1), 2, 0);
        addObject(new Bishop(1), 5, 0); 
        addObject(new Bishop(-1), 2, 7);
        addObject(new Bishop(-1), 5, 7);
        addObject(new Queen(-1), 3, 7);
        addObject(new Queen(1), 3, 0);
        addObject(new King(-1), 4, 7);
        addObject(new King(1), 4, 0);
        isPieceSelected = false;
        turn = -1; //Black starts
    }

    public void act() {
        movePiece();
    }

    public boolean select(Piece p, int pColor) {
        System.out.println("selected method running with " + p + " selected");
        if (pColor == turn) {
            if (isPieceSelected) {
                unselectPiece(selectedPiece);
            }
            else {
            isPieceSelected = true;
            selectedPiece = p;
            showLegalMoves();
            
        }
        return true; 
        } else {
            return false;
        }
    }

    private void showLegalMoves() {
        System.out.println("legal moves are " + selectedPiece.getLegalPositions());
        List <Position> highlight = selectedPiece.getLegalPositions();
        for (int x = 0; x < highlight.size(); x++){
            HighlightPosition hp1 = new HighlightPosition();
            addObject(hp1, highlight.get(x).getX(), highlight.get(x).getY());
        }
        //ask the selected piece for a list of legal move positions
        // this line of code saves it List<position> legalSpots =getlegalPositions
        // then add a highlighPosition to each spot in the list
    }

    private void movePiece() {
        // get list of all of the highlights and if the place you clicked is 
        //one of those then put your piece there (or take that piece if appropriate)
        
        for (HighlightPosition p: getObjects(HighlightPosition.class)) {
            if (Greenfoot.mouseClicked(p)) {
                System.out.println("clicked something");
                selectedPiece.setLocation(p.getX(), p.getY());
                List<Piece> lol = getObjectsAt (selectedPiece.getX(), selectedPiece.getY(), Piece.class);
                if (lol.size()> 1){
                     int index = 0; 
                     for(int x =0; x<lol.size(); x++){
                         if(lol.get(x).equals (selectedPiece) != true){
                             index = x;
                         }
                     }
                     removeObject (lol.get(index));
                }
                changeTurn();
            }
        }
    }
    
    private void changeTurn() {
        turn = -turn;
        selectedPiece.getImage().setTransparency(255);
        clearHighlights();
    }
    
   
    private void unselectPiece(Piece p) {
        p.unselect();
        selectedPiece = null;
        isPieceSelected = false;
        clearHighlights();
    }

    private void clearHighlights() {
        List <HighlightPosition> spots = getObjects(HighlightPosition.class);
        for (int x = spots.size()-1; x>= 0; x--){
            removeObject(spots.get(x));
        }
        }
    }

