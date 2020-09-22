package ir.andriod_stdio.workoutapp;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.Locale;
public class SingleExerciseActivity extends AppCompatActivity {
    private static final long START_TIME_IN_MILLIS = 6000;
    private TextView mTextViewCountDown;
    private Button mButtonStartPause;
    private Button mButtonReset;
    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;
    private ProgressBar progressBarCircle;


    private EditText editTextMinute;
    private TextView textViewTitle;
    private TextView textViewDescription;
    private ImageView imageofExersice;
    private CountDownTimer countDownTimer;
    private Button btnback ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_single_exercise);
        progressBarCircle = (ProgressBar) findViewById(R.id.progressBarCircle);
        mTextViewCountDown = findViewById(R.id.textViewTime);
        mButtonStartPause = findViewById(R.id.imageViewStartStop);
        mButtonReset = findViewById(R.id.imageViewReset);
        btnback = findViewById(R.id.btnback);

        textViewTitle = (TextView)findViewById(R.id.singleExerciseTitle);
        textViewDescription = (TextView)findViewById(R.id.singleExerciseDes);
        imageofExersice = (ImageView) findViewById(R.id.singleExerciseImg);
        // get data from exercise Fragment Activity
        Intent intent= getIntent();
        Bundle bundle = intent.getExtras();



        String title =(String) bundle.get("exerciseTitle");
        textViewTitle.setText(title);
        String description =(String) bundle.get("exerciseDescription");
        textViewDescription.setText("نحوه انجام : "+description);
        String idofexercise = (String) bundle.get("exerciseId");
        int[] myImageList = new int[]{R.drawable.pic0, R.drawable.pic1,R.drawable.pic2, R.drawable.pic3,R.drawable.pic4, R.drawable.pic5,
                R.drawable.pic6, R.drawable.pic7,R.drawable.pic8, R.drawable.pic9,R.drawable.pic10, R.drawable.pic11,R.drawable.pic12, R.drawable.pic13};
        imageofExersice.setImageResource(myImageList[Integer.parseInt(idofexercise)]);
       // exerciseTimeDuration =Integer.parseInt( (String) bundle.get("exerciseDuration"));

        mButtonStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTimerRunning) {
                    pauseTimer();
                } else {
                    startTimer();
                }
            }
        });
        mButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });
        updateCountDownText();
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }
    private void startTimer() {
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
                setProgressBarValues();
            }
            @Override
            public void onFinish() {
                mTimerRunning = false;
               // mButtonStartPause.setText("Start");
                mButtonStartPause.setVisibility(View.INVISIBLE);
                mButtonReset.setVisibility(View.VISIBLE);
                progressBarCircle.setMax(6);
                progressBarCircle.setProgress(6);
            }
        }.start();
        mTimerRunning = true;
        mButtonStartPause.setBackgroundResource(R.drawable.ic_stop_24dp);
        mButtonReset.setVisibility(View.INVISIBLE);
    }
    private void pauseTimer() {
        mCountDownTimer.cancel();
        mTimerRunning = false;
       mButtonStartPause.setBackgroundResource(R.drawable.ic_start_24dp);
        mButtonReset.setVisibility(View.VISIBLE);
    }
    private void resetTimer() {
        mTimeLeftInMillis = START_TIME_IN_MILLIS;
        updateCountDownText();
        mButtonReset.setVisibility(View.INVISIBLE);
        mButtonStartPause.setVisibility(View.VISIBLE);
        mButtonStartPause.setBackgroundResource(R.drawable.ic_start_24dp);
    }
    private void updateCountDownText() {
      //  int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60 -1;
        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d", seconds);
        mTextViewCountDown.setText(timeLeftFormatted);
    }
    private void setProgressBarValues() {

        progressBarCircle.setMax(6);
        Log.d("timmmmmmmmmmmmmmmmme",(int)mTimeLeftInMillis + "fdns");
        progressBarCircle.setProgress((int) mTimeLeftInMillis / 1000 -1);
    }

}