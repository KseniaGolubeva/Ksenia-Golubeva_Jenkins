package org.douggschwind.games.chess.piece;

import org.douggschwind.games.chess.ChessBoard;
import org.douggschwind.games.chess.moves.CommonMove;
import org.douggschwind.games.chess.Player;

/**
 * Represents the Queen piece in the game of Chess, for a given Player.
 * @author Doug Gschwind
 */
public class Queen extends ChessPiece implements CaptureUponAdvance {

    public Queen(Player player) {
        super(player);
    }

    @Override
    public final boolean isQueen() {
        return true;
    }

    /**
     * Queens move diagonally, horizontally, or vertically any number of squares. They are unable to jump over pieces.
     * @param chessBoard Must be non-null.
     * @param proposedMove Must be non-null and properly populated.
     * @return
     */
    @Override
    public boolean canMoveTo(ChessBoard chessBoard, CommonMove proposedMove) {
        if (!basicCanMoveTo(proposedMove)) {
            return false;
        }

        if (!proposedMove.isHorizontalMove() && !proposedMove.isVerticalMove() && !proposedMove.isDiagonalMove()) {
            return false;
        }

        return chessBoard.isPathClear(proposedMove);
    }

    @Override
    protected void handleMoveTo(ChessBoard chessBoard, CommonMove move) {
        basicMove(move);
    }
}
