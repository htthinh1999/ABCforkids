package com.keycode.abcforkids;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class PronounceActivity extends AppCompatActivity {

    private int[] idChar = {R.id.btnA, R.id.btnB, R.id.btnC, R.id.btnD, R.id.btnE, R.id.btnF, R.id.btnG,
                            R.id.btnH, R.id.btnI, R.id.btnJ, R.id.btnK, R.id.btnL, R.id.btnM, R.id.btnN,
                            R.id.btnO, R.id.btnP, R.id.btnQ, R.id.btnR, R.id.btnS, R.id.btnT, R.id.btnU,
                            R.id.btnV, R.id.btnW, R.id.btnX, R.id.btnY, R.id.btnZ};

    private int[] idSound = {R.raw.big_a, R.raw.big_b, R.raw.big_c, R.raw.big_d, R.raw.big_e, R.raw.big_f, R.raw.big_g, R.raw.big_h,
                            R.raw.big_i, R.raw.big_j, R.raw.big_k, R.raw.big_l, R.raw.big_m, R.raw.big_n, R.raw.big_o, R.raw.big_p,
                            R.raw.big_q, R.raw.big_r, R.raw.big_s, R.raw.big_t, R.raw.big_u, R.raw.big_v, R.raw.big_w, R.raw.big_x,
                            R.raw.big_y, R.raw.big_z};

    private ImageButton[] btnChar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pronouce);
        init();
    }

    public void init(){

        /// ImageButton
        btnChar = new ImageButton[26];
        for(int i=0; i<26; i++){
            btnChar[i] = findViewById(idChar[i]);

            // Set Sound Effect
            final MediaPlayer mp = MediaPlayer.create(this, idSound[i]);

            // Set Animation for button
            final Animation animAlpha = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);

            // Set Click
            btnChar[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    // Start animation
                    view.startAnimation(animAlpha);

                    // Start sound effect
                    mp.start();

                }
            });
        }


    }


}
