package com.example.survivalguidev10.modelview;

import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.survivalguidev10.R;
import com.example.survivalguidev10.model.Boiling;

import java.util.List;
public class BoilingAdapter extends RecyclerView.Adapter<BoilingAdapter.ViewHolder>{
    // поля адаптера
    private final LayoutInflater inflater; // поле для трансформации layout-файла во View-элемент
    private final List<Boiling> BoilingTips; // поле коллекции контейнера для хранения данных (объектов класса Boiling)

    // конструктор адаптера
    public BoilingAdapter(Context context, List<Boiling> BoilingTips) {
        this.inflater = LayoutInflater.from(context);
        this.BoilingTips = BoilingTips;
    }

    @Override
    public BoilingAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_layout, parent, false); // трансформация layout-файла во View-элемент
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BoilingAdapter.ViewHolder holder, int position) {
        Boiling boiling = BoilingTips.get(position);
        holder.tipView.setImageResource(boiling.getTipResource());
        holder.nameView.setText(boiling.getName());
        holder.tipDescriptionView.setText(boiling.getTipDescription());
    }

    // метод getItemCount() возвращает количество объектов в списке
    @Override
    public int getItemCount() {
        return BoilingTips.size();
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
