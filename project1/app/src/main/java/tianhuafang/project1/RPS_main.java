package tianhuafang.project1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class RPS_main extends AppCompatActivity {
    private ImageView user_choice,pc_choice;
    private ImageButton w_btn,r_btn,s_btn;
    private TextView numRound, numWin,numRate, result;
    private Button set_btn;
    int count=0;
    int win=0;

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
    }

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

    public class MyOnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            int rand = (int) (Math.random()*3+1);
            count++;
            switch (rand){
                case 1:   //rock
                    pc_choice.setImageResource(R.drawable.rock);
                    switch(v.getId()){
                        case R.id.rock_btn:  //rock vs rock
                            user_choice.setImageResource(R.drawable.rock);
                            result.setText("TIED!");
                            numRound.setText(String.valueOf(count));
                            numWin.setText(String.valueOf(win));
                            if(count!=0) {
                                numRate.setText(Math.round(win*100.0/count)+"%");
                            }
                            break;
                        case R.id.wrap_btn:
                            user_choice.setImageResource(R.drawable.paper);
                            win++;
                            result.setText("WIN!");
                            numRound.setText(String.valueOf(count));
                            numWin.setText(String.valueOf(win));
                            if(count!=0) {
                                numRate.setText(Math.round(win*100.0/count)+"%");
                            }
                            break;
                        case R.id.cis_btn:
                            user_choice.setImageResource(R.drawable.scissor);
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
                    pc_choice.setImageResource(R.drawable.paper);
                    switch(v.getId()){
                        case R.id.wrap_btn:  //rock vs rock
                            user_choice.setImageResource(R.drawable.paper);
                            result.setText("TIED!");
                            numRound.setText(String.valueOf(count));
                            numWin.setText(String.valueOf(win));
                            if(count!=0) {
                                numRate.setText(Math.round(win*100.0/count)+"%");
                            }
                            break;
                        case R.id.cis_btn:
                            user_choice.setImageResource(R.drawable.scissor);
                            win++;
                            result.setText("WIN!");
                            numRound.setText(String.valueOf(count));
                            numWin.setText(String.valueOf(win));
                            if(count!=0) {
                                numRate.setText(Math.round(win*100.0/count)+"%");
                            }
                            break;
                        case R.id.rock_btn:
                            user_choice.setImageResource(R.drawable.rock);

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
                    pc_choice.setImageResource(R.drawable.scissor);
                    switch(v.getId()){
                        case R.id.cis_btn:  //rock vs rock
                            user_choice.setImageResource(R.drawable.scissor);
                            result.setText("TIED!");
                            numRound.setText(String.valueOf(count));
                            numWin.setText(String.valueOf(win));
                            if(count!=0) {
                                numRate.setText(Math.round(win*100.0/count)+"%");
                            }
                            break;
                        case R.id.rock_btn:
                            user_choice.setImageResource(R.drawable.rock);
                            win++;
                            result.setText("WIN!");
                            numRound.setText(String.valueOf(count));
                            numWin.setText(String.valueOf(win));
                            if(count!=0) {
                                numRate.setText(Math.round(win*100.0/count)+"%");
                            }
                            break;
                        case R.id.wrap_btn:
                            user_choice.setImageResource(R.drawable.paper);
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
