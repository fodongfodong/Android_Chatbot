package com.cde.chatbot;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerAdapter.RecyclerViewClickListener{

    private com.cde.chatbot.RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chatroom_list);

        init();

        getData();

        adapter.setOnCLickListener(this);

    }

    private void init() {
        RecyclerView recyclerView = findViewById(R.id.recyceler_view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new com.cde.chatbot.RecyclerAdapter();
        recyclerView.setAdapter(adapter);
    }

    private void getData() {
        // 임의의 데이터입니다.
        List<String> listTitle = Arrays.asList("ISTJ", "ISFJ", "INFJ","INTJ",
                                                "ISTP","ISFP","INFP","INTP",
                                                "ESTP","ESFP","ENFP","ENTP",
                                                "ESTJ","ESFJ","ENFJ","ENTJ");
        List<String> listContent = Arrays.asList(
                "세상의 소금형",  
                "임금 뒷편의 권력형",
                "예언자형",
                "과학자형",
                "백과사전형",
                "성인군자형",
                "잔다르크형",
                "아이디어 뱅크형",
                "수완좋은 활동가형",
                "사교적인 유형",
                "스파크형",
                "발명가형",
                "사업가형",
                "친선도모형",
                "언변능숙형",
                "지도자형"
        );
        List<Integer> listResId = Arrays.asList(
                R.drawable.istj,
                R.drawable.isfj,
                R.drawable.infj,
                R.drawable.intj,
                R.drawable.istp,
                R.drawable.isfp,
                R.drawable.infp,
                R.drawable.intp,
                R.drawable.estp,
                R.drawable.esfp,
                R.drawable.enfp,
                R.drawable.entp,
                R.drawable.estj,
                R.drawable.esfj,
                R.drawable.enfj,
                R.drawable.entj
        );
        for (int i = 0; i < listTitle.size(); i++) {
            // 각 List의 값들을 data 객체에 set 해줍니다.
            Data data = new Data();
            data.setTitle(listTitle.get(i));
            data.setContent(listContent.get(i));
            data.setResId(listResId.get(i));

            // 각 값이 들어간 data를 adapter에 추가합니다.
            adapter.addItem(data);
        }

        // adapter의 값이 변경되었다는 것을 알려줍니다.
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClicked(int position) {
        if(position == 0) {
            Intent chat1 = new Intent(MainActivity.this, Mbti_Istj.class);
            startActivity(chat1);
        }
        else if(position == 1) {
            Intent chat2 = new Intent(MainActivity.this, Mbti_Isfj.class);
            startActivity(chat2);
        }
        else if(position == 2) {
            Intent chat3 = new Intent(MainActivity.this, Mbti_Infj.class);
            startActivity(chat3);
        }
        else if(position == 3) {
            Intent chat4 = new Intent(MainActivity.this, Mbti_Intj.class);
            startActivity(chat4);
        }
        else if(position == 4) {
            Intent chat5 = new Intent(MainActivity.this, Mbti_Istp.class);
            startActivity(chat5);
        }
        else if(position == 5) {
            Intent chat6 = new Intent(MainActivity.this, Mbti_Isfp.class);
            startActivity(chat6);
        }

        else if(position == 6) {
            Intent chat7 = new Intent(MainActivity.this, Mbti_Infp.class);
            startActivity(chat7);
        }
        else if(position == 7) {
            Intent chat8 = new Intent(MainActivity.this, Mbti_Intp.class);
            startActivity(chat8);
        }
        else if(position == 8) {
            Intent chat9 = new Intent(MainActivity.this, Mbti_Estp.class);
            startActivity(chat9);
        }
        else if(position == 9) {
            Intent chat10 = new Intent(MainActivity.this, Mbti_Esfp.class);
            startActivity(chat10);
        }
        else if(position == 10) {
            Intent chat11 = new Intent(MainActivity.this, Mbti_Enfp.class);
            startActivity(chat11);
        }
        else if(position == 11) {
            Intent chat12 = new Intent(MainActivity.this, Mbti_Entp.class);
            startActivity(chat12);
        }
        else if(position == 12) {
            Intent chat13 = new Intent(MainActivity.this, Mbti_Estj.class);
            startActivity(chat13);
        }
        else if(position == 13) {
            Intent chat14 = new Intent(MainActivity.this, Mbti_Esfj.class);
            startActivity(chat14);
        }
        else if(position == 14) {
            Intent chat15 = new Intent(MainActivity.this, Mbti_Enfj.class);
            startActivity(chat15);
        }
        else if(position == 15) {
            Intent chat16 = new Intent(MainActivity.this, Mbti_Entj.class);
            startActivity(chat16);
        }

    }
}