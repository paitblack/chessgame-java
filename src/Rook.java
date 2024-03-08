public class Rook extends Piece {
    boolean initialLocation = true;
    public Rook(int color, Square location) {
        super(color, location);
    }

    @Override
    public boolean canMove(String to) {
        Square targetLocation = location.getBoard().getSquareAt(to);

        if (location.isAtSameColumn(targetLocation) || location.getRow() == targetLocation.getRow()) {
            Square[] squaresBetween = location.getBoard().getSquaresBetween(location, targetLocation);

            for (Square square : squaresBetween) {
                if (!square.isEmpty()) {
                    return false;
                }
            }

            return true;
        }

        return false;
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
        return color == ChessBoard.WHITE ? "R" : "r";
    }
}