package com.ashu.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity{

    private TextView TVQuestion,TVQuestionAlphabet;
    private Button OptionAButton,OptionBButton,OptionCButton,OptionDButton;

    private ArrayList<Quizmodule> quizmoduleArrayList;

    //Random is a class in java which helps to access the Data from
    // arrayList that is why i am using it so
    // it simply creates the integer with maximum limit
    // and with that we can access the data from our current arraylist

    Random random;

    int score = 0;
    int attempted = 0;
    int currentPosition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TVQuestion = findViewById(R.id.idTVQuestion);
        TVQuestionAlphabet = findViewById(R.id.idTVQuestionsSelected);
        OptionAButton = findViewById(R.id.idBtnOptionA);
        OptionBButton = findViewById(R.id.idBtnOptionB);
        OptionCButton = findViewById(R.id.idBtnOptionC);
        OptionDButton =findViewById(R.id.idBtnOptionD);

        quizmoduleArrayList =new ArrayList<>();
        random = new Random();

        getQuestion(quizmoduleArrayList);

        currentPosition = random.nextInt(quizmoduleArrayList.size());
        SetDataToViews(currentPosition);

        OptionAButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizmoduleArrayList.get(currentPosition).getAnswer().trim().toLowerCase().equals(OptionAButton.getText().toString().trim().toLowerCase()))
                {
                    score++;
                }
                attempted++;
                currentPosition = random.nextInt(quizmoduleArrayList.size());
                SetDataToViews(currentPosition);
            }
        });        OptionBButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizmoduleArrayList.get(currentPosition).getAnswer().trim().toLowerCase().equals(OptionBButton.getText().toString().trim().toLowerCase()))
                {
                    score++;
                }
                attempted++;
                currentPosition = random.nextInt(quizmoduleArrayList.size());
                SetDataToViews(currentPosition);
            }
        });



        OptionCButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizmoduleArrayList.get(currentPosition).getAnswer().trim().toLowerCase().equals(OptionCButton.getText().toString().trim().toLowerCase()))
                {
                    score++;
                }
                attempted++;
                currentPosition = random.nextInt(quizmoduleArrayList.size());
                SetDataToViews(currentPosition);
            }
        });

        OptionDButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizmoduleArrayList.get(currentPosition).getAnswer().trim().toLowerCase().equals(OptionDButton.getText().toString().trim().toLowerCase()))
                {
                    score++;
                }
                attempted++;
                currentPosition = random.nextInt(quizmoduleArrayList.size());
                SetDataToViews(currentPosition);
            }
        });


    }

    private void showBottomSheet()
    {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_b_sheet,(LinearLayout)findViewById(R.id.idLLScore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.idTVScore);
        Button restartQuizBtn = bottomSheetView.findViewById(R.id.idBtnRestart);
        scoreTV.setText("your score is \n"+score+"/5");
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPosition= random.nextInt(quizmoduleArrayList.size());
                SetDataToViews(currentPosition);
                score=0;
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }

    private void SetDataToViews(int currentPosition)
    {
        if(attempted == 10)
        {
            showBottomSheet();
        }
        else {
            TVQuestionAlphabet.setText("Question attempted:  " + attempted + "/5");
            TVQuestion.setText(quizmoduleArrayList.get(currentPosition).getQuestion());

            OptionAButton.setText(quizmoduleArrayList.get(currentPosition).getOptionA());
            OptionBButton.setText(quizmoduleArrayList.get(currentPosition).getOptionB());
            OptionCButton.setText(quizmoduleArrayList.get(currentPosition).getOptionC());
            OptionDButton.setText(quizmoduleArrayList.get(currentPosition).getOptionD());

        }
    }
    private void getQuestion(ArrayList<Quizmodule> quizmoduleArrayList)
    {
        quizmoduleArrayList.add(new Quizmodule("Where is Kohinoor","India","China","USA","UK","UK"));
        quizmoduleArrayList.add(new Quizmodule("Who is father of India","Narendra Modi","Sardar Patel","Mahatma Gandhi","rahul gandhi","Mahatma Gandhi"));
        quizmoduleArrayList.add(new Quizmodule("When first battle of panipat was fought","1561","1569","1759","1761","1561"));
        quizmoduleArrayList.add(new Quizmodule("Who is NSA of India","G D Bakshi","Ajit Doval","Bipin Rawat","Jai shankar","Ajit Doval"));
    }


}