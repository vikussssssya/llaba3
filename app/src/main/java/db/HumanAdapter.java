package db;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.a3lab.R;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import db.Human;

public class HumanAdapter extends RecyclerView.Adapter<HumanAdapter.HumanViewHolder> {

    private List<Human> humans;

    public HumanAdapter(List<Human> humans) {
        this.humans = humans;
    }

    @NonNull
    @Override
    public HumanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);
        return new HumanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HumanViewHolder holder, int position) {
        Human human = humans.get(position);
        holder.tvFullName.setText(human.getFull_name());
        holder.tvDate.setText(human.getDate());
    }

    @Override
    public int getItemCount() {
        return humans.size();
    }

    static class HumanViewHolder extends RecyclerView.ViewHolder {
        TextView tvFullName, tvDate;

        HumanViewHolder(@NonNull View itemView) {
            super(itemView);
            tvFullName = itemView.findViewById(R.id.tvFullName);
            tvDate = itemView.findViewById(R.id.tvDate);
        }
    }
}

