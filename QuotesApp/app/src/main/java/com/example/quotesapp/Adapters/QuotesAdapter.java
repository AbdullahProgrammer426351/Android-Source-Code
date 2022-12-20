package com.example.quotesapp.Adapters;

import static com.example.quotesapp.Utils.Utils.copyTextToClipBoard;
import static com.example.quotesapp.Utils.Utils.imgPaths;
import static com.example.quotesapp.Utils.Utils.shareText;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.widget.TextViewCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.quotesapp.MainActivity;
import com.example.quotesapp.Model.Quotes;
import com.example.quotesapp.QuotesActivity;
import com.example.quotesapp.QuotesListActivity;
import com.example.quotesapp.R;

import java.util.List;

public class QuotesAdapter extends RecyclerView.Adapter<QuotesAdapter.ViewHolder> {
    List<Quotes> list;
    Activity activity;
    String[] pathsArr = imgPaths;

    public QuotesAdapter(List<Quotes> list, Activity activity) {
        this.list = list;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (activity instanceof QuotesActivity)
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.quote_category_item, parent, false));
        else
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.quote_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (activity instanceof QuotesActivity) {

            holder.catNameTv.setText(list.get(position).getQuoteText());
//            Glide.with(activity).load("https://source.unsplash.com/720x600/?" + list.get(position).getQuoteText())
//                    .into(holder.catImg);
            if (position < pathsArr.length)
                Glide.with(activity).load(pathsArr[position])
                        .into(holder.catImg);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                holder.catNameTv.setAutoSizeTextTypeUniformWithConfiguration(
                        1, 17, 1, TypedValue.COMPLEX_UNIT_DIP);
            } else {
                TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(holder.catNameTv, 1, 17, 1,
                        TypedValue.COMPLEX_UNIT_DIP);
            }


            holder.itemView.setOnClickListener(v -> {
                Intent intent = new Intent(activity, QuotesListActivity.class);
                intent.putExtra("Category", list.get(position).getQuoteText());
                activity.startActivity(intent);
            });
        }else{
            holder.quoteTv.setText(list.get(position).getQuoteText());
            holder.authorTv.setText(list.get(position).getQuoteAuthor());
            holder.shareQuoteImg.setOnClickListener(v -> shareText(activity, list.get(position).getQuoteText()));
            holder.copyQuoteImg.setOnClickListener(v -> {
                copyTextToClipBoard(list.get(position).getQuoteText(), activity);
                Toast.makeText(activity, activity.getResources().getString(R.string.copied), Toast.LENGTH_SHORT).show();
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView quoteTv, authorTv;
        ImageView copyQuoteImg, shareQuoteImg;

        // For main category item
        TextView catNameTv;
        ImageView catImg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            quoteTv = itemView.findViewById(R.id.quoteTv);
            authorTv = itemView.findViewById(R.id.authorTv);
            shareQuoteImg = itemView.findViewById(R.id.shareQuoteImg);
            copyQuoteImg = itemView.findViewById(R.id.copyQuoteImg);

            // For main category item
            catImg = itemView.findViewById(R.id.quotesCatImg);
            catNameTv = itemView.findViewById(R.id.quoteCatTv);

        }
    }
}
