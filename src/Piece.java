public abstract class Piece {
    public int color;
    public Square location;

    public Piece(int color, Square location) {
        this.color = color;
        this.location = location;
    }

    public int getColor() {
        return color;
    }

    public abstract boolean canMove(String to);

    public abstract void move(String to);

}