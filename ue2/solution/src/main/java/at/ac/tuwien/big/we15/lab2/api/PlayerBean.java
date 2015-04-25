package at.ac.tuwien.big.we15.lab2.api;

import java.io.Serializable;

/**
 * Created by Sebastian on 25.04.2015.
 */
public class PlayerBean implements Serializable {

    private Avatar avatar;
    private Question question;
    private int score;
    private boolean correct, done;

    public PlayerBean() {};

    public Avatar getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
