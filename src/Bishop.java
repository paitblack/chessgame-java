public class Bishop extends Piece {
    boolean initialLocation = true;
    public Bishop(int color, Square location) {
        super(color, location);
    }

    @Override
    public boolean canMove(String to) {
        Square targetLocation = location.getBoard().getSquareAt(to);

        int rowDistance = targetLocation.getRowDistance(location);
        int colDistance = targetLocation.getColDistance(location);

        return rowDistance == colDistance;
    }

    @Override
    public void move(String to) {
        Square targetLocation = location.getBoard().getSquareAt(to);

        targetLocation.setPiece(this);

//clear previous location
        location.clear();
//update current location
        location = targetLocation;
        location.getBoard().nextPlayer();

    }
    @Override
    public String toString() {
        return color == ChessBoard.WHITE ? "B" : "b";
    }
}