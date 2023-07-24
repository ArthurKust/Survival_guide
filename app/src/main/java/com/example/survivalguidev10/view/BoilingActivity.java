package com.example.survivalguidev10.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.survivalguidev10.R;
import com.example.survivalguidev10.model.Boiling;
import com.example.survivalguidev10.model.Normal;
import com.example.survivalguidev10.modelview.BoilingAdapter;

import java.util.ArrayList;
import java.util.List;

public class BoilingActivity extends AppCompatActivity {

    List<Boiling> BoilingTips = new ArrayList<Boiling>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boiling);

        // инициализируем контейнер
        setInitialData();

        // создадим объект RecyclerView и привяжем к нему соответствующий id
        RecyclerView recyclerView = findViewById(R.id.list_boiling);

        // создадим адаптер и загрузим в него контейнер с данными
        BoilingAdapter adapter = new BoilingAdapter(this, BoilingTips);

        // на recyclerView подадим адаптер
        recyclerView.setAdapter(adapter);
    }

    // метод setInitialData() устанавливает начальный набор данных (а именно изображения из папки res/drawables)
    private void setInitialData() {
        BoilingTips.add( new Boiling("Одежда", "Найдите или сделайте себе головной убор, например, можно даже надеть на голову лопух. Также наденьте лёгкую одежду, закрывающую шею и руки.",R.drawable.boil_cloths));
        BoilingTips.add( new Boiling("Тень и мокрая одежда", "Чтобы избежать прямого контакта с солнцем, оставайтесь в тени. Если у вас есть доступ к достаточному количеству воды, то, надев мокрую футболку, вы будете остывать гораздо быстрее. В ней будет неудобно двигаться и могут появится следы натирания, но сидение в мокрой одежде значительно ускорит процесс охлаждения вашего тела.",R.drawable.boil_shadow));
        BoilingTips.add( new Boiling("Вода", "Обязательно найдите источник пресной воды. Вы всегда должны пить больше воды, чем, по вашему мнению, вам понадобится, и стараться пить регулярно, даже через силу. Лишняя вода в организме предотвратит обычное на жаре сгущение крови, а значит, снизит риск обмороков и тепловых ударов.",R.drawable.boil_water));
        BoilingTips.add( new Boiling("Путешествие ночью", "Если вы оказались в пустыне, то количество воды, необходимое вам в течение дня для осмысленного передвижения, будет больше, чем вы сможете унести пешком. В некоторых пустынях дневная температура может достигать +40 °C, что слишком жарко для пешего путешествия, а ночная температура может опускаться до –4 °C. Вам может показаться, что это очень холодно, и так оно и есть, но после того, как вы пойдете и начнете согреваться, вам будет гораздо комфортнее при –4 °C, чем при +40 °C.",R.drawable.boil_night));
        BoilingTips.add( new Boiling("Еда", "Не ешьте ничего сухого - такая еда быстро вызовет жажду. Хорошим выбором будут ягоды или жареное масо/рыба- в них много влаги.",R.drawable.boil_food));
        BoilingTips.add( new Boiling("Избегайте напряжённой работы", "При физической нагрузке при температуре +35 °C вы можете потерять до 6 раз больше воды через пот, чем при температуре +10 °C. Если вам не нужно этого делать, то просто не делайте, так как дополнительное тепло, полученное при физической нагрузке, будет рассеиваться в течение нескольких часов. Старайтесь больше отдыхать в тени.",R.drawable.boil_rest));
    }
}