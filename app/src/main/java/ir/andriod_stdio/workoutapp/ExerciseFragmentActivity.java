package ir.andriod_stdio.workoutapp;


import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.sql.Time;
import java.util.ArrayList;

@SuppressWarnings("unchecked")
public  class ExerciseFragmentActivity extends Fragment implements ExerciseItemClickLIstener  {

    static ArrayList<OneExercise> exersices;

    static RecyclerView recyclerView;
    static ExerciseAdaptor exerciseAdaptor;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_exercise_fragment,container,false);

        exersices = new ArrayList<OneExercise>();
        recyclerView =(RecyclerView) view.findViewById(R.id.exercise_list);

         //exersices=dataBase.getTodayasTasks("  " ,nameOfDay);

        setExercisesArrayToshow(2);//0: sit , 1 : stand , 2 : both  ;
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);
        exerciseAdaptor = new ExerciseAdaptor(exersices,this.getActivity());
        recyclerView.setAdapter(exerciseAdaptor);
        exerciseAdaptor.setClickListener(this);

//        //devider for recycle view
//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
//                layoutManager.getOrientation());
//        recyclerView.addItemDecoration(dividerItemDecoration);

        ///_____swipe controlle
//        SwipController swipeController = new SwipController(taskAdapter);
//        ItemTouchHelper itemTouchhelper = new ItemTouchHelper(swipeController);
//        itemTouchhelper.attachToRecyclerView(recyclerView);



        return  view;
    }

    //stand true , sitting false
    public  ArrayList setAllExerciseOfApp(){
        ArrayList allExercise = new ArrayList();
        //0
        OneExercise oneExercise = new OneExercise(0,"chin tuck" , "در این حرکت سر و گردن در راستای ستون فقرات قرار میگیرد یه عبارتی فرد غبغب میگیرد و چانه را به قفسه سینه نزدیک میکند،پنج ثانیه نگه داشته و پنج مرتبه انجام میدهد.","5","pic0",0);
        allExercise.add(oneExercise);
        //1
        oneExercise = new OneExercise(1,"flexion,extension" , "سر را تا انتهای رنج به عقب برده ،پنج شماره نگه دارید و پنج مرتبه تکرار کنید سپس سر را به سمت جلو تا انتهای رنج خم کرده و پنج شماره نگه داشته و پنج مرتبه تکرار کنید.","5","pic1",0);
        allExercise.add(oneExercise);
        //2
        oneExercise = new OneExercise(2,"side flexion" , "سر را تا انتهای رنج به سمت راست خم کرده و پنج شماره نگه داشته و پنج مرتبه تکرار کنید،همین کار را برای سمت چپ نیز انحام دهید.","5","pic2",0);
        allExercise.add(oneExercise);
        //3
        oneExercise = new OneExercise(3,"Shoulder shrug" , "در حالی که دستها صاف کنار بدن قرار دارد شانه ها را بالا برده پنج شماره نگه دارید و پنج مرتبه انجام دهید","5","pic3",0);
        allExercise.add(oneExercise);
        //4
        oneExercise = new OneExercise(4,"shoulder and thorasic extension" , "در حالی که با ستون فقرات صاف ایستاده یا نشسته اید دستها را از عقب قلاب کرده و از کمر جدا کنید،پنج شماره نگه دارید و پنج مرنبه تکرار کنید.","5","pic4",0);
        allExercise.add(oneExercise);
        //5
        oneExercise = new OneExercise(5,"wrist and shoulder stretching" , "دست ها را قلاب کرده طوری که پشت دست رو به روی شما باشد،سپس کاملا دستها را از شانه کشیده و پنج شماره نگه دارید و پنج مرتبه انجام دهید","5","pic5",0);
        allExercise.add(oneExercise);
        //6
        oneExercise = new OneExercise(6,"wrist extension" , "کف دست ها را بهم بزنید و در حالی که آرنج و مچ زاویه نود درجه دارند محکم دست ها را به یکدیگر فشار دهید پنج شماره نگه دارید و پنج مرتبه انجام دهید","5","pic6",0);
        allExercise.add(oneExercise);
        //8
        oneExercise = new OneExercise(7,"upper body side bending" , "درحالی که دست ها قلاب شده و کشیده بالای سر میباشد و ستون فقرات صاف است تا انتهای رنج به یک سمت خم شوید و پنج شماره نگه دارید و پنج مرتبه انجام دهید و همین تعداد را برای سمت مقابل نیز اجرا کنید.","5","pic7",0);
        allExercise.add(oneExercise);
        //9
        oneExercise = new OneExercise(8,"upper body rotation" , "در حالی که ستون فقرات صاف و کشیده میباشد پای چپ را روی پای راست بیندازید و تنه را تا انتهای رنج به سمت چپ بچرخانید پنج شماره نگه دارید و پنج مرتبه انجام دهید و برای سمت مقابل هم به همین شکل انجام دهید.","5","pic8",0);
        allExercise.add(oneExercise);
        //10
        oneExercise = new OneExercise(9,"back extension" , "دست را روی گودی کمر قرار داده و به سمت عقب خم شوید،پنج شماره نگه داشته و پنج مرتبه تکرار کنید","5","pic9",1);
        allExercise.add(oneExercise);
        //11
        oneExercise = new OneExercise(10,"quadreceps stretching" , "در حالی که ستون فقرات صاف میباشد از پشت مچ پا را گرفته و به سمت عقب ببرید به طوری که جلوی ران احساس کشیدگی داشته باشید \n" +
                "پنج شماره نگه داشته و پنج مرتبه برای هر پا تکرار کنید.","5","pic10",1);
        allExercise.add(oneExercise);
        oneExercise = new OneExercise(11,"hamstring stretching" , "در حالی که پای خود را روی سکو و یا صندلی گذاشته اید، تنه را به سمت جلو خم کنید به طوری که پشت ران احساس کشیدگی داشته باشید پنج شماره نگه دارید و پنج مرتبه برای هر پا تکرار کنید","5","pic11",1);
        allExercise.add(oneExercise);
        oneExercise = new OneExercise(12,"squat" , "در حالی که ستون فقرات صاف میباشد دست را به جایی مثل پشتی صندلی گرفته و زانوها را تا حداکثر نود درجه خم کنید پنج شماره نگه داشته و پنج مرتبه انجام دهید.","5","pic12",1);
        allExercise.add(oneExercise);
        oneExercise = new OneExercise(13,"lunge" , "یک پا را عقب گذاشته و زانوها راخم کنید،توجه داشته باشید که پایی که در عقب قرار گرفته به زمین نزدیک میشود اما روی زمین قرار نمیگیرد، پنج شماره نگه دارید و پنج مرتبه انجام دهید،سپس جای پاها عوض شده و همین تعداد را تکرار کنید.","5","pic13",1);
        allExercise.add(oneExercise);


        return allExercise;
    }
    public void setExercisesArrayToshow(int standingOrSitting){
        ArrayList allEcercise =setAllExerciseOfApp();
        if ( standingOrSitting==0 ){
            for ( int i=0 ; i< allEcercise.size(); i++){
                if ( ( (OneExercise)allEcercise.get(i)).getExerciseType()==0 ){
                    exersices.add((OneExercise) allEcercise.get(i));
                }
            }
        }else if (standingOrSitting==1 ){
            for ( int i=0 ; i< allEcercise.size(); i++){
                if ( ( (OneExercise)allEcercise.get(i)).getExerciseType()==0 ){
                    exersices.add((OneExercise) allEcercise.get(i));
                }
            }
        }else{
            for ( int i=0 ; i< allEcercise.size(); i++){//both standing and sitting
                exersices.add((OneExercise) allEcercise.get(i));
            }
        }

    }


    @Override
    public void onClick(View v, int position) {
        final OneExercise oneExercise = exersices.get(position);
        Intent i = new Intent(getContext(), TimerDownCount.class);
        i.putExtra("exerciseTitle", oneExercise.getExerciseTile());
        i.putExtra("exerciseDescription", oneExercise.getExersiceExplanation());
        i.putExtra("exerciseId", Integer.toString(oneExercise.getExerciseid()));
        i.putExtra("exerciseDuration", oneExercise.getExerciseDuration());
        startActivity(i);
    }
}