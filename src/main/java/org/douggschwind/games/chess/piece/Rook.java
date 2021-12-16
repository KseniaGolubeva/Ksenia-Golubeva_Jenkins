package org.douggschwind.games.chess.piece;

import org.douggschwind.games.chess.ChessBoard;
import org.douggschwind.games.chess.moves.CommonMove;
import org.douggschwind.games.chess.Player;

/**
 * Represents one of the two Rook pieces in the game of Chess, for a given Player.
 * @author Doug Gschwind
 */
public class Rook extends ChessPiece implements CaptureUponAdvance {

    public Rook(Player player) {
        super(player);
    }

    @Override
    public final boolean isRook() {
        return true;
    }

    /**
     * Rooks move horizontally or vertically any number of squares. They are unable to jump over pieces.
     * Rooks move when the king castles.
     * @param chessBoard Must be non-null.
     * @param proposedMove Must be non-null and properly populated.
     * @return
     */
    @Override
    public boolean canMoveTo(ChessBoard chessBoard, CommonMove proposedMove) {
        if (!basicCanMoveTo(proposedMove)) {
            return false;
        }

        if ((!proposedMove.isHorizontalMove()) && (!proposedMove.isVerticalMove())) {
            // Rooks can only move horizontally or vertically.
            return false;
        }

        return chessBoard.isPathClear(proposedMove);
    }

    @Override
    protected void handleMoveTo(ChessBoard chessBoard, CommonMove move) {
        basicMove(move);
    }
}
