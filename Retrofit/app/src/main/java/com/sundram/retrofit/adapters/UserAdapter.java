package com.sundram.retrofit.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sundram.retrofit.R;
import com.sundram.retrofit.models.User;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private Context context;
    private List<User> users;

    public UserAdapter(Context context, List<User> users) {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return new ViewHolder(inflater.inflate(R.layout.single_user_item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewHolder holder, int position) {
        holder.user_name.setText(users.get(position).getFirstName());
        holder.user_email.setText(users.get(position).getEmail());
        Glide.with(context).load(users.get(position).getAvatar()).into(holder.user_img);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView user_img;
        private TextView user_name,user_email;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            user_name=itemView.findViewById(R.id.name_tv);
            user_email=itemView.findViewById(R.id.email_tv);
            user_img=itemView.findViewById(R.id.user_img);
        }
    }
}
