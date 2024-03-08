public class ChessBoard {
    protected static final int WHITE = 0;
    protected static final int BLACK = 1;
    protected Square[][] board;
    protected static boolean whitePlaying = true;

    public Square[][] getBoard() {
        return board;
    }

    public ChessBoard() {
        board = new Square[8][8];
        for(int i = 0; i<8;i++){
            for(int j = 0;j<8;j++){
                board[i][j] = new Square(i,j,null,this);
            }
        }
        board[0][0].setPiece(new Rook(WHITE, board[0][0]));
        board[0][1].setPiece(new Knight(WHITE, board[0][1]));
        board[0][2].setPiece(new Bishop(WHITE, board[0][2]));
        board[0][3].setPiece(new Queen(WHITE, board[0][3]));
        board[0][4].setPiece(new King(WHITE, board[0][4]));
        board[0][5].setPiece(new Bishop(WHITE, board[0][5]));
        board[0][6].setPiece(new Knight(WHITE, board[0][6]));
        board[0][7].setPiece(new Rook(WHITE, board[0][7]));

        for (int i = 0; i < 8; i++) {
            board[1][i].setPiece(new Pawn(WHITE, board[1][i]));
        }

        for (int i = 0; i < 8; i++) {
            board[6][i].setPiece(new Pawn(BLACK, board[6][i]));
        }

        board[7][0].setPiece(new Rook(BLACK, board[7][0]));
        board[7][1].setPiece(new Knight(BLACK, board[7][1]));
        board[7][2].setPiece(new Bishop(BLACK, board[7][2]));
        board[7][3].setPiece(new Queen(BLACK, board[7][3]));
        board[7][4].setPiece(new King(BLACK, board[7][4]));
        board[7][5].setPiece(new Bishop(BLACK, board[7][5]));
        board[7][6].setPiece(new Knight(BLACK, board[7][6]));
        board[7][7].setPiece(new Rook(BLACK, board[7][7]));

    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("     A   B   C   D   E   F   G   H  \n");
        sb.append("   ---------------------------------\n");
        for (int row = 0; row < 8; row++) {
            sb.append(" " + (8 - row) + " ");
            for (int col = 0; col < 8; col++) {
                sb.append("| ").append(board[7 - row][col] != null ? board[7 - row][col] : " ").append(" ");
            }
            sb.append("| ").append(8 - row).append("\n");
            sb.append("   ---------------------------------\n");
        }
        sb.append("     A   B   C   D   E   F   G   H  \n");
        return sb.toString();
    }

    public boolean isGameEnded() {
        boolean isWhiteKing = false;
        boolean isBlackKing = false;

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Square square = board[row][col];
                if (square.getPiece() instanceof King) {
                    if (square.getPiece().getColor() == WHITE) {
                        isWhiteKing = true;
                    } else {
                        isBlackKing = true;
                    }
                }
            }
        }

        return !(isWhiteKing && isBlackKing);
    }

    public boolean isWhitePlaying() {
        return whitePlaying;
    }
    public Piece getPieceAt(String from) {
        return getSquareAt(from).getPiece();
    }

    public void nextPlayer() {
        whitePlaying = !whitePlaying;
    }

    public Square getSquareAt(String position) {
        int row = position.toUpperCase().charAt(1)-'1';
        int col = position.toUpperCase().charAt(0)-'A';

        return board[row][col];
    }

    public Square[] getSquaresBetween(Square location, Square targetLocation) {
        int rowDistance = targetLocation.getRow() - location.getRow();
        int colDistance = targetLocation.getCol() - location.getCol();
        int numSquares = Math.max(Math.abs(rowDistance), Math.abs(colDistance)) - 1;

        if (numSquares <= 0) {
            return new Square[0];
        }

        Square[] squaresBetween = new Square[numSquares];
        int rowStep = rowDistance > 0 ? 1 : -1;
        int colStep = colDistance > 0 ? 1 : -1;

        int row = location.getRow();
        int col = location.getCol();

        for (int i = 0; i < numSquares; i++) {
            row += rowStep;
            col += colStep;
            squaresBetween[i] = board[row][col];
        }

        return squaresBetween;
    }
}
