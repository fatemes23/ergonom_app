package ir.andriod_stdio.workoutapp;

public class OneExercise {
    String exerciseTile ;
    String exersiceExplanation;
    String exerciseDuration;
    String exercisePicture;
    int    exerciseType;
    int    exerciseid;

    public OneExercise(int id ,String exerciseTile, String exersiceExplanation, String exerciseDuration, String exercisePicture , int exerciseType) {
        this.exerciseid=id;
        this.exerciseTile = exerciseTile;
        this.exersiceExplanation = exersiceExplanation;
        this.exerciseDuration = exerciseDuration;
        this.exercisePicture = exercisePicture;
        this.exerciseType = exerciseType;//1 : stand , 0 : sit
    }

    public int getExerciseType() {
        return exerciseType;
    }

    public int getExerciseid() {
        return exerciseid;
    }

    public String getExerciseTile() {
        return exerciseTile;
    }

    public void setExerciseTile(String exerciseTile) {
        this.exerciseTile = exerciseTile;
    }

    public String getExersiceExplanation() {
        return exersiceExplanation;
    }

    public void setExersiceExplanation(String exersiceExplanation) {
        this.exersiceExplanation = exersiceExplanation;
    }

    public String getExerciseDuration() {
        return exerciseDuration;
    }

    public void setExerciseDuration(String exerciseDuration) {
        this.exerciseDuration = exerciseDuration;
    }

    public String getExercisePicture() {
        return exercisePicture;
    }

    public void setExercisePicture(String exercisePicture) {
        this.exercisePicture = exercisePicture;
    }
}
