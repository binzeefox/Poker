package com.example.tongxiwen.poker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.example.tongxiwen.poker.basic.Poker;
import com.example.tongxiwen.poker.basic.PokerBox;
import com.example.tongxiwen.poker.basic.PokerUtil;

public class MainActivity extends AppCompatActivity {
    private PokerBox box = new PokerBox();
    private TextView moniter;
    private TextView moniter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        moniter = (TextView) findViewById(R.id.moniter);
        moniter2 = (TextView) findViewById(R.id.moniter2);
        moniter.setText("请抽卡");
        moniter2.setText("剩余卡数：" + box.remainCards());

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fresh();
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                box = new PokerBox();
                moniter.setText("请抽卡");
                moniter2.setText("剩余卡数：" + box.remainCards());
            }
        });
    }

    private void fresh() {
        if (box.remainCards() != 0) {
            moniter.setText(box.popCard().toString());
        } else {
            moniter.setText("卡组已空");
        }
        moniter2.setText("剩余卡数：" + box.remainCards());
    }
}
