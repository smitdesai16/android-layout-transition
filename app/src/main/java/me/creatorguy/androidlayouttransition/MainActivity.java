package me.creatorguy.androidlayouttransition;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.transition.Scene;
import android.transition.Transition;
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
        scene1.enter();
        currentScene = scene1;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.clMain:

                break;
        }
    }
}