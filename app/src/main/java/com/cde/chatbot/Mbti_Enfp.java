package com.cde.chatbot;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Mbti_Enfp extends AppCompatActivity {

    TextView chatview_mbti;
    ImageView chatview_img;

    RecyclerView recyclerView;
    EditText editText; //채팅창
    ImageView btn_send; //메세지 보내기 버튼
    ArrayList<Chatsmodal> chatsmodalArrayList;
    ChatAdapter chatAdapter;
    ImageButton btn_back;

    final String USER_KEY = "user";
    final String BOT_KEY = "bot";

    // 뒤로가기 버튼 관리 (2번 누르면 앱 종료)
    public BackHandler backHandler = new BackHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_view);
        recyclerView = findViewById(R.id.chat_recycler2);
        chatview_mbti = findViewById(R.id.chatview_mbti);
        chatview_img = findViewById(R.id.chatview_img);
        chatview_mbti.setText("Enfp");
        chatview_img.setImageResource(R.drawable.enfp_name);
        editText = findViewById(R.id.edt_msg);
        btn_send = findViewById(R.id.btn_send);
        chatsmodalArrayList = new ArrayList<>();
        chatAdapter = new ChatAdapter(chatsmodalArrayList, this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(chatAdapter);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString().isEmpty()) {
                    Toast.makeText(Mbti_Enfp.this, "메세지를 입력하세요", Toast.LENGTH_SHORT).show();
                    return;
                }
                getResponse(editText.getText().toString());
                editText.setText("");
            }
        });
        btn_back = findViewById(R.id.btn_back); //뒤로가기 버튼 클릭시
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogShow();
            }
        });
    }


    private void getResponse(String message) {
        chatsmodalArrayList.add(new Chatsmodal(message, USER_KEY));
        chatAdapter.notifyDataSetChanged();
        String url = "http://api.brainshop.ai/get?bid=170087&key=FLYIryvd7Zdc082V&uid=[uid]&msg=" + message;
        String BASE_URL = "http://api.brainshop.ai/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetroFitApi retroFitApi = retrofit.create(RetroFitApi.class);
        Call<MsgModal> call = retroFitApi.getMessage(url);
        call.enqueue(new Callback<MsgModal>() {
            @Override
            public void onResponse(Call<MsgModal> call, Response<MsgModal> response) {
                if (response.isSuccessful()) {
                    MsgModal msgModal = response.body();
                    chatsmodalArrayList.add(new Chatsmodal(msgModal.getCnt(), BOT_KEY));
                    chatAdapter.notifyDataSetChanged();
                    recyclerView.scrollToPosition(chatsmodalArrayList.size() - 1);
                }
            }

            @Override
            public void onFailure(Call<MsgModal> call, Throwable t) {
                chatsmodalArrayList.add(new Chatsmodal("no response", BOT_KEY));
                chatAdapter.notifyDataSetChanged();
            }
        });
    }
    // 뒤로가기 버튼 설정
    @Override
    public void onBackPressed() {
        backHandler.onBackPressed();
    }

    //커스텀다이얼로그 불러오기
    public void dialogShow(){
        CustomDialog dlg = new CustomDialog(Mbti_Enfp.this);
        dlg.show();
        dlg.setCanceledOnTouchOutside(false);
        dlg.setCancelable(false);
    }


}
