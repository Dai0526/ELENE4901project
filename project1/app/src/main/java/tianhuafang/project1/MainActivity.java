package tianhuafang.project1;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


//main UI--entrance for the game

public class MainActivity extends AppCompatActivity {
    private static Button begin_btn;
    private static Button adv_btn;
    Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start_btn_Click();
        adv_btn_Click();


        // bgm start here
        final MediaPlayer mpbgm = MediaPlayer.create(context, R.raw.bgm2);
        mpbgm.setLooping(true);
        mpbgm.start();
    }


    //basic game
    public void start_btn_Click(){
        begin_btn=(Button)findViewById(R.id.start_btn);
        begin_btn.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("tianhuafang.project1.RPS_main");
                        startActivity(intent);
                    }

                }
        );
    }

    //advanced game
    public void adv_btn_Click(){
        adv_btn=(Button)findViewById(R.id.advanced_btn);
        adv_btn.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Intent intent2 = new Intent("tianhuafang.project1.MainActivity");
                        startActivity(intent2);
                    }

                }
        );
    }
}
