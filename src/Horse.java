public class Horse extends ChessPiece {
    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean isValidPos = checkPos(line) && checkPos(column) && checkPos(toLine) && checkPos(toColumn) && line != toLine && column != toColumn;

        if (isValidPos) {
            ChessPiece chessPiece = chessBoard.board[line][column];
            ChessPiece moveToPos = chessBoard.board[toLine][toColumn];

            if (chessPiece != null && (moveToPos == null || !moveToPos.getColor().equals(chessPiece.getColor()))) {
                int[][] horsePositions = new int[][]{
                        {line + 2, column - 1},
                        {line + 2, column + 1},
                        {line - 2, column - 1},
                        {line - 2, column + 1},
                        {line - 1, column - 2},
                        {line - 1, column + 2},
                        {line + 1, column - 2},
                        {line + 1, column + 2}
                };

                for (int[] position : horsePositions) {
                    if (position[0] == toLine && position[1] == toColumn)
                        return true;
                }

            }
        }

        return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }
}