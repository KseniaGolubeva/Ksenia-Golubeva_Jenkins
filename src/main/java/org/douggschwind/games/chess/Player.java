package org.douggschwind.games.chess;

import org.douggschwind.games.chess.piece.ChessPiece;

import java.util.Optional;

/**
 * @author Doug Gschwind
 */
public enum Player {
    BLACK("B"),
    WHITE("W");

    private String abbreviation;

    Player(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public boolean isBlack() {
        return this == BLACK;
    }

    public boolean isWhite() {
        return this == WHITE;
    }

    public Player getOpponent() {
        return isBlack() ? WHITE : BLACK;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    /**
     * Determines if this player can move the ChessPiece located in the from Square. This is a very high level
     * test which only concerns the from Square, it does not consider other Squares or the possible existence of
     * other ChessPiece instances.
     * @param from Must be non-null, but can be unoccupied.
     * @return true if so, false otherwise.
     */
    public boolean canMoveFrom(Square from) {
        Optional<ChessPiece> occupant = from.getResident();
        return occupant.isPresent() && occupant.get().canMoveFrom(this, from);
    }
}
