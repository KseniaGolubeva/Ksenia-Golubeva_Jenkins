package org.douggschwind.games.chess;

import org.douggschwind.games.chess.piece.ChessPiece;

import java.util.Optional;

/**
 * Represents a given Square on the Chess board, that knows its exact location on the board and the ChessPiece, if any,
 * that occupies it.
 * @author Doug Gschwind
 */
public class Square {
    private final BoardPosition boardPosition;
    private Optional<ChessPiece> resident = Optional.empty();

    public Square(BoardPosition boardPosition) {
        this.boardPosition = boardPosition;
    }

    public BoardPosition getBoardPosition() {
        return boardPosition;
    }

    public Optional<ChessPiece> getResident() {
        return resident;
    }

    protected void setInitialResident(ChessPiece resident) {
        setResident(resident);
        if (resident != null) {
            resident.setInitialPosition(getBoardPosition());
        }
    }

    /**
     * Allows the resident of this square to be changed.
     * @param newValue Can be null in the case where a ChessPiece is captured, but leaves this instance empty,
     *                 like in the case of the En Passant move for a Pawn.
     */
    public void setResident(ChessPiece newValue) {
        resident = Optional.ofNullable(newValue);
    }

    /**
     * Empties or clears this instance to note that a ChessPiece no longer resides here.
     */
    public void empty() {
        setResident(null);
    }

    public boolean isOccupied() {
        return getResident().isPresent();
    }

    /**
     * Determines if that square is occupied by the opponent that occupies this square.
     * @param that Must be non-null.
     * @return
     */
    public boolean isOccupiedByOpponent(Square that) {
        if (!this.isOccupied() || !that.isOccupied()) {
            return false;
        } else {
            ChessPiece occupant = this.getResident().get();
            return occupant.isOpponent(that.getResident().get());
        }
    }

    public BoardPosition.Row getRow() {
        return getBoardPosition().getRow();
    }

    public BoardPosition.Column getColumn() {
        return getBoardPosition().getColumn();
    }

    // Used for printing the current state of the ChessBoard
    public Optional<String> getPrintAbbreviation() {
        if (isOccupied()) {
            ChessPiece occupant = getResident().get();
            return Optional.of(occupant.getOwner().getAbbreviation() + occupant.getPrintAbbreviation());
        } else {
            return Optional.empty();
        }
    }

    @Override
    public boolean equals(Object wideThat) {
        if (this == wideThat) {
            return true;
        } else if (!(wideThat instanceof Square)) {
            return false;
        }

        Square that = (Square) wideThat;
        return ((this.getRow() == that.getRow()) && (this.getColumn() == that.getColumn()));
    }

    @Override
    public int hashCode() {
        return this.getRow().hashCode() + this.getColumn().hashCode();
    }
}
