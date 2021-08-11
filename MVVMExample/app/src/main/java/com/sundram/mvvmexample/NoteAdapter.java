package com.sundram.mvvmexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {

    private List<Note> noteList=new ArrayList<>();

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item_view,parent,false);
        return new NoteHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        Note note=noteList.get(position);
        holder.title_tv.setText(note.getTitle());
        holder.desc_tv.setText(note.getDescription());
        holder.priority_tv.setText(String.valueOf(note.getPriority()));
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    public void setNotes(List<Note> notes){
        this.noteList=notes;
        notifyDataSetChanged();
    }

    public class NoteHolder extends RecyclerView.ViewHolder {
        private TextView title_tv,desc_tv,priority_tv;
        public NoteHolder(@NonNull View itemView) {
            super(itemView);
            title_tv=itemView.findViewById(R.id.title_tv);
            desc_tv=itemView.findViewById(R.id.desc_tv);
            priority_tv=itemView.findViewById(R.id.priority_tv);
        }
    }
}
