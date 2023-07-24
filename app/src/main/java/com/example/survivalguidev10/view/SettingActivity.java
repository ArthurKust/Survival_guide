package com.example.survivalguidev10.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.survivalguidev10.R;

public class SettingActivity extends AppCompatActivity {

    // создание полей
    public Button buttonSetting; // поле кнопки обработки данных
    public EditText editCity; // поле выбора города
    public SharedPreferences settings; // поле настроек приложения
    public SharedPreferences.Editor editor; // поле для добавления новых данных в настройки
    public Intent intent; // поле намерения переключения активностей
    public final String APP_WEATHER = "Weather"; // константа названия настроек
    public final String CITY = "City"; // константа названия переменной города

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        // присваивание id полям
        buttonSetting = findViewById(R.id.buttonSetting);
        editCity = findViewById(R.id.editCity);

        // создание объекта работы с настройками приложения
        settings = getSharedPreferences(APP_WEATHER, MODE_PRIVATE);

        // обработка нажатия кнопки
        buttonSetting.setOnClickListener(listener);
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            // Считывание вводимого значения города
            String nameCity = editCity.getText().toString();

            // если пользователь ничего не ввёл, то остаёмся в этой же активности
            if (nameCity.equals("")) {
                // сообщение пользователю об отсутствии введённого города
                Toast toast = Toast.makeText(getApplicationContext(), "Вы не ввели название населённого пункта", Toast.LENGTH_SHORT);
                toast.show();
            } else { // иначе сохраняем (пересохраняем) эти данные и переключаемся в активность прогноза погоды
                // запись новой настройки
                editor = settings.edit(); // создание объекта для доступа к изменению настроек
                editor.putString(CITY, nameCity); // запись настроек
                editor.apply(); // сохранение настроек

                // переключение на активность просмотра погоды
                intent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(intent);
            }
        }
    };
}