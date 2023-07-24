package com.example.survivalguidev10.modelview;

import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.survivalguidev10.R;
import com.example.survivalguidev10.model.Freezing;

import java.util.List;
public class FreezingAdapter extends RecyclerView.Adapter<FreezingAdapter.ViewHolder>{
    // поля адаптера
    private final LayoutInflater inflater; // поле для трансформации layout-файла во View-элемент
    private final List<Freezing> FreezingTips; // поле коллекции контейнера для хранения данных (объектов класса Freezing)

    // конструктор адаптера
    public FreezingAdapter(Context context, List<Freezing> FreezingTips) {
        this.inflater = LayoutInflater.from(context);
        this.FreezingTips = FreezingTips;
    }

    @Override
    public FreezingAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_layout, parent, false); // трансформация layout-файла во View-элемент
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FreezingAdapter.ViewHolder holder, int position) {
        Freezing freezing = FreezingTips.get(position);
        holder.tipView.setImageResource(freezing.getTipResource());
        holder.nameView.setText(freezing.getName());
        holder.tipDescriptionView.setText(freezing.getTipDescription());
    }

    // метод getItemCount() возвращает количество объектов в списке
    @Override
    public int getItemCount() {
        return FreezingTips.size();
    }

    // созданный статический класс ViewHolder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // неизменяемые поля представления
        final ImageView tipView;
        final TextView nameView, tipDescriptionView;

        // конструктор класса ViewHolder с помощью которого мы связываем поля и представление list_item.xml
        ViewHolder(View view) {
            super(view);
            tipView = view.findViewById(R.id.tipResource);
            nameView = view.findViewById(R.id.name);
            tipDescriptionView = view.findViewById(R.id.tipDescription);
        }
    }
}
