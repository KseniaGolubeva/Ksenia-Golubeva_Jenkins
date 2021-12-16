package org.douggschwind.games.chess.piece;

import org.douggschwind.games.chess.ChessBoard;
import org.douggschwind.games.chess.moves.CommonMove;
import org.douggschwind.games.chess.Player;

/**
 * Represents the King piece in the game of Chess, for a given Player.
 * @author Doug Gschwind
 */
public class King extends ChessPiece implements CaptureUponAdvance {

    public King(Player player) {
        super(player );
    }

    @Override
    public final boolean isKing() {
        return true;
    }

    /**
     * Kings move one square in any direction, so long as that square is not attacked by an enemy piece.
     * Additionally, kings are able to make a special move, know as castling.
     * @param chessBoard Must be non-null.
     * @param proposedMove Must be non-null and properly populated.
     * @return
     */
    @Override
    public boolean canMoveTo(ChessBoard chessBoard, CommonMove proposedMove) {
        if (!basicCanMoveTo(proposedMove)) {
            return false;
        }

        final int numRowsMovement = proposedMove.getAbsNumRowsMovement();
        final int numColumnsMovement = proposedMove.getAbsNumColumnsMovement();

        if (numRowsMovement == 0) {
            return numColumnsMovement == 1;
        } else if (numColumnsMovement == 0) {
            return numRowsMovement == 1;
        } else {
            return ((numRowsMovement == 1) && (numColumnsMovement == 1));
        }
    }

    @Override
    protected void handleMoveTo(ChessBoard chessBoard, CommonMove move) {
        basicMove(move);
    }

    public boolean isInCheck() {
        return false; //TODO
    }
}
