package com.example.a3lab;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import db.DbContext;
import db.Human;

public class ActivityAdd extends AppCompatActivity {

    private EditText nameEditText;
    private EditText dateEditText;
    private DbContext dbContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activivty_add);

        // Инициализация полей EditText
        nameEditText = findViewById(R.id.name);
        dateEditText = findViewById(R.id.date);

        // Инициализация DbContext
        dbContext = new DbContext(this);
        dbContext.OpenDb();
    }

    public void GoAHub(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void addUser(View v) {
        // Получение данных из полей ввода
        String fullName = nameEditText.getText().toString().trim();
        String date = dateEditText.getText().toString().trim();

        // Проверка, что поля не пустые
        if (fullName.isEmpty() || date.isEmpty()) {
            Toast.makeText(this, "Заполните все поля", Toast.LENGTH_SHORT).show();
            return;
        }

        // Создание объекта Human и установка данных
        Human human = new Human();
        human.setFull_name(fullName);
        human.setDate(date);

        // Добавление пользователя в базу данных
        dbContext.Add(human);
        Toast.makeText(this, "Пользователь добавлен", Toast.LENGTH_SHORT).show();

        // Очистка полей после добавления
        nameEditText.setText("");
        dateEditText.setText("");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbContext.CloseDb();
    }
}
