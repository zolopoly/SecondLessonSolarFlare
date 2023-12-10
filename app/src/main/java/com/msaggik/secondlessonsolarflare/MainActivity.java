package com.msaggik.secondlessonsolarflare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Наши планеты
        Planet mars = new Planet("Марс", 20, 60, 14);
        Planet jupiter = new Planet("Юпитер", 42, 70, 1250);
        Planet saturn = new Planet("Сатурн", 85, 85, 883);

        //Наш суперкомпьютер
        Computer blueGene = new Computer("IBM Blue Gene", 3);

        //Создаем нашего вычислителя и добавляем в него компьютер, планеты
        ComputationFlareManager compute = new ComputationFlareManager.Builder()
                .setComputer(blueGene)
                .setPlanets(mars, jupiter, saturn)
                .build();

        // привязка поля к разметке
        // окно вывода на экран смартфона решения задачи
        TextView output = findViewById(R.id.output);

        // вывод данных на экран смартфона
        output.setText(String.valueOf(compute.getCoreTime()));
        output.append(" секунд");
    }

}