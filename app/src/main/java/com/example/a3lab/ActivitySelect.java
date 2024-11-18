package com.example.a3lab;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.List;
import db.*;


public class ActivitySelect extends AppCompatActivity {

    private DbContext dbContext;
    private RecyclerView recyclerView;
    private HumanAdapter humanAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activivty_select);

        // Инициализация RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Инициализация базы данных и загрузка данных
        dbContext = new DbContext(this);
        dbContext.OpenDb();  // Открываем базу данных

        // Получаем список людей и устанавливаем адаптер
        List<Human> humans = dbContext.GetHuman();
        humanAdapter = new HumanAdapter(humans);
        recyclerView.setAdapter(humanAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbContext.CloseDb();  // Закрываем базу данных при завершении активности
    }

    public void GoAHub(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
