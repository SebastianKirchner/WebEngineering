package at.ac.tuwien.big.we15.lab2.api;

import at.ac.tuwien.big.we15.lab2.api.impl.SimpleQuestion;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Sebastian on 23.04.2015.
 */
public class Game {

    private Avatar bot, player, first;

    private Question bot_question;

    private boolean player_done, bot_done, bot_right, bot_answered;

    private int current_round, bot_points, player_points;

    private List<Category> categories;
    private List<Question> answered;

    public Game(Avatar player, List<Category> categories) {
        this.player = player;
        this.bot = Avatar.getOpponent(this.player);
        this.current_round = 1;
        this.categories = categories;
        this.first = this.player;
        this.answered = new ArrayList<>();
        this.bot_question = new SimpleQuestion();
        this.bot_right = false;
        this.bot_answered = false;
    }

    public void removeQuestion(int questionID) {
        Question to_remove = questionById(questionID);
        if (to_remove != null) {
            for (Category c : this.categories) {
                if (c.equals(to_remove.getCategory())) {
                    //c.removeQuestion(to_remove);
                    answered.add(to_remove);
                    break;
                }
            }
        }
    }

    public void evaluateRound(int questionID, String[] values) {
        this.bot_answered = false;
        Question question = questionById(questionID);
        boolean correct = isAnsweredCorrectly(questionID, values);
        setPoints(correct ? question.getValue() : -question.getValue());

        if (this.first.getId() == this.player.getId()) {
            manageRound();
            removeQuestion(questionID);

            botTurn();
            manageRound();

        } else if (this.first.getId() == this.bot.getId()) {
            botTurn();
            manageRound();

            manageRound();
            removeQuestion(questionID);
        }
    }

    public boolean isAnsweredCorrectly(int question_id, String[] answered_values) {
        Question question = questionById(question_id);
        List<Integer> answer_ids = new ArrayList<>();
        boolean is_correct = false;

        if (answered_values == null || answered_values.length == 0) {
            return is_correct;
        }

        for (String s : answered_values) {
            answer_ids.add(Integer.parseInt(s));
        }

        if (question.getCorrectAnswers().size() == answer_ids.size()) {
            for (Answer a : question.getCorrectAnswers()) {
                if (!answer_ids.contains(a.getId())) {
                    return false;
                }
            }

            return true;
        }

        return false;
    }

    public boolean wasAnswered(Question question) {
        return answered.contains(question);
    }

    public Avatar getPlayer() {
        return this.player;
    }

    public Avatar getBot() {
        return this.bot;
    }

    public int getPlayerPoints() {
        return this.player_points;
    }

    public int getBotPoints() {
        return this.bot_points;
    }

    public int getCurrentRound() {
        return this.current_round;
    }

    public Question questionById(int id) {
        for(Category c : categories){
            for(Question q : c.getQuestions()){
                if(q.getId() == id){
                    return q;
                }
            }
        }

        return null;
    }

    public List<Category> getCategories() {
        return this.categories;
    }

    public boolean isPlayerInLead() {
        return this.player_points >= this.bot_points;
    }

    public Question getBotQuestion() {
        return this.bot_question;
    }

    public boolean getBotRight() {
        return bot_right;
    }

    public boolean botAnswered() {
        return this.bot_answered;
    }

    private void botTurn() {

        int random = -1;

        while (random <= 0) {
            int r = (int) ((Math.random() * 22.0 + 1));
            if (!wasAnswered(questionById(r))) { random = r ; }
        }

        Question chosen = questionById(random);

        String[] values = new String[(int) ((double) Math.random()*chosen.getAllAnswers().size()-2 + 1)];
        List<Integer> taken = new ArrayList<>();

        for (int i=0; i<values.length; ++i) {
            if (i == 0) {
                values[i] = String.valueOf(chosen.getCorrectAnswers().get(0).getId());
                taken.add(chosen.getCorrectAnswers().get(0).getId());
            } else {
                boolean valid = false;
                int newID = -1;
                while (!valid) {
                    newID = new Random().nextInt(chosen.getAllAnswers().size());
                    if (!taken.contains(newID) && newID < chosen.getAllAnswers().size() && newID > 0) {
                        valid = true;
                    }

                }
                values[i] = String.valueOf(newID);
                taken.add(newID);
            }
        }

        this.bot_right = isAnsweredCorrectly(random, values);
        setPoints(bot_right ? chosen.getValue() : -chosen.getValue());
        this.bot_question = chosen;
        this.bot_answered = true;
        removeQuestion(random);
    }

    private void manageRound() {
        if (this.player_done && this.bot_done) {
            this.first = player_points <= bot_points ? this.player : this.bot;
            this.player_done = false;
            this.bot_done = false;
            this.current_round++;
        } else if (this.player_done) {
            this.first = this.bot;
        } else if (this.bot_done) {
            this.first = this.player;
        }
    }

    private void setPoints(int points) {
        if (this.first.getId() == this.player.getId()) {
            this.player_points += points;
            this.player_done = true;
        } else {
            this.bot_points += points;
            this.bot_done = true;
        }
    }


}
