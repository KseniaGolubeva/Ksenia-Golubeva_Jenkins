package org.douggschwind.games.chess.moves;

import org.douggschwind.games.chess.ChessBoard;
import org.douggschwind.games.chess.Player;
import org.douggschwind.games.chess.Square;
import org.douggschwind.games.chess.piece.ChessPiece;

/**
 * Represents the most common of moves in Chess, one piece being moved from one Square to another.
 * @author Doug Gschwind
 */
public class CommonMove <T extends ChessPiece> implements ChessMove {
    private final Square from;
    private final Square to;

    public <T> CommonMove(Class<T> chessPieceClass, Square from, Square to) {
        if ((from == null) || (to == null)) {
            throw new IllegalArgumentException("From and To Square must both be non-null");
        } else if (from.equals(to)) {
            throw new IllegalArgumentException("From and To Square cannot be the same");
        } else if (!from.isOccupied()) {
            throw new IllegalArgumentException("There is no piece occupying From");
        } else if (!chessPieceClass.equals(from.getResident().get().getClass())) {
            throw new IllegalArgumentException("The piece occupying From is not of type " + chessPieceClass.getSimpleName());
        }

        this.from = from;
        this.to = to;
    }

    @Override
    public final boolean isCommonMove() {
        return true;
    }

    public Square getFrom() {
        return from;
    }

    public Square getTo() {
        return to;
    }

    /**
     * Determines if this move is permitted by the given Player and state of the ChessBoard.
     * @param player Must be non-null.
     * @param chessBoard Must be non-null.
     * @return true if this proposed move is permitted by the given Player, false otherwise.
     */
    @Override
    public boolean isPermitted(Player player, ChessBoard chessBoard) {
        if (!player.canMoveFrom(getFrom())) {
            return false;
        }

        return getFrom().getResident().get().canMoveTo(chessBoard, this);
    }

    public int getAbsNumRowsMovement() {
        return Math.abs(from.getRow().getId() - to.getRow().getId());
    }

    public int getAbsNumColumnsMovement() {
        return Math.abs(from.getColumn().getId() - to.getColumn().getId());
    }

    public boolean isHorizontalMove() {
        return getAbsNumRowsMovement() == 0;
    }

    public boolean isVerticalMove() {
        return getAbsNumColumnsMovement() == 0;
    }

    public boolean isDiagonalMove() {
        // Number of rows of movement must equal number of columns to move diagonally.
        return getAbsNumRowsMovement() == getAbsNumColumnsMovement();
    }
}
