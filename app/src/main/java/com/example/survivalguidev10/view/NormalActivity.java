package com.example.survivalguidev10.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.survivalguidev10.R;
import com.example.survivalguidev10.model.Normal;
import com.example.survivalguidev10.modelview.NormalAdapter;

import java.util.ArrayList;
import java.util.List;

public class NormalActivity extends AppCompatActivity {

    List<Normal> NormalTips = new ArrayList<Normal>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);

        // инициализируем контейнер
        setInitialData();

        // создадим объект RecyclerView и привяжем к нему соответствующий id
        RecyclerView recyclerView = findViewById(R.id.list_normal);

        // создадим адаптер и загрузим в него контейнер с данными
        NormalAdapter adapter = new NormalAdapter(this, NormalTips);

        // на recyclerView подадим адаптер
        recyclerView.setAdapter(adapter);
    }

    // метод setInitialData() устанавливает начальный набор данных (а именно изображения из папки res/drawables)
    private void setInitialData() {
        NormalTips.add( new Normal("Вода", "Постарайтесь скорее найти источник пресной воды, ведь вода - жизнь. Перед употреблением любой воды, кроме бутылированной, прокипятите её.",R.drawable.normal_water));
        NormalTips.add( new Normal("Еда", "В качестве еды можно использовать ягоды и грибы, но ешьте только те виды, в безопасности употребления которых вы уверены. Хорошим источником белков будет рыба или мясо. Перед употреблением мяса/рыбы, пожарьте её.",R.drawable.normal_food));
        NormalTips.add( new Normal("Укрытие", "Укрытие можно сделать горизонтально поставив крепкую палку между двух деревье, а затем под углом укладывая более мелкие на основную. В конце устелите Пол внутри и 'стену' мхом и листьями.",R.drawable.normal_room));
        NormalTips.add( new Normal("Костер", "Чтобы собрать костёр равильно, вертикально 'шалашиком' поставьте 3 средних бревна, а на место их пересечения под углом складывайте более мелкие. Под мелкими ветками для розжига положите сухих листьев или травы. когда прогорят мелкие ветки, положите сверху 1-2 крупных бревна.",R.drawable.normal_fire));
        NormalTips.add( new Normal("Оружие", "Для рыбалки или охоты можно использовать самодельное копьё. Для него достаточно в прочную палку вставить заострённый кременьи подвязать прочными стеблями трав. Также оружие может помочь при самообороне.",R.drawable.normal_fighting));
    }
}