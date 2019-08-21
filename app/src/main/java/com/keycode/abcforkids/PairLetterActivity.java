package com.keycode.abcforkids;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.Toast;

import java.util.Random;

public class PairLetterActivity extends AppCompatActivity implements View.OnClickListener {

    private int[] idButton = {R.id.btn00, R.id.btn01, R.id.btn02, R.id.btn03,
                                R.id.btn10, R.id.btn11, R.id.btn12, R.id.btn13,
                                R.id.btn20, R.id.btn21, R.id.btn22, R.id.btn23,
                                R.id.btn30, R.id.btn31, R.id.btn32, R.id.btn33,
                                R.id.btn40, R.id.btn41, R.id.btn42, R.id.btn43};

    private ImageButton[] btn;
    private int[] countAppear;
    private int[] idImgBtnAppear;
    private int[] idDrawable = {R.drawable.im_big_a, R.drawable.im_big_b, R.drawable.im_big_c, R.drawable.im_big_d, R.drawable.im_big_e,
                                R.drawable.im_big_f, R.drawable.im_big_g, R.drawable.im_big_h, R.drawable.im_big_i, R.drawable.im_big_j,
                                R.drawable.im_big_k, R.drawable.im_big_l, R.drawable.im_big_m, R.drawable.im_big_n, R.drawable.im_big_o,
                                R.drawable.im_big_p, R.drawable.im_big_q, R.drawable.im_big_r, R.drawable.im_big_s, R.drawable.im_big_t,
                                R.drawable.im_big_u, R.drawable.im_big_v, R.drawable.im_big_w, R.drawable.im_big_x, R.drawable.im_big_y,
                                R.drawable.im_big_z};

    private int idChosen=0;
    private int btnRest=20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pair_letter);

        init();
    }

    public void init() {

        btnRest=20;

        /// Random Image
        countAppear = new int[25];
        idImgBtnAppear = new int[10];
        Random rd = new Random();
        int letter, temp=0;
        for(int k=0; k<10; k++){
            do{
                letter = rd.nextInt(25);
                countAppear[letter]++;
            }while(countAppear[letter]!=1);
            idImgBtnAppear[k]=letter;
        }

        /// ImageButton
        countAppear = new int[25];
        btn = new ImageButton[20];
        for (int i = 0; i < 20; i++) {
            btn[i] = findViewById(idButton[i]);
            btn[i].setVisibility(View.VISIBLE);
            do{
                temp = rd.nextInt(10);
                countAppear[idImgBtnAppear[temp]]++;
            }while(countAppear[idImgBtnAppear[temp]]>2);
            btn[i].setImageResource(idDrawable[idImgBtnAppear[temp]]);

            // Set On Click
            btn[i].setOnClickListener(this);

        }
    }

    @Override
    public void onClick(View view) {
        if(idChosen==0||idChosen==view.getId()){
            idChosen = view.getId();
            ImageButton btnChosenFirst = findViewById(idChosen);
            btnChosenFirst.setBackgroundColor(Color.GREEN);
        }else{
            ImageButton btnChosenFirst = findViewById(idChosen);
            ImageButton btnChosenSecond = (ImageButton) view;
            if(btnChosenFirst.getImageMatrix().equals(btnChosenSecond.getImageMatrix())){

                // Set Correct Sound
                final MediaPlayer mp = MediaPlayer.create(this, R.raw.correct);
                mp.start();

                // Remove Button
                btnChosenFirst.setBackgroundColor(Color.TRANSPARENT);
                btnChosenSecond.setBackgroundColor(Color.TRANSPARENT);
                btnChosenFirst.setVisibility(View.INVISIBLE);
                btnChosenSecond.setVisibility(View.INVISIBLE);

                // Check end of button
                btnRest-=2;
                if(btnRest==0){
                    final MediaPlayer mpy = MediaPlayer.create(this, R.raw.yay);
                    mpy.start();

                    init();
                }

            }else{

                // Set Wrong Sound
                final MediaPlayer mp = MediaPlayer.create(this, R.raw.wrong);
                mp.start();

                // Disable Chosen
                btnChosenFirst.setBackgroundColor(Color.TRANSPARENT);
            }
            idChosen=0;
        }
    }
}
