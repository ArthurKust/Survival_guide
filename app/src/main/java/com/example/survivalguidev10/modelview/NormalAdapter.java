package com.example.survivalguidev10.modelview;

import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.survivalguidev10.R;
import com.example.survivalguidev10.model.Normal;

import java.util.List;
public class NormalAdapter extends RecyclerView.Adapter<NormalAdapter.ViewHolder>{
    // поля адаптера
    private final LayoutInflater inflater; // поле для трансформации layout-файла во View-элемент
    private final List<Normal> NormalTips; // поле коллекции контейнера для хранения данных (объектов класса Normal)

    // конструктор адаптера
    public NormalAdapter(Context context, List<Normal> NormalTips) {
        this.inflater = LayoutInflater.from(context);
        this.NormalTips = NormalTips;
    }

    @Override
    public NormalAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_layout, parent, false); // трансформация layout-файла во View-элемент
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NormalAdapter.ViewHolder holder, int position) {
        Normal normal = NormalTips.get(position);
        holder.tipView.setImageResource(normal.getTipResource());
        holder.nameView.setText(normal.getName());
        holder.tipDescriptionView.setText(normal.getTipDescription());
    }

    // метод getItemCount() возвращает количество объектов в списке
    @Override
    public int getItemCount() {
        return NormalTips.size();
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
