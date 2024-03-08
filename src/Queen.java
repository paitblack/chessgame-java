public class Queen extends Piece {
    boolean initialLocation = true;
    public Queen(int color, Square location) {
        super(color, location);
    }

    @Override
    public boolean canMove(String to) {
        Square targetLocation = location.getBoard().getSquareAt(to);
        int rowDistance = targetLocation.getRowDistance(location);
        int colDistance = targetLocation.getColDistance(location);

        if (rowDistance == 0 || colDistance == 0 || Math.abs(rowDistance) == Math.abs(colDistance)) {
            Square[] path = location.getBoard().getSquaresBetween(location, targetLocation);
            if (path != null) {
                for (Square square : path) {
                    if (!square.isEmpty()) {
                        return false;
                    }
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
        return color == ChessBoard.WHITE ? "Q" : "q";
    }
}