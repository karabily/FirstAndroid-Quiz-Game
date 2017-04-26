package mobile.karasoft.ma.whereiswho;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.*;
import android.widget.EditText;

import mobile.karasoft.ma.whereiswho.activities.FirstScreenGame;
import mobile.karasoft.ma.whereiswho.testio.WriteJavaClass;

import static android.provider.AlarmClock.EXTRA_MESSAGE;
//import static mobile.karasoft.ma.whereiswho.R.id.startButton;

public class MainActivity extends AppCompatActivity {


    // Animation object for each type
    Animation animTranslate;
    Animation animAlpha;
    Animation animScale;
    Animation animRotate;

    // Button that ll be animate
    Button translateButton;
    Button alphaButton;
    Button rotateButton;
    Button scaleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        b = (Button) findViewById(R.id.startButton);
//        b.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, FirstScreenGame.class);
//
//                startActivity(intent);
//            }
//        });
//

        //Create the animations

        animTranslate = AnimationUtils.loadAnimation(this, R.anim.anim_translate);
        animAlpha = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
        animScale = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
        animRotate = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);

        //Create Buttons

        translateButton = (Button) findViewById(R.id.translate);
        alphaButton = (Button) findViewById(R.id.alpha);
        rotateButton = (Button) findViewById(R.id.rotate);
        scaleButton = (Button) findViewById(R.id.scale);

        // Put the Listener on the buttons




        translateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                v.startAnimation(animTranslate);

                Intent intent = new Intent(MainActivity.this, FirstScreenGame.class);


                //String data =  String.valueOf(R.drawable.image1);
                String data ="1";

                intent.putExtra("keyOfNextImage",data);

                //System.out.println(R.drawable.image1);
                startActivity(intent);
            }});

        alphaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                v.startAnimation(animAlpha);
                Intent intent = new Intent(MainActivity.this, WriteJavaClass.class);



                //String data =  String.valueOf(R.drawable.image1);

                int data =1;
                intent.putExtra("keyOfNextImage",data);
                //System.out.println(R.drawable.image1);
                startActivity(intent);
                finish();

            }});



        rotateButton.setOnClickListener(new View.OnClickListener()

            {
                @Override
                public void onClick (final View v){
                v.startAnimation(animRotate);
            }
            });
        scaleButton.setOnClickListener(new View.OnClickListener()

            {
                @Override
                public void onClick (View v){
                v.startAnimation(animScale);
            }
            });


        }


    }
