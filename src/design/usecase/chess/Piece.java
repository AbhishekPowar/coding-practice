package design.usecase.chess;

public class Piece {
    public enum Type { PAWN, ROOK, KING, QUEEN, BISHOP, KNIGHT}
    public enum Color {WHITE, BLACK}

    private Type type;
    private Color color;
    private boolean alive;

    public Piece(Type type, Color color) {
        this.type = type;
        this.color = color;
        this.alive = true;
    }

    public Color getColor() {
        return color;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive){
        this.alive = alive;
    }

    @Override
    public String toString() {
        return "Piece{" +
                "type=" + type +
                ", color=" + color +
                ", alive=" + alive +
                '}';
    }
}
