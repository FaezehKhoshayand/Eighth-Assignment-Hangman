package hangman;

import java.util.UUID;

public class Game {
    private UUID gameID;
    private String username;
    private Account account;
    private String word;
    private int wrongGuesses;
    private int time;
    private boolean win;


    public Game(UUID gameID, String username, String word, int wrongGuesses, int time, boolean win) {
        this.gameID = gameID;
        this.username = username;
        this.word = word;
        this.wrongGuesses = wrongGuesses;
        this.time = time;
        this.win = win;
    }
    public UUID getGameID() {
        return gameID;
    }
    public void setGameID(UUID gameID) {
        this.gameID = gameID;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public Account getAccount() {
        return account;
    }
    public void setUserInfo(Account account) {
        this.account = account;
    }
    public String getWord() {
        return word;
    }
    public void setWord(String word) {
        this.word = word;
    }

    public int getWrongGuesses() {
        return wrongGuesses;
    }
    public void setWrongGuesses(int wrongGuesses) {
        this.wrongGuesses = wrongGuesses;
    }
    public boolean isWin() {
        return win;
    }
    public void setWin(boolean win) {
        this.win = win;
    }
    public int getTime() {
        return time;
    }
    public void setTime(int time) {
        this.time = time;
    }


}