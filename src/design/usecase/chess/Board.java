package design.usecase.chess;

import java.util.Arrays;

public class Board {
    Square[][] squares;

    public Board() {
        this.squares = new Square[8][8];
        init();
    }

    private void init() {
        squares[0][0] = new Square(0, 0, new Piece(Piece.Type.ROOK, Piece.Color.WHITE));
        squares[0][7] = new Square(0, 7, new Piece(Piece.Type.ROOK, Piece.Color.WHITE));
        squares[0][1] = new Square(0, 1, new Piece(Piece.Type.KNIGHT, Piece.Color.WHITE));
        squares[0][6] = new Square(0, 6, new Piece(Piece.Type.KNIGHT, Piece.Color.WHITE));
        squares[0][2] = new Square(0, 2, new Piece(Piece.Type.BISHOP, Piece.Color.WHITE));
        squares[0][5] = new Square(0, 5, new Piece(Piece.Type.BISHOP, Piece.Color.WHITE));
        squares[0][3] = new Square(0, 3, new Piece(Piece.Type.QUEEN, Piece.Color.WHITE));
        squares[0][4] = new Square(0, 4, new Piece(Piece.Type.KING, Piece.Color.WHITE));

        squares[7][0] = new Square(7, 0, new Piece(Piece.Type.ROOK, Piece.Color.BLACK));
        squares[7][7] = new Square(7, 7, new Piece(Piece.Type.ROOK, Piece.Color.BLACK));
        squares[7][1] = new Square(7, 1, new Piece(Piece.Type.KNIGHT, Piece.Color.BLACK));
        squares[7][6] = new Square(7, 6, new Piece(Piece.Type.KNIGHT, Piece.Color.BLACK));
        squares[7][2] = new Square(7, 2, new Piece(Piece.Type.BISHOP, Piece.Color.BLACK));
        squares[7][5] = new Square(7, 5, new Piece(Piece.Type.BISHOP, Piece.Color.BLACK));
        squares[7][3] = new Square(7, 3, new Piece(Piece.Type.KING, Piece.Color.BLACK));
        squares[7][4] = new Square(7, 4, new Piece(Piece.Type.QUEEN, Piece.Color.BLACK));

        for(int i=0; i<8; i++)
            squares[1][i] = new Square(1, i, new Piece(Piece.Type.PAWN, Piece.Color.WHITE));

        for(int i=0; i<8; i++)
            squares[6][i] = new Square(6, i, new Piece(Piece.Type.PAWN, Piece.Color.BLACK));

        for(int i=2; i<6; i++) {
            for(int j=0; j<8; j++) {
                squares[i][j] = new Square(i, j, null);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
       for (int i=0; i<8; i++)
           stringBuilder.append(Arrays.toString(squares[i]));
       return stringBuilder.toString();
    }
}
