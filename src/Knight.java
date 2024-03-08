public class Knight extends Piece {
    boolean initialLocation = true;
    public Knight(int color, Square location) {
        super(color, location);
    }

    @Override
    public boolean canMove(String to) {
        Square targetLocation = location.getBoard().getSquareAt(to);

        int rowDistance = targetLocation.getRowDistance(location);
        int colDistance = targetLocation.getCol() - location.getCol();

        return (Math.abs(rowDistance) == 2 && Math.abs(colDistance) == 1) ||
                (Math.abs(rowDistance) == 1 && Math.abs(colDistance) == 2);
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
        return color == ChessBoard.WHITE ? "N" : "n";
    }
}
