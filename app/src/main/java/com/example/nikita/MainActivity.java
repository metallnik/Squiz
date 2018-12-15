package com.example.nikita;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button true_button;
    private Button false_button;
    private Button next_button;
    private TextView questionTextView;
    private Button perv_button;


    private Question[] questionBank = new Question[] { new Question(R.string.question_australia, true),
            new Question(R.string.question_oceans, true),
            new Question(R.string.question_mideast, false),
            new Question(R.string.question_africa, false),
            new Question(R.string.question_americas, true),
            new Question(R.string.question_asia, true),
    };

    private int currentIndex = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        true_button = (Button) findViewById(R.id.true_button);
        false_button= (Button) findViewById(R.id.false_button);
        next_button = (Button) findViewById(R.id.next_button);
        questionTextView = (TextView) findViewById(R.id.question_text);
        perv_button = (Button) findViewById(R.id.perv_button);

        updateQuestion();


        true_button.setOnClickListener((v)->{
            checkAnswer(true);
        });

        false_button.setOnClickListener(v->{
            checkAnswer(false);
        });

        next_button.setOnClickListener((v)->{
            currentIndex=(currentIndex+1)%questionBank.length;
            updateQuestion();
        });

        perv_button.setOnClickListener(v->{
            if (currentIndex==0)
                currentIndex=questionBank.length-1;
            else
                currentIndex--;
            updateQuestion();
        });

    }
    public void updateQuestion(){
        int question = questionBank[currentIndex].getTextResId();
        questionTextView.setText(question);
    }

    public void checkAnswer(boolean answer){
        if (answer==questionBank[currentIndex].isAnswerTrue())
            Toast.makeText(this,R.string.correct_toast,Toast.LENGTH_SHORT).show();
        else Toast.makeText(this,R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
    }
}
