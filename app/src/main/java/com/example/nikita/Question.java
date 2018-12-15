package com.example.nikita;

public class Question {
    private int textResId;
    private boolean answerTrue;

    public Question(int textResId, boolean answerTrue) {
        this.textResId = textResId;
        this.answerTrue = answerTrue;
    }

    public void setTextResId(int textResId) {
        this.textResId = textResId;
    }

    public void setAnswerTrue(boolean answerTrue) {
        this.answerTrue = answerTrue;
    }

    public int getTextResId() {

        return textResId;
    }

    public boolean isAnswerTrue() {
        return answerTrue;
    }
}
