package org.douggschwind.games.chess.piece;

import org.douggschwind.games.chess.ChessBoard;
import org.douggschwind.games.chess.moves.CommonMove;
import org.douggschwind.games.chess.Player;

/**
 * Represents one of the two Knight pieces in the game of Chess, for a given Player.
 * @author Doug Gschwind
 */
public class Knight extends ChessPiece implements CaptureUponAdvance {

    public Knight(Player player) {
        super(player);
    }

    @Override
    public final boolean isKnight() {
        return true;
    }

    /**
     * Knights move in an ‘L’ shape’: two squares in a horizontal or vertical direction, then move one square
     * horizontally or vertically. They are the only piece able to jump over other pieces.
     * @param chessBoard Must be non-null.
     * @param proposedMove Must be non-null and properly populated.
     * @return
     */
    @Override
    public boolean canMoveTo(ChessBoard chessBoard, CommonMove proposedMove) {
        if (!basicCanMoveTo(proposedMove)) {
            return false;
        }

        return isKnightMovement(proposedMove);
    }

    @Override
    protected void handleMoveTo(ChessBoard chessBoard, CommonMove move) {
        basicMove(move);
    }
}
