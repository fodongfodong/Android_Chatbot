package com.cde.chatbot;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder> {

    // adapter에 들어갈 list 입니다.
    private ArrayList<Data> listData = new ArrayList<>();


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // LayoutInflater를 이용하여 전 단계에서 만들었던 item.xml을 inflate 시킵니다.
        // return 인자는 ViewHolder 입니다.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_eori_item2, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        // Item을 하나, 하나 보여주는(bind 되는) 함수입니다.
        holder.onBind(listData.get(position));


        if(mListener != null){
            final int pos = position;
            holder.itemView.setOnClickListener((new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.onItemClicked(pos);
                    Toast.makeText(view.getContext(), holder.tv_mbti_sel.getText().toString()+"와 대화를 시작합니다",Toast.LENGTH_SHORT).show();

                }
            }));
        }



    }

    @Override
    public int getItemCount() {
        // RecyclerView의 총 개수 입니다.
        return listData.size();
    }

    void addItem(Data data) {
        // 외부에서 item을 추가시킬 함수입니다.
        listData.add(data);
    }

    public interface RecyclerViewClickListener{
        void onItemClicked(int position);
    }

    private RecyclerViewClickListener mListener;

    public void setOnCLickListener(RecyclerViewClickListener listener) {
        this.mListener = listener;
    }

    // RecyclerView의 핵심인 ViewHolder 입니다.
    // 여기서 subView를 setting 해줍니다.
    class ItemViewHolder extends RecyclerView.ViewHolder {

        public TextView tv_mbti_sel;
        public TextView tv_mbti_info;
        public ImageView iv_mbti_sel;

        ItemViewHolder(View itemView) {
            super(itemView);

            tv_mbti_sel = itemView.findViewById(R.id.tv_mbti_sel);
            tv_mbti_info = itemView.findViewById(R.id.tv_mbti_info);
            iv_mbti_sel = itemView.findViewById(R.id.iv_mbti_sel);




        }

        void onBind(Data data) {
            tv_mbti_sel.setText(data.getTitle());
            tv_mbti_info.setText(data.getContent());
            iv_mbti_sel.setImageResource(data.getResId());
        }
    }
}
