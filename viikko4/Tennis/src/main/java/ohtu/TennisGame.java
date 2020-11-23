package ohtu;

public class TennisGame {

	private int player1Score = 0;
	private int player2Score = 0;
	private String player1Name;
	private String player2Name;

	public TennisGame(String player1Name, String player2Name) {
		this.player1Name = player1Name;
		this.player2Name = player2Name;
	}

	public void wonPoint(String playerName) {
		if (playerName.equals(player1Name)) {
			player1Score += 1;
		} else if (playerName.equals(player2Name)) {
			player2Score += 1;
		}
	}

	public String getScore() {
		if (player1Score == player2Score) {
			
			if (player1Score == 4)
				return "Deuce";
			
			return getScoreName(player1Score) + "-All";
			
		} else if (player1Score >= 4 || player2Score >= 4) {
			int diff = Math.abs(player1Score - player2Score);
			String score = "";
			if (diff == 1) {
				score += "Advantage ";
			} else if (diff >= 2) {
				score += "Win for ";
			}
			if (player1Score > player2Score) {
				score += "player1";
			} else {
				score += "player2";
			}
			return score;
		}

		return getScoreName(player1Score) + "-" + getScoreName(player2Score);
	}

	private String getScoreName(int score) {
		switch (score) {
		case 0:
			return "Love";
		case 1:
			return "Fifteen";
		case 2:
			return "Thirty";
		case 3:
			return "Forty";
		}
		return null;
	}
}