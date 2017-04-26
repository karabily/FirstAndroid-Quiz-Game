package mobile.karasoft.ma.whereiswho.models.bean;

/**
 * Created by yassine on 20/04/17.
 */

public class Score {


    private int score;

    public Score() {
        this.score=0;

    }


    public Score(int value) {
        this.score=value;

    }


    public int getScore() {
        return this.score;
    }

    public void setScore(int value) {
        this.score = score;
    }
}
