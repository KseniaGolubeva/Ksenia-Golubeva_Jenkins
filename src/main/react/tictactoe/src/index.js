import React from 'react';
import ReactDOM from 'react-dom';
import PropTypes from 'prop-types';
import './index.css';

// Since Square has no state of its own, other than props, lets use a simple
// Stateless Functional Component here.
const Square = props =>
    <button className="square" onClick={props.clickHandler}>
        {props.owner}
    </button>

// Instruct React to do property type validation on Square instances.
// Both properties are required.
Square.propTypes = {
    owner: PropTypes.string.isRequired,
    clickHandler: PropTypes.func.isRequired
}

class Board extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
        squareOwners: new Array(9).fill(null),
        nextPlayer: 'X',
        gameHasEndedInTie: false,
        winner: null,
    };
  }

  hasGameEndedInTie(squareOwners) {
    for (var squareIndex = 0;squareIndex < 9;squareIndex++) {
      if (squareOwners[squareIndex] === null) {
        return false;
      }
    }
    return true;
  }

  // Determines the winner of the game, if there is one.
  // Returns 'T' to indicate that the game has ended in a tie,
  // null to indicate there is no winner yet, and non-null
  // to identify the actual game winner.
  determineGameWinner(squareOwners) {
    var linesToCheck = [
      [0,1,2],
      [3,4,5],
      [6,7,8],
      [0,3,6],
      [1,4,7],
      [2,5,8],
      [0,4,8],
      [2,4,6]];

    for (var lineIndex = 0;lineIndex < linesToCheck.length;lineIndex++) {
      var lineToCheck = linesToCheck[lineIndex];
      var gameWinner = squareOwners[lineToCheck[0]];

      if (gameWinner && 
          (squareOwners[lineToCheck[1]] == gameWinner) &&
          (squareOwners[lineToCheck[2]] == gameWinner)) {
         return gameWinner;
      }
    }

    // No clear winner yet, lets see if the game has ended in a tie.
    if (this.hasGameEndedInTie(squareOwners)) {
      return 'T';
    }

    // No winner as yet.
    return null;
  }

  isGameOver() {
    return (this.state.hasGameEndedInTie || this.state.winner);
  }

  handleSquareClick(i) {
    if (this.state.squareOwners[i]) {
      // One of the players already owns this square, ignore this click.
      return;
    }
    if (this.isGameOver()) {
      // Ignore this click, this game has ended.
      return;
    }

    var squareOwnersCopy = this.state.squareOwners.slice();
    squareOwnersCopy[i] = this.state.nextPlayer;
    var gameWinner = this.determineGameWinner(squareOwnersCopy);
    this.setState({
       squareOwners: squareOwnersCopy,
       nextPlayer: this.state.nextPlayer === 'X' ? 'O' : 'X',
       hasGameEndedInTie: gameWinner === 'T',
       winner: gameWinner,
    });
  }

  renderSquare(i) {
    return <Square owner={this.state.squareOwners[i]} clickHandler={() => this.handleSquareClick(i)}/>;
  }

  playAgain() {
    var nextPlayer;
    if (this.state.hasGameEndedInTie) {
      nextPlayer = 'X';
    } else {
       nextPlayer = this.state.winner;
    }

    this.setState({
       squareOwners: new Array(9).fill(null),
       nextPlayer: nextPlayer,
       hasGameEndedInTie: false,
       winner: null,
    });
  }

  getGameStatus() {
    if (this.state.hasGameEndedInTie) {
      return 'Game has ended in a tie';
    } else if (this.state.winner) {
      return 'Winner: ' + this.state.winner;
    } else {
      return 'Next player: ' + this.state.nextPlayer;
    }
  }

  render() {
    return (
      <div>
        <div className="status">{this.getGameStatus()}</div>
        <div className="board-row">
          {this.renderSquare(0)}
          {this.renderSquare(1)}
          {this.renderSquare(2)}
        </div>
        <div className="board-row">
          {this.renderSquare(3)}
          {this.renderSquare(4)}
          {this.renderSquare(5)}
        </div>
        <div className="board-row">
          {this.renderSquare(6)}
          {this.renderSquare(7)}
          {this.renderSquare(8)}
        </div>
        {this.isGameOver() &&
          <div>
            <button onClick={() => this.playAgain()}>Play Again?</button>
          </div>
        }
      </div>
    );
  }
}

class Game extends React.Component {
  render() {
    return (
      <div className="game">
        <div className="game-board">
          <Board />
        </div>
        <div className="game-info">
          <div>{/* status */}</div>
          <ol>{/* TODO */}</ol>
        </div>
      </div>
    );
  }
}

// ========================================

ReactDOM.render(
  <Game />,
  document.getElementById('root')
);
