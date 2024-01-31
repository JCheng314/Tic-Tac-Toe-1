package com.example.tictactoe;

public class UserRecord {
    String userId;
    String userName;
    int player1Score;
    int player2Score;
    public UserRecord(){

    }
    public UserRecord(String userId, String userName, int player1Score, int player2Score){
        this.userId = userId;
        this.userName = userName;
        this.player1Score = player1Score;
        this.player2Score = player2Score;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public int getPlayer1Score() {
        return player1Score;
    }

    public int getPlayer2Score() {
        return player2Score;
    }
}
