package ir.andriod_stdio.workoutapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class SingleExerciseActivity extends AppCompatActivity  {


    private long timeCountInMilliSeconds = 1 * 60000;

    private enum TimerStatus {
        STARTED,
        STOPPED
    }

    private TimerStatus timerStatus = TimerStatus.STOPPED;

    private ProgressBar progressBarCircle;
    private EditText editTextMinute;
    private TextView textViewTime;
    private TextView textViewTitle;
    private TextView textViewDescription;
    private ImageView imageofExersice;
    private Button buttonViewReset;
    private Button buttonViewStartStop;
    private CountDownTimer countDownTimer;


    private int exerciseTimeDuration ;// duration of exercise for doing exercise


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_exercise);

        // method call to initialize the views
        progressBarCircle = (ProgressBar) findViewById(R.id.progressBarCircle);

        textViewTime = (TextView) findViewById(R.id.textViewTime);
        buttonViewReset = (Button) findViewById(R.id.imageViewReset);
        buttonViewStartStop= (Button) findViewById(R.id.imageViewStartStop);
        textViewTitle = (TextView)findViewById(R.id.singleExerciseTitle);
        textViewDescription = (TextView)findViewById(R.id.singleExerciseDes);
        imageofExersice = (ImageView) findViewById(R.id.singleExerciseImg);
        // get data from exercise Fragment Activity
        Intent intent= getIntent();
        Bundle bundle = intent.getExtras();


        String title =(String) bundle.get("exerciseTitle");
        textViewTitle.setText(title);
        String description =(String) bundle.get("exerciseDescription");
        textViewDescription.setText(description);
        String idofexercise = (String) bundle.get("exerciseId");
        int[] myImageList = new int[]{R.drawable.pic0, R.drawable.pic1,R.drawable.pic2, R.drawable.pic3,R.drawable.pic4, R.drawable.pic5,
                    R.drawable.pic6, R.drawable.pic7,R.drawable.pic8, R.drawable.pic9,R.drawable.pic10, R.drawable.pic11,R.drawable.pic12, R.drawable.pic13};
        imageofExersice.setImageResource(myImageList[Integer.parseInt(idofexercise)]);
        exerciseTimeDuration =Integer.parseInt( (String) bundle.get("exerciseDuration"));

        buttonViewStartStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startStop();
            }
        });

        buttonViewReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
            }
        });



    }


    /**
     * method to reset count down timer
     */
    private void reset() {
        stopCountDownTimer();
        startCountDownTimer();
    }


    /**
     * method to start and stop count down timer
     */
    private void startStop() {
        if (timerStatus == TimerStatus.STOPPED) {

            // call to initialize the timer values
            setTimerValues();
            // call to initialize the progress bar values
            setProgressBarValues();
            // showing the reset icon
            buttonViewReset.setVisibility(View.VISIBLE);
            // changing play icon to stop icon
            buttonViewStartStop.setBackgroundResource(R.drawable.ic_stop_24dp);
            // making edit text not editable
            editTextMinute.setEnabled(false);
            // changing the timer status to started
            timerStatus = TimerStatus.STARTED;
            // call to start the count down timer
            startCountDownTimer();

        } else {

            // hiding the reset icon
            buttonViewReset.setVisibility(View.GONE);
            // changing stop icon to start icon
            buttonViewStartStop.setBackgroundResource(R.drawable.ic_start_24dp);
            // making edit text editable
            editTextMinute.setEnabled(true);
            // changing the timer status to stopped
            timerStatus = TimerStatus.STOPPED;
            stopCountDownTimer();

        }

    }


    private void setTimerValues() {
        timeCountInMilliSeconds = exerciseTimeDuration  * 1000;// 5 sanie// exercise time duratiob be sanie ....
    }

    /**
     * method to start count down timer
     */
    private void startCountDownTimer() {

        countDownTimer = new CountDownTimer(timeCountInMilliSeconds, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                textViewTime.setText(secondTimeFormatter(millisUntilFinished));

                progressBarCircle.setProgress((int) (millisUntilFinished /1000));//progressBarCircle.setProgress((int) (millisUntilFinished / 1000));

            }

            @Override
            public void onFinish() {

                textViewTime.setText(secondTimeFormatter(timeCountInMilliSeconds));
                // call to initialize the progress bar values
                setProgressBarValues();
                // hiding the reset icon
                buttonViewReset.setVisibility(View.GONE);
                // changing stop icon to start icon
                buttonViewStartStop.setBackgroundResource(R.drawable.ic_start_24dp);
                // making edit text editable
                editTextMinute.setEnabled(true);
                // changing the timer status to stopped
                timerStatus = TimerStatus.STOPPED;
            }

        }.start();
        countDownTimer.start();
    }

    /**
     * method to stop count down timer
     */
    private void stopCountDownTimer() {
        countDownTimer.cancel();
    }

    /**
     * method to set circular progress bar values
     */
    private void setProgressBarValues() {

        progressBarCircle.setMax((int) timeCountInMilliSeconds / 1000);
        progressBarCircle.setProgress((int) timeCountInMilliSeconds / 1000);
    }


    /**
     * method to convert millisecond to time format
     *
     * @param milliSeconds
     * @return HH:mm:ss time formatted string
     */
    private String secondTimeFormatter(long milliSeconds) {


        String hms = String.format("%d",

               // TimeUnit.MILLISECONDS.toMinutes(milliSeconds) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(milliSeconds)),
                TimeUnit.MILLISECONDS.toSeconds(milliSeconds)//- TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(milliSeconds)),
             //   TimeUnit.MILLISECONDS.toMillis(milliSeconds) - TimeUnit.SECONDS.toMillis(TimeUnit.MILLISECONDS.toSeconds((milliSeconds)))/100
        );

        return hms;


    }


}