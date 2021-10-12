package com.example.myapplication.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.activity.UpdateActivity;
import com.example.myapplication.db.SignupDatabase;
import com.example.myapplication.model.UserInputs;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder> {
    //initialize variable
    private final List<UserInputs> dataList;
    private final Activity context;

    public UsersAdapter(List<UserInputs> dataList, Activity context) {
        this.dataList = dataList;
        this.context = context;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UsersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.userslist,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersAdapter.ViewHolder holder, int position) {

        //initialize main data
       UserInputs data = dataList.get(position);
        //initialize database
        SignupDatabase database = SignupDatabase.getDatabase(context);

        holder.Username.setText(data.getName());
        holder.Email.setText(data.getEmail());
        holder.Phone.setText(data.getPhone());
        holder.btnUpdate.setOnClickListener(v -> {
            Intent intent= new Intent(context, UpdateActivity.class);
            intent.putExtra("Username",data.getName());
            intent.putExtra("Email",data.getEmail());
            intent.putExtra("Phone",data.getPhone());
            intent.putExtra("Id",data.getId());
            context.startActivity(intent);
        });
        holder.btnDelete.setOnClickListener(v -> database.loginDoa().delete(data) );

    }

    @Override
    public int getItemCount() {
        if (dataList != null) {
            return dataList.size();
        }
        else return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
      private final TextView Username;
      private final TextView Email;
      private final TextView Phone;
      private final Button btnUpdate;
      private final Button btnDelete;

      public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Username=itemView.findViewById(R.id.tvName);
            Email=itemView.findViewById(R.id.tvEmail);
            Phone=itemView.findViewById(R.id.tvMobile);
            btnUpdate = itemView.findViewById(R.id.btnUpdate);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }
    }
}
