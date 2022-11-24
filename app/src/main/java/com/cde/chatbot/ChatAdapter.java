package com.cde.chatbot;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter {

    ArrayList<Chatsmodal> chatsmodalArrayList;
    Context context;

    public ChatAdapter(ArrayList<Chatsmodal> chatsmodalArrayList, Context context) {
        this.chatsmodalArrayList = chatsmodalArrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case 0:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);
                return new userViewHolder(view);
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chatbot_item, parent, false);
                return new botViewHolder(view);

        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Chatsmodal chatsmodal = chatsmodalArrayList.get(position);
        switch (chatsmodalArrayList.get(position).getSender()) {
            case "user":
                ((userViewHolder)holder).userMsg.setText(chatsmodal.getMessage());
                break;
            case "bot":
                ((botViewHolder)holder).botMsg.setText(chatsmodal.getMessage());
                break;

        }

    }

    @Override
    public int getItemCount() {

       return chatsmodalArrayList.size();
    }

    @Override
    public int getItemViewType(int position) {
        switch (chatsmodalArrayList.get(position).getSender()){
            case "user" :
                return 0;
            case "bot" :
                return 1;
            default:return -1;
        }
    }

    public static class userViewHolder extends RecyclerView.ViewHolder {
        TextView userMsg;

        public userViewHolder(@NonNull View itemView) {
            super(itemView);
            userMsg = itemView.findViewById(R.id.userMsg);
        }
    }

    public static class botViewHolder extends RecyclerView.ViewHolder {
            TextView botMsg;
            TextView botMBTI;


        public botViewHolder(@NonNull View itemView) {
            super(itemView);
            botMsg = itemView.findViewById(R.id.botMsg);
            botMBTI = itemView.findViewById(R.id.botMBTI);
        }
    }
}