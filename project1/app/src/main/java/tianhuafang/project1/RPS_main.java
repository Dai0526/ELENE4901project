package tianhuafang.project1;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class RPS_main extends AppCompatActivity {

    // declare variable for the main program
    private ImageView user_choice,pc_choice;
    private ImageButton w_btn,r_btn,s_btn;
    private TextView numRound, numWin,numRate, result;
    private Button set_btn;
    int count=0;
    int win=0;

    // declare varable for the cheat button
    int rand;
    int cheat = 0;       //flag for cheating mode, 0 is off, 1 is on
    private Button c_btn;


    // declare context for the mediaplayer
    Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rps_main);

        //initialize buttons
        w_btn = (ImageButton) findViewById(R.id.wrap_btn);
        r_btn = (ImageButton) findViewById(R.id.rock_btn);
        s_btn = (ImageButton) findViewById(R.id.cis_btn);

        //initialize buttons
        set_btn = (Button) findViewById(R.id.reset_btn);

        //initialize imageView
        user_choice = (ImageView) findViewById(R.id.player_choice);
        pc_choice = (ImageView) findViewById(R.id.pc_choice);

        //intialize result textView
        numRound = (TextView) findViewById(R.id.round_result_txt);
        numWin = (TextView) findViewById(R.id.win_result_txt);
        numRate = (TextView) findViewById(R.id.rate_result_txt);
        result = (TextView) findViewById(R.id.result_txt);

        MyOnClickListener my_click= new MyOnClickListener();
        r_btn.setOnClickListener(my_click);
        w_btn.setOnClickListener(my_click);
        s_btn.setOnClickListener(my_click);

        resetListener reset = new resetListener();
        set_btn.setOnClickListener(reset);

        // initialize cheat button
        c_btn = (Button) findViewById(R.id.cheat_btn);
        cheatListener cheattime = new cheatListener();
        c_btn.setOnClickListener(cheattime);

        // bgm
        final MediaPlayer mpbgm = MediaPlayer.create(context, R.raw.bgm2);
        mpbgm.setLooping(true);
        mpbgm.start();
    }


    // cheating mode turn on click
    private class cheatListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            //sound
            final MediaPlayer mpcheat = MediaPlayer.create(context, R.raw.cheat);
            mpcheat.start();

            rand = (int) (Math.random()*3+1); // take the rand number and it will be passed to game
            cheat = 1;   // set flag to 1 -- on

            switch (rand){
                case 1:
                    pc_choice.setImageResource(R.drawable.elephant);
                    break;
                case 2:
                    pc_choice.setImageResource(R.drawable.rat);
                    break;
                case 3:
                    pc_choice.setImageResource(R.drawable.cat);
                    break;

            }
            result.setText("CHEAT");
            user_choice.setImageResource(R.drawable.question);
        }
    }

    //reset button
    private class resetListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            count=0;
            win=0;
            result.setText("RESULT");
            numRound.setText(String.valueOf(count));
            numWin.setText(String.valueOf(win));
            numRate.setText(0+"%");

        }
    }

    //game logic--> modified from the tutorial--> rock is elephant, mouse is paper, cat is scissor
    public class MyOnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            // for sound effect
            final MediaPlayer mpele = MediaPlayer.create(context, R.raw.ele);
            final MediaPlayer mpmou = MediaPlayer.create(context, R.raw.mou);
            final MediaPlayer mpcat = MediaPlayer.create(context, R.raw.cat);

            if(cheat == 0){
                rand = (int) (Math.random()*3+1);
            }
            cheat = 0;

            count++;
            switch (rand){
                case 1:   //rock
                    pc_choice.setImageResource(R.drawable.elephant);
                    switch(v.getId()){
                        case R.id.rock_btn:  //rock vs rock
                            mpele.start();
                            user_choice.setImageResource(R.drawable.elephant);
                            result.setText("TIED!");
                            numRound.setText(String.valueOf(count));
                            numWin.setText(String.valueOf(win));
                            if(count!=0) {
                                numRate.setText(Math.round(win*100.0/count)+"%");
                            }
                            break;
                        case R.id.wrap_btn:
                            mpmou.start();
                            user_choice.setImageResource(R.drawable.rat);
                            win++;
                            result.setText("WIN!");
                            numRound.setText(String.valueOf(count));
                            numWin.setText(String.valueOf(win));
                            if(count!=0) {
                                numRate.setText(Math.round(win*100.0/count)+"%");
                            }
                            break;
                        case R.id.cis_btn:
                            mpcat.start();
                            user_choice.setImageResource(R.drawable.cat);
                            result.setText("LOSE!");
                            numRound.setText(String.valueOf(count));
                            numWin.setText(String.valueOf(win));
                            if(count!=0) {
                                numRate.setText(Math.round(win*100.0/count)+"%");
                            }
                            break;
                    }
                    break;
                case 2:
                    pc_choice.setImageResource(R.drawable.rat);
                    switch(v.getId()){
                        case R.id.wrap_btn:  //rock vs rock
                            mpmou.start();
                            user_choice.setImageResource(R.drawable.rat);
                            result.setText("TIED!");
                            numRound.setText(String.valueOf(count));
                            numWin.setText(String.valueOf(win));
                            if(count!=0) {
                                numRate.setText(Math.round(win*100.0/count)+"%");
                            }
                            break;
                        case R.id.cis_btn:
                            mpcat.start();
                            user_choice.setImageResource(R.drawable.cat);
                            win++;
                            result.setText("WIN!");
                            numRound.setText(String.valueOf(count));
                            numWin.setText(String.valueOf(win));
                            if(count!=0) {
                                numRate.setText(Math.round(win*100.0/count)+"%");
                            }
                            break;
                        case R.id.rock_btn:
                            mpele.start();
                            user_choice.setImageResource(R.drawable.elephant);

                            result.setText("LOSE!");
                            numRound.setText(String.valueOf(count));
                            numWin.setText(String.valueOf(win));
                            if(count!=0) {
                                numRate.setText(Math.round(win*100.0/count)+"%");
                            }
                            break;
                    }
                    break;
                case 3:
                    pc_choice.setImageResource(R.drawable.cat);
                    switch(v.getId()){
                        case R.id.cis_btn:  //scissor
                            mpcat.start();
                            user_choice.setImageResource(R.drawable.cat);
                            result.setText("TIED!");
                            numRound.setText(String.valueOf(count));
                            numWin.setText(String.valueOf(win));
                            if(count!=0) {
                                numRate.setText(Math.round(win*100.0/count)+"%");
                            }
                            break;
                        case R.id.rock_btn:
                            mpele.start();
                            user_choice.setImageResource(R.drawable.elephant);
                            win++;
                            result.setText("WIN!");
                            numRound.setText(String.valueOf(count));
                            numWin.setText(String.valueOf(win));
                            if(count!=0) {
                                numRate.setText(Math.round(win*100.0/count)+"%");
                            }
                            break;
                        case R.id.wrap_btn:
                            mpmou.start();
                            user_choice.setImageResource(R.drawable.rat);
                            result.setText("LOSE!");
                            numRound.setText(String.valueOf(count));
                            numWin.setText(String.valueOf(win));
                            if(count!=0) {
                                numRate.setText(Math.round(win*100.0/count)+"%");
                            }
                            break;
                    }
                    break;
            }//rand end

        }//Onclick end
    }//listener end
}
