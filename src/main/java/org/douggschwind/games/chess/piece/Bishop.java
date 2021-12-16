package org.douggschwind.games.chess.piece;

import org.douggschwind.games.chess.ChessBoard;
import org.douggschwind.games.chess.moves.CommonMove;
import org.douggschwind.games.chess.Player;

/**
 * Represents one of the two Bishop pieces in the game of Chess, for a given Player.
 * @author Doug Gschwind
 */
public class Bishop extends ChessPiece implements CaptureUponAdvance {

    public Bishop(Player player) {
        super(player);
    }

    @Override
    public final boolean isBishop() {
        return true;
    }

    /**
     * Bishops move diagonally any number of squares. They are unable to jump over pieces.
     * @param chessBoard Must be non-null.
     * @param proposedMove Must be non-null and properly populated.
     * @return
     */
    @Override
    public boolean canMoveTo(ChessBoard chessBoard, CommonMove proposedMove) {
        if (!basicCanMoveTo(proposedMove)) {
            return false;
        }

        if (!proposedMove.isDiagonalMove()) {
            return false;
        }

        return chessBoard.isPathClear(proposedMove);
    }

    @Override
    protected void handleMoveTo(ChessBoard chessBoard, CommonMove move) {
        basicMove(move);
    }
}
