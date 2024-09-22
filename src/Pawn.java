class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean isValidPos = checkPos(line) && checkPos(column) && checkPos(toLine) && checkPos(toColumn) && line != toLine;
        if (isValidPos) {
            ChessPiece chessPiece = chessBoard.board[line][column];

            if (column == toColumn && chessBoard.board[toLine][toColumn] == null) {
                if (color.equals("White")) {
                    if (line == 1) {
                        if (line + 1 == toLine || line + 2 == toLine) {
                            return true;
                        }
                    } else if (line + 1 == toLine) {
                        return true;
                    }
                } else {
                    if (line == 6) {
                        if (line - 1 == toLine || line - 2 == toLine) {
                            return true;
                        }
                    } else if (line - 1 == toLine) {
                        return true;
                    }
                }

            } else {

              if ((column + 1 == toColumn || column - 1 == toColumn) && (line + 1 == toLine || line - 1 == toLine) && chessBoard.board[toLine][toColumn] != null) {
                  return !chessBoard.board[toLine][toColumn].getColor().equals(chessPiece.getColor());
              }
            }
        }


        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }

}