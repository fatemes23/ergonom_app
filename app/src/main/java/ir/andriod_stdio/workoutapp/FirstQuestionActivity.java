package ir.andriod_stdio.workoutapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class FirstQuestionActivity extends AppCompatActivity {

    CheckBox standingcb, sittingcb;
    TextView hinttv;
    Button nextbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_first);
        standingcb = (CheckBox) findViewById(R.id.checkbox1_inq1activity);
        sittingcb = (CheckBox) findViewById(R.id.checkbox2inq1activity);
        nextbtn = (Button) findViewById(R.id.btn_next_inq1activity);
        hinttv = (TextView) findViewById(R.id.hinttv1q1);
        ArrayList typeofjob = new ArrayList();//1 standing //0 sitting
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
