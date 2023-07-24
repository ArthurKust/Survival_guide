package com.example.survivalguidev10.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.survivalguidev10.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class SecondActivity extends AppCompatActivity implements Runnable{

    private ImageButton imageButtonFrozing;
    private ImageButton imageButtonNormal;
    private ImageButton imageButtonBoiling;
    private ImageButton imageButtonSettings;
    private final String URL_SERVER = "https://api.openweathermap.org/data/2.5/weather?q="; // url сервера
    private final String KEY = "&appid=30b472266bc2b57810d569d5fcb86e14"; // ключ доступа к сервисам сервера (получается при регистрации на https://openweathermap.org)
    private final String EXTRA_OPTIONS = "&units=metric&lang=ru"; // настройки поиска на русском языке
    private String request; // url для запросов на сервер
    private String response; // ответ с сервера в виде JSON
    private HttpsURLConnection connection; // поле интернет соединения
    private Handler handler; // создание обработчика событий
    private JSONObject jsonObject; // создание поля JSON объекта
    private String choiceCity; // поле названия населённого пункта
    private SharedPreferences settings; // поле настроек приложения
    private final String APP_WEATHER = "Weather"; // константа названия настроек
    private final String CITY = "City"; // константа названия переменной города

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // присваивание id полям
        imageButtonFrozing = findViewById(R.id.imageButtonFrozing);
        imageButtonNormal = findViewById(R.id.imageButtonNormal);
        imageButtonBoiling = findViewById(R.id.imageButtonBoiling);
        imageButtonSettings = findViewById(R.id.imageButtonSettings);

        // обработка нажатия кнопок
        imageButtonFrozing.setOnClickListener(listener);
        imageButtonNormal.setOnClickListener(listener);
        imageButtonBoiling.setOnClickListener(listener);
        imageButtonSettings.setOnClickListener(listener);

        // создание объекта работы с настройками приложения
        settings = getSharedPreferences(APP_WEATHER, MODE_PRIVATE);
        // считывание настроек выбранного города, данной переменной назначается NoCity если данной настройки нет
        choiceCity = settings.getString(CITY, "NoCity");

        handler = new Handler(); // создание объекта обработчика сообщений
        new Thread(this).start(); }


    // метод дополнительного потока для интернет соединения и определения погоды в заданном населённом пункте
    @Override
    public void run() {
        // определение url для запросов на сервер
        request = URL_SERVER + choiceCity + KEY + EXTRA_OPTIONS;
        // запрос на сервер
        try {
            URL url = new URL(request); // создание url ссылки для запроса на сервер
            connection = (HttpsURLConnection) url.openConnection(); // открытие соединения с сервером
            connection.connect(); // соединение с сервером

            InputStream stream = connection.getInputStream(); // Считывание данных из потока ответа сервера
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream)); // Запись данных и выделение памяти

            StringBuffer buffer = new StringBuffer(); // Запись данных и выделение памяти
            String line = ""; // По умолчанию пустая строка

            while ((line = reader.readLine()) != null) // Постройное считывание текста
                buffer.append(line).append("\n");
            response = buffer.toString(); // текстовый ответ с сервера

            jsonObject = new JSONObject(response); // создание JSON объекта по ответу с сервера

            // задание на обработчик сообщений обновление TextView с температурой
            handler.post(new Runnable() {
                @Override
                public void run() {
                    // вывод данных с JSON файла
                    try {
                        if (jsonObject.getJSONObject("main").getDouble("temp") <= 10) {
                            Toast toast = Toast.makeText(getApplicationContext(), "Вы в холодном климате!", Toast.LENGTH_SHORT);
                            toast.show();
                        } else if (jsonObject.getJSONObject("main").getDouble("temp") > 10 && jsonObject.getJSONObject("main").getDouble("temp") < 27) {
                            Toast toast = Toast.makeText(getApplicationContext(), "Вы в теплом климате!", Toast.LENGTH_SHORT);
                            toast.show();
                        } else if (jsonObject.getJSONObject("main").getDouble("temp") >= 27) {
                            Toast toast = Toast.makeText(getApplicationContext(), "Вы в жарком климате!", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                    } catch (JSONException e) { // исключение отсутствия JSON объекта
                        e.printStackTrace();
                    }
                }
            });


        } catch (MalformedURLException e) { // исключение на случай отсутствия ссылки request
            e.printStackTrace();
        } catch (IOException e) { // исключение на случай отсутствия соединения
            e.printStackTrace();
        } catch (JSONException e) { // исключение отсутствия JSON объекта
            e.printStackTrace();
        }
    }


    // создание слушателя
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()) {
                case R.id.imageButtonFrozing:
                    Intent intentFrozing = new Intent(getApplicationContext(), FreezingActivity.class);
                    intentFrozing.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    startActivity(intentFrozing);
                    break;
                case R.id.imageButtonNormal:
                    Intent intentNormal = new Intent(getApplicationContext(), NormalActivity.class);
                    intentNormal.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    startActivity(intentNormal);
                    break;
                case R.id.imageButtonBoiling:
                    Intent intentBoiling = new Intent(getApplicationContext(), BoilingActivity.class);
                    intentBoiling.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    startActivity(intentBoiling);
                    break;
                case R.id.imageButtonSettings:
                    Intent intentSetting = new Intent(getApplicationContext(), SettingActivity.class);
                    intentSetting.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    startActivity(intentSetting);
                    break;
            }
        }
    };
}