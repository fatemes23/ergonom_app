package ir.andriod_stdio.workoutapp;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import android.widget.TextView;

import java.util.List;


public class ExerciseAdaptor extends RecyclerView.Adapter<ExerciseAdaptor.ExerciseViewHolder> {

    List<OneExercise> exercises;
    FragmentActivity mainActivity;

    public ExerciseAdaptor(List<OneExercise> exercises, FragmentActivity mainActivity) {
        this.exercises = exercises;
        this.mainActivity = mainActivity;
    }

    @Override
    public ExerciseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_one_exercise, viewGroup, false);
        ExerciseViewHolder evh = new ExerciseViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(final ExerciseViewHolder viewHolder, final int i) {

        //viewHolder.icon.setImageResource(todoList.get(i).iconRsc);
        OneExercise exercise = exercises.get(i);
        viewHolder.title.setText(exercise.getExerciseTile());
        viewHolder.body.setText(exercise.getExersiceExplanation());
        String nameOfPic = exercise.getExercisePicture();
        int[] myImageList = new int[]{R.drawable.pic0, R.drawable.pic1,R.drawable.pic2, R.drawable.pic3,R.drawable.pic4, R.drawable.pic5,
                R.drawable.pic6, R.drawable.pic7,R.drawable.pic8, R.drawable.pic9,R.drawable.pic10, R.drawable.pic11,R.drawable.pic12, R.drawable.pic13};
        int index = exercise.getExerciseid();
      viewHolder.img.setImageResource(myImageList[index]);

    }

    @Override
    public int getItemCount() {
        return exercises.size();
    }

    public static class ExerciseViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView img;
        TextView body;

        ExerciseViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.exercise_title);
            img = (ImageView) itemView.findViewById(R.id.excercise_img) ;
            body = (TextView) itemView.findViewById(R.id.exercise_body);
        }
    }
}