package at.ac.tuwien.big.we15.lab2.api.impl;

import at.ac.tuwien.big.we15.lab2.api.Answer;
import at.ac.tuwien.big.we15.lab2.api.Avatar;
import at.ac.tuwien.big.we15.lab2.api.Category;
import at.ac.tuwien.big.we15.lab2.api.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Sebastian on 23.04.2015.
 */
public class Game {

    private PlayerBean bot, player;

    private boolean player_lead;

    private int current_round;

    private List<Category> categories;
    private List<Question> answered;

    public Game(List<Category> categories) {
        this.player = new PlayerBean();
        this.player.setAvatar(Avatar.getRandomAvatar());
        this.player.setDone(false);
        this.player.setCorrect(false);
        this.player.setAnswered(false);

        this.bot = new PlayerBean();
        this.bot.setAvatar(Avatar.getOpponent(this.player.getAvatar()));
        this.bot.setDone(false);
        this.bot.setCorrect(false);
        this.bot.setAnswered(false);

        this.current_round = 0;
        this.categories = categories;
        this.answered = new ArrayList<>();

        this.player_lead = true;

    }

    /**
     * Simulate a round and makes sure of a right order.
     *
     * @param questionID questionID as string
     * @param values answer ids as values
     * @return true -> round was finished no further action required; false -> refresh page
     */
    public boolean simulateRound(String questionID, String[] values) {

        boolean toReturn = true;

        // necessary to prevent exception
        if (current_round == 0 && questionID == null) {
            return true;
        }

        if (isNewRound()) {
            if (this.player_lead) {
                playerMove(Integer.parseInt(questionID), values);
                botMove();
                toReturn =  this.player.getScore() >= this.bot.getScore() ? true : false;
            } else {
                botMove();
                toReturn = false;
            }
        } else {
            if (this.player.getDone()) {
                botMove();
                toReturn = true;
            } else {
                if (!wasAnswered(Integer.parseInt(questionID))) {
                    playerMove(Integer.parseInt(questionID), values);
                    toReturn =  this.player.getScore() >= this.bot.getScore() ? true : false;
                } else {
                    toReturn = true;
                }
            }
        }

        if (this.player.getDone() && this.bot.getDone()) {
            this.current_round++;
        }

        return toReturn;
    }

    /**
     * Check the answers of the human player and set the points accordingly.
     *
     * @param questionID
     * @param values
     */
    public void playerMove(int questionID, String[] values) {
        Question question = questionById(questionID);
        this.player.setQuestion(question);
        this.player.setCorrect(isAnsweredCorrectly(questionID, values));
        setPoints(this.player.getCorrect() ? this.player.getQuestion().getValue() : -this.player.getQuestion().getValue(), this.player.getAvatar().getId());
        removeQuestion(questionID);
        this.player.setDone(true);
        this.player.setAnswered(true);
    }

    /**
     * Simulate the bot players move by letting him randomly answer a random quesiton.
     */
    public void botMove() {
        Question question = getRandomQuestion();
        this.bot.setQuestion(question);
        this.bot.setCorrect((Math.abs(new Random().nextInt()) % 3) == 0);
        setPoints(this.bot.getCorrect() ? this.bot.getQuestion().getValue() : -this.bot.getQuestion().getValue(), this.bot.getAvatar().getId());
        removeQuestion(question.getId());
        this.bot.setDone(true);
        this.bot.setAnswered(true);
    }

    /**
     * Checks whether or not a question was answered correctly
     *
     * @param question_id id of the question
     * @param answered_values string array containing the IDs of the given answers
     * @return true is answered correctly, else false
     */
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

    /**
     * Adds the given Question to a list of all answered questions to be able to tell which questions were already
     * asked.
     *
     * @param questionID id of the question that is to be "removed"
     */
    public void removeQuestion(int questionID) {
        Question to_remove = questionById(questionID);
        if (to_remove != null) {
            for (Category c : this.categories) {
                if (c.equals(to_remove.getCategory())) {
                    answered.add(to_remove);
                    break;
                }
            }
        }
    }

    /**
     *
     * @param question_id
     * @return true if the given question has already been answered before
     */
    public boolean wasAnswered(int question_id) {
        return answered.contains(questionById(question_id));
    }

    /**
     *
     * @return the human player
     */
    public PlayerBean getPlayer() {
        return this.player;
    }

    /**
     *
     * @return the computer player
     */
    public PlayerBean getBot() {
        return this.bot;
    }

    /**
     *
     * @return the current round
     */
    public int getCurrentRound() {
        return this.current_round;
    }

    /**
     *
     * @param id id of the question
     * @return Question with the given ID
     */
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

    /**
     *
     * @return List of all Questions sorted by Category
     */
    public List<Category> getCategories() {
        return this.categories;
    }

    /**
     *
     * @return true if player points are larger or equal to bots points
     */
    public boolean isPlayerInLead() {
        return this.player.getScore() >= this.bot.getScore();
    }

    /**
     *
     * @return true if this is a new round (player and bot are done)
     */
    public boolean isNewRound() {
        return !this.player.getDone() && !this.bot.getDone();
    }

    /**
     * Check if both players made their move and if so reset boolean values and increment round number.
     */
    public void checkRound() {
        if (this.player.getDone() && this.bot.getDone()) {
            this.player.setDone(false);
            this.bot.setDone(false);
            this.player_lead = this.player.getScore() >= this.bot.getScore();
        }
    }

    /**
     * Chooses a random question from the list of all questions, excluding the ones that have already been asked
     * beforehand.
     *
     * @return a random question
     */
    private Question getRandomQuestion() {
        int random = -1;

        while (random <= 0) {
            int r = (int) ((Math.random() * 22.0 + 1));
            if (!wasAnswered(r)) { random = r ; }
        }
        return questionById(random);
    }

    /**
     *
     * @param points points to be added or subtracted
     * @param avatar_id the avatar whos points are to be updated
     */
    private void setPoints(int points, String avatar_id) {
        if (this.player.getAvatar().getId().equals(avatar_id)) {
            this.player.setScore(this.player.getScore()+points);
        } else if (this.bot.getAvatar().getId().equals(avatar_id)) {
            this.bot.setScore(this.bot.getScore()+points);
        }
    }


}
