package kr.co.woobi.imyeon.recyclerviewprofile;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private  ArrayList<MemberDTO> memberDTOS = new ArrayList<>();
    public MyRecyclerViewAdapter() {
        memberDTOS.add(new MemberDTO(R.drawable.americano, "연성희", "오늘은 기분이 좋군~~~"));
        memberDTOS.add(new MemberDTO(R.drawable.capuccino, "황서현", "오늘은 기분이 아주 좋군!!"));
        memberDTOS.add(new MemberDTO(R.drawable.moca, "황재현", "오늘은 기분이 너무나도 좋군!"));
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //xml을 가져오는 부분
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerviewitem,parent,false);
        return new RowCell(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((RowCell)holder).circleImageView.setImageResource(memberDTOS.get(position).image);
        ((RowCell)holder).name.setText(memberDTOS.get(position).name);
        ((RowCell)holder).message.setText(memberDTOS.get(position).message);
        //이미지를 바인딩 하는 부분

    }

    @Override
    public int getItemCount() {
        return memberDTOS.size();
    }
            //소스 절약하는 부분
    private  class RowCell extends RecyclerView.ViewHolder {
        CircleImageView circleImageView;
        TextView name;
        TextView message;
        public RowCell(View view) {
            super(view);
            circleImageView=(CircleImageView)view.findViewById(R.id.profile_image);
            name=(TextView)view.findViewById(R.id.name);
            message=(TextView)view.findViewById(R.id.message);

        }
    }
}
