package me.creatorguy.androidlayouttransition;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Scene scene1;
    Scene scene2;
    Scene currentScene;
    Transition transition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout clMain = findViewById(R.id.clMain);
        clMain.setOnClickListener(this);

        ViewGroup sceneRoot = findViewById(R.id.sceneRoot);
        scene1 = Scene.getSceneForLayout(sceneRoot, R.layout.scene1, this);
        scene2 = Scene.getSceneForLayout(sceneRoot, R.layout.scene2, this);

        transition = TransitionInflater.from(this).inflateTransition(R.transition.example_2);

        scene1.enter();
        currentScene = scene1;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.clMain:
                if(currentScene == scene1) {
                    TransitionManager.go(scene2, transition);
                    currentScene = scene2;
                } else {
                    TransitionManager.go(scene1, transition);
                    currentScene = scene1;
                }
                break;
        }
    }
}