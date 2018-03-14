package com.xr.activity.Sms;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.xr.activity.R;

public class SMSActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView lv;
    private String[] strings={"今天的风儿轻柔无比，今天的花儿香飘万里；今天的鸟儿十分欢喜，今天的云儿满载笑意；今天的事" +
            "儿万分顺利，今天的人儿如此甜蜜。所有美...","春天的鲜花，夏天的浪花，秋天的繁华，冬天的雪花，不论何时何地都希望你" +
            "乐开花，朋友，在这阳光明媚的日子，我为你放飞一群祝福，祝你...","我把春风织成一块温暖的毯子送给你，将幸福包住。我把" +
            "春雨编成一条梦幻的丝带送给你，把快乐缠住。我把春天挂满祝福送给你，让美好留住...","茫茫人海相逢是缘分，芸芸众生相知是福气，年年月月相交是情谊。高山流水知音难求，你" +
            "我手足兄弟情深。巴山夜雨，飘洒我的思念。剪烛西...","朋友是读不完的情，写不完的意，是一本看不倦的书，听也听不厌的歌。你我情" +
            "谊，珍藏在梦里，存留在心里。送你一碗长寿面，不咸也不淡，...","我亲爱的朋友，你还好吗？虽然现在我们相隔两地，但我对你的思念并没" +
            "有丝毫减分，祝你在今天这个特殊的日子里，生日快乐，年年有今日，...","看今日的艳阳，那是我为你点亮的烛光；望小鸟的飞翔，那是我为你祝福" +
            "的翅膀；抬头将蓝天仰望，许下生日的愿望，祝你美梦伴着吉祥，绽放..."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        lv = findViewById(R.id.lv);
        lv.setAdapter(new ArrayAdapter<String>(getApplicationContext(),R.layout.item,strings));
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String item = (String) parent.getItemAtPosition(position);
//        Toast.makeText(getApplicationContext(),item,Toast.LENGTH_SHORT).show();
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setType("text/plain");
        intent.putExtra("sms_body",item);
        startActivity(intent);
//        TextView view1 = (TextView) view;
//        String trim = view1.getText().toString().trim();
//        Toast.makeText(getApplicationContext(),trim,Toast.LENGTH_SHORT).show();
    }
}
