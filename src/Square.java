public class Square {
    protected int row;
    protected int col;
    protected Piece piece;
    protected ChessBoard board;

    public ChessBoard getBoard() {
        return board ;
    }
    public Square(int row,int col){
        this.row = row;
        this.col = col;
    }

    public Square(int row, int col,Piece piece) {
        this.row = row;
        this.col = col;
        this.piece = piece;
        this.board = null;
    }

    public Square(int row, int col, Piece piece,ChessBoard board) {
        this.row = row;
        this.col = col;
        this.piece = piece;
        this.board = board;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public String toString() {
        if (piece != null) {
            return piece.toString();
        } else {
            return " ";
        }
    }

    public boolean isAtLastRow(int color) {
        if (color == ChessBoard.WHITE) {
            return row == 7;
        } else {
            return row == 0;
        }
    }

    public boolean isEmpty() {
        if (piece == null){
            return true;
        }else{
        return false;
        }
    }

    public boolean isAtSameColumn(Square square) {
        return col == square.getCol();
    }

    public void putNewQueen(int color) {
        piece = new Queen(color, this);
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece1){
        piece = piece1;
    }

    public void clear() {
        piece = null;
    }

    public int getRowDistance(Square location) {
        if (location == null) {
            return 0;
        }
        return Math.abs(this.getRow() - location.getRow());
    }

    public boolean isNeighborColumn(Square square) {
        int colDifference = Math.abs(square.getCol() - this.getCol());
        return colDifference == 1;
    }

    public int getColDistance(Square location) {
        return Math.abs(location.getCol() - this.getCol());
    }

}
