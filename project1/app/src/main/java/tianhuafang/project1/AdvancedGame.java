package tianhuafang.project1;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class AdvancedGame extends AppCompatActivity {
    private ImageView user,pc;   // To dispaly user choice and PC's choice
    private ImageButton paper_btn,rock_btn,cis_btn,liz_btn, spo_btn;  // options image button
    private TextView numRound, numWin,numRate, result;  // game stat
    private Button set_btn;  //reset button
    private static Button rule_button;  // go to rule activity
    int count=0;
    int win=0;
    Context context = this;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_game);

        // go to rule_advanced activity to check game ruls
        rule_btn_Click();

        //initialize buttons
        paper_btn = (ImageButton) findViewById(R.id.paper_adv_btn);
        rock_btn = (ImageButton) findViewById(R.id.rock_adv_btn);
        cis_btn = (ImageButton) findViewById(R.id.sic_adv_btn);
        liz_btn = (ImageButton) findViewById(R.id.liz_adv_btn);
        spo_btn = (ImageButton) findViewById(R.id.spo_adv_btn);

        //initialize buttons
        set_btn = (Button) findViewById(R.id.reset_btn);

        //initialize imageView
        user = (ImageView) findViewById(R.id.user);
        pc = (ImageView) findViewById(R.id.pc);

        //intialize result textView
        numRound = (TextView) findViewById(R.id.numRound);
        numWin = (TextView) findViewById(R.id.numWin);
        numRate = (TextView) findViewById(R.id.rate);
        result = (TextView) findViewById(R.id.result_text);

        MyOnClickListener my_click= new MyOnClickListener();

        //set onclick event for the button
        paper_btn.setOnClickListener(my_click);
        rock_btn.setOnClickListener(my_click);
        cis_btn.setOnClickListener(my_click);
        liz_btn.setOnClickListener(my_click);
        spo_btn.setOnClickListener(my_click);

        resetListener reset = new resetListener();
        set_btn.setOnClickListener(reset);


    }

    //rule button
    public void rule_btn_Click(){
        rule_button=(Button)findViewById(R.id.rule_btn);
        rule_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent3 = new Intent("tianhuafang.project1.rule_advanced");
                        startActivity(intent3);
                    }
                }
        );
    }//rule button end



    //reset button on click event
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


    //logic for this game and all sound effects
    public class MyOnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            // for sound effect for each button
            final MediaPlayer mpbr = MediaPlayer.create(context, R.raw.b1);
            final MediaPlayer mpbp = MediaPlayer.create(context, R.raw.b2);
            final MediaPlayer mpbs = MediaPlayer.create(context, R.raw.b3);
            final MediaPlayer mpbl = MediaPlayer.create(context, R.raw.b4);
            final MediaPlayer mpbk = MediaPlayer.create(context, R.raw.b5);

            int rand = (int) (Math.random()*5+1);
            count++;
            switch (rand){
                case 1:   //rock
                    pc.setImageResource(R.drawable.rock);
                    switch(v.getId()){
                        case R.id.rock_adv_btn:  //rock vs rock
                            mpbr.start();
                            user.setImageResource(R.drawable.rock_adv);
                            result.setText("TIED!");
                            numRound.setText(String.valueOf(count));
                            numWin.setText(String.valueOf(win));
                            if(count!=0) {
                                numRate.setText(Math.round(win*100.0/count)+"%");
                            }
                            break;
                        case R.id.paper_adv_btn:
                            mpbp.start();
                            user.setImageResource(R.drawable.paper_adv);
                            win++;
                            result.setText("WIN!");
                            numRound.setText(String.valueOf(count));
                            numWin.setText(String.valueOf(win));
                            if(count!=0) {
                                numRate.setText(Math.round(win*100.0/count)+"%");
                            }
                            break;
                        case R.id.sic_adv_btn:
                            mpbs.start();
                            user.setImageResource(R.drawable.sicssor_adv);
                            result.setText("LOSE!");
                            numRound.setText(String.valueOf(count));
                            numWin.setText(String.valueOf(win));
                            if(count!=0) {
                                numRate.setText(Math.round(win*100.0/count)+"%");
                            }
                            break;
                        case R.id.liz_adv_btn:
                            mpbl.start();
                            user.setImageResource(R.drawable.lizard_adv);
                            result.setText("LOSE!");
                            numRound.setText(String.valueOf(count));
                            numWin.setText(String.valueOf(win));
                            if(count!=0) {
                                numRate.setText(Math.round(win*100.0/count)+"%");
                            }
                            break;
                        case R.id.spo_adv_btn:
                            mpbk.start();
                            user.setImageResource(R.drawable.spock_adv);
                            win++;
                            result.setText("WIN!");
                            numRound.setText(String.valueOf(count));
                            numWin.setText(String.valueOf(win));
                            if(count!=0) {
                                numRate.setText(Math.round(win*100.0/count)+"%");
                            }
                            break;
                    }
                    break;
                case 2:   //paper
                    pc.setImageResource(R.drawable.paper_adv);
                    switch(v.getId()){
                        case R.id.paper_adv_btn:  //paper vs paper tie
                            mpbp.start();
                            user.setImageResource(R.drawable.paper_adv);
                            result.setText("TIED!");
                            numRound.setText(String.valueOf(count));
                            numWin.setText(String.valueOf(win));
                            if(count!=0) {
                                numRate.setText(Math.round(win*100.0/count)+"%");
                            }
                            break;
                        case R.id.sic_adv_btn:  //paper vs sic    user win
                            mpbs.start();
                            user.setImageResource(R.drawable.sicssor_adv);
                            win++;
                            result.setText("WIN!");
                            numRound.setText(String.valueOf(count));
                            numWin.setText(String.valueOf(win));
                            if(count!=0) {
                                numRate.setText(Math.round(win*100.0/count)+"%");
                            }
                            break;
                        case R.id.rock_adv_btn:  //paper vs rock user lost
                            mpbr.start();
                            user.setImageResource(R.drawable.rock_adv);
                            result.setText("LOSE!");
                            numRound.setText(String.valueOf(count));
                            numWin.setText(String.valueOf(win));
                            if(count!=0) {
                                numRate.setText(Math.round(win*100.0/count)+"%");
                            }
                            break;
                        case R.id.liz_adv_btn:  //paper vs liz  user win
                            mpbl.start();
                            user.setImageResource(R.drawable.lizard_adv);
                            win++;
                            result.setText("WIN!");
                            numRound.setText(String.valueOf(count));
                            numWin.setText(String.valueOf(win));
                            if(count!=0) {
                                numRate.setText(Math.round(win*100.0/count)+"%");
                            }
                            break;
                        case R.id.spo_adv_btn: // paper vs spo user lose
                            mpbk.start();
                            user.setImageResource(R.drawable.spock_adv);
                            result.setText("LOSE!");
                            numRound.setText(String.valueOf(count));
                            numWin.setText(String.valueOf(win));
                            if(count!=0) {
                                numRate.setText(Math.round(win*100.0/count)+"%");
                            }
                            break;
                    }
                    break;
                case 3:   //scissor
                    pc.setImageResource(R.drawable.sicssor_adv);
                    switch(v.getId()){
                        case R.id.sic_adv_btn:  //sicssor vs sicssor tie
                            mpbs.start();
                            user.setImageResource(R.drawable.sicssor_adv);
                            result.setText("TIED!");
                            numRound.setText(String.valueOf(count));
                            numWin.setText(String.valueOf(win));
                            if(count!=0) {
                                numRate.setText(Math.round(win*100.0/count)+"%");
                            }
                            break;
                        case R.id.rock_adv_btn:  //sic vs rock    user win
                            mpbr.start();
                            user.setImageResource(R.drawable.rock_adv);
                            win++;
                            result.setText("WIN!");
                            numRound.setText(String.valueOf(count));
                            numWin.setText(String.valueOf(win));
                            if(count!=0) {
                                numRate.setText(Math.round(win*100.0/count)+"%");
                            }
                            break;
                        case R.id.paper_adv_btn:  //sic vs paper user lost
                            mpbp.start();
                            user.setImageResource(R.drawable.paper_adv);
                            result.setText("LOSE!");
                            numRound.setText(String.valueOf(count));
                            numWin.setText(String.valueOf(win));
                            if(count!=0) {
                                numRate.setText(Math.round(win*100.0/count)+"%");
                            }
                            break;
                        case R.id.spo_adv_btn:  //sic vs spo  user win
                            mpbk.start();
                            user.setImageResource(R.drawable.spock_adv);
                            win++;
                            result.setText("WIN!");
                            numRound.setText(String.valueOf(count));
                            numWin.setText(String.valueOf(win));
                            if(count!=0) {
                                numRate.setText(Math.round(win*100.0/count)+"%");
                            }
                            break;
                        case R.id.liz_adv_btn: // paper vs spo user lose
                            mpbl.start();
                            user.setImageResource(R.drawable.lizard_adv);
                            result.setText("LOSE!");
                            numRound.setText(String.valueOf(count));
                            numWin.setText(String.valueOf(win));
                            if(count!=0) {
                                numRate.setText(Math.round(win*100.0/count)+"%");
                            }
                            break;
                    }
                    break;
                case 4:   //spock
                    pc.setImageResource(R.drawable.spock_adv);
                    switch(v.getId()){
                        case R.id.spo_adv_btn:  //spock vs spock tie
                            mpbk.start();
                            user.setImageResource(R.drawable.spock_adv);
                            result.setText("TIED!");
                            numRound.setText(String.valueOf(count));
                            numWin.setText(String.valueOf(win));
                            if(count!=0) {
                                numRate.setText(Math.round(win*100.0/count)+"%");
                            }
                            break;
                        case R.id.liz_adv_btn:  //spock vs liz    user win
                            mpbl.start();
                            user.setImageResource(R.drawable.lizard_adv);
                            win++;
                            result.setText("WIN!");
                            numRound.setText(String.valueOf(count));
                            numWin.setText(String.valueOf(win));
                            if(count!=0) {
                                numRate.setText(Math.round(win*100.0/count)+"%");
                            }
                            break;
                        case R.id.rock_adv_btn:  //spock vs rock user lost
                            mpbr.start();
                            user.setImageResource(R.drawable.rock_adv);
                            result.setText("LOSE!");
                            numRound.setText(String.valueOf(count));
                            numWin.setText(String.valueOf(win));
                            if(count!=0) {
                                numRate.setText(Math.round(win*100.0/count)+"%");
                            }
                            break;
                        case R.id.paper_adv_btn:  //spock vs paper  user win
                            mpbp.start();
                            user.setImageResource(R.drawable.paper_adv);
                            win++;
                            result.setText("WIN!");
                            numRound.setText(String.valueOf(count));
                            numWin.setText(String.valueOf(win));
                            if(count!=0) {
                                numRate.setText(Math.round(win*100.0/count)+"%");
                            }
                            break;
                        case R.id.sic_adv_btn: // spock vs sci user lose
                            mpbs.start();
                            user.setImageResource(R.drawable.sicssor_adv);
                            result.setText("LOSE!");
                            numRound.setText(String.valueOf(count));
                            numWin.setText(String.valueOf(win));
                            if(count!=0) {
                                numRate.setText(Math.round(win*100.0/count)+"%");
                            }
                            break;
                    }
                    break;
                case 5:   //lizard
                    pc.setImageResource(R.drawable.lizard_adv);
                    switch(v.getId()){
                        case R.id.liz_adv_btn:  //liz vs liz tie
                            mpbl.start();
                            user.setImageResource(R.drawable.lizard_adv);
                            result.setText("TIED!");
                            numRound.setText(String.valueOf(count));
                            numWin.setText(String.valueOf(win));
                            if(count!=0) {
                                numRate.setText(Math.round(win*100.0/count)+"%");
                            }
                            break;
                        case R.id.rock_adv_btn:  //lizard vs rock    user win
                            mpbr.start();
                            user.setImageResource(R.drawable.rock_adv);
                            win++;
                            result.setText("WIN!");
                            numRound.setText(String.valueOf(count));
                            numWin.setText(String.valueOf(win));
                            if(count!=0) {
                                numRate.setText(Math.round(win*100.0/count)+"%");
                            }
                            break;
                        case R.id.paper_adv_btn:  //lizard vs paper user lost
                            mpbp.start();
                            user.setImageResource(R.drawable.paper_adv);
                            result.setText("LOSE!");
                            numRound.setText(String.valueOf(count));
                            numWin.setText(String.valueOf(win));
                            if(count!=0) {
                                numRate.setText(Math.round(win*100.0/count)+"%");
                            }
                            break;
                        case R.id.sic_adv_btn:  //lizard vs scissor  user win
                            mpbs.start();
                            user.setImageResource(R.drawable.sicssor_adv);
                            win++;
                            result.setText("WIN!");
                            numRound.setText(String.valueOf(count));
                            numWin.setText(String.valueOf(win));
                            if(count!=0) {
                                numRate.setText(Math.round(win*100.0/count)+"%");
                            }
                            break;
                        case R.id.spo_adv_btn: // lizard vs spo user lose
                            mpbk.start();
                            user.setImageResource(R.drawable.spock_adv);
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
