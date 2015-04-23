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

    private boolean player_done, bot_done, player_correct, bot_correct, bot_answered;

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
        this.bot_correct = false;
        this.bot_answered = false;
        this.player_correct = false;
        this.player_done = false;
        this.bot_done = false;

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
                    //c.removeQuestion(to_remove);
                    answered.add(to_remove);
                    break;
                }
            }
        }
    }

    /**
     * Check the answers of the human player and set the points accordingly.
     *
     * @param questionID
     * @param values
     */
    public void playerMove(int questionID, String[] values) {
        Question question = questionById(questionID);
        this.player_correct = isAnsweredCorrectly(questionID, values);
        setPoints(this.player_correct ? question.getValue() : -question.getValue(), this.player.getId());
        removeQuestion(questionID);
        this.player_done = true;
        checkRound();
    }

    /**
     * Simulate the bot players move by letting him randomly answer a random quesiton.
     */
    public void botMove() {
        Question question = getRandomQuestion();
        this.bot_question = question;
        this.bot_correct = isAnsweredCorrectly(question.getId(), getRandomAnswerValues(question));
        setPoints(this.bot_correct ? question.getValue() : -question.getValue(), this.bot.getId());
        removeQuestion(question.getId());
        this.bot_done = true;
        this.bot_answered = true;
        checkRound();
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
     *
     * @param question
     * @return true if the given question has already been answered before
     */
    public boolean wasAnswered(Question question) {
        return answered.contains(question);
    }

    /**
     *
     * @return the human player
     */
    public Avatar getPlayer() {
        return this.player;
    }

    /**
     *
     * @return the computer player
     */
    public Avatar getBot() {
        return this.bot;
    }

    /**
     *
     * @return the players points
     */
    public int getPlayerPoints() {
        return this.player_points;
    }

    /**
     *
     * @return the computer players points
     */
    public int getBotPoints() {
        return this.bot_points;
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
        return this.player_points >= this.bot_points;
    }

    public boolean isRoundFinished() {
        return this.player_done && this.bot_done;
    }
    /**
     *
     * @return the random question the bot was asked
     */
    public Question getBotQuestion() {
        return this.bot_question;
    }

    /**
     *
     * @return true if player answered correctly
     */
    public boolean isPlayerCorrect() {
        return this.player_correct;
    }

    /**
     *
     * @return true if bot answered correctly
     */
    public boolean isBotCorrect() {
        return this.bot_correct;
    }

    /**
     *
     * @return true if the bot already answered
     */
    public boolean botAnswered() {
        return this.bot_answered;
    }

    /**
     * Check if both players made their move and if so reset boolean values and increment round number.
     */
    private void checkRound() {
        if (this.player_done && this.bot_done) {
            this.player_done = false;
            this.bot_done = false;
            this.current_round++;
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
            if (!wasAnswered(questionById(r))) { random = r ; }
        }
        return questionById(random);
    }

    /**
     * Choose random answers for the given question, to give the bot a higher chance choose at least one correct
     * answer all the time.
     *
     * @param question Question to get random answers for
     * @return string array containing at least 1 correct answer id
     */
    private String[] getRandomAnswerValues(Question question) {
        String[] values = new String[(int) ((double) Math.random()*question.getAllAnswers().size()-2 + 1)];
        List<Integer> taken = new ArrayList<>();

        for (int i=0; i<values.length; ++i) {
            if (i == 0) {
                values[i] = String.valueOf(question.getCorrectAnswers().get(0).getId());
                taken.add(question.getCorrectAnswers().get(0).getId());
            } else {
                boolean valid = false;
                int newID = -1;
                while (!valid) {
                    newID = new Random().nextInt(question.getAllAnswers().size());
                    if (!taken.contains(newID) && newID < question.getAllAnswers().size() && newID > 0) {
                        valid = true;
                    }

                }
                values[i] = String.valueOf(newID);
                taken.add(newID);
            }
        }

        return values;
    }

    /**
     *
     * @param points points to be added or subtracted
     * @param avatar_id the avatar whos points are to be updated
     */
    private void setPoints(int points, String avatar_id) {
        if (this.player.getId().equals(avatar_id)) {
            this.player_points += points;
        } else if (this.bot.getId().equals(avatar_id)) {
            this.bot_points += points;
        }
    }


}
