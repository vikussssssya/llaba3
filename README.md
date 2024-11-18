# Лабораторная работа №3. Работа с базой данных
**Выполнила**: Бобылева  
**Язык программирования**: Java.

## Инструкция по использованию приложения
Первый экран приложения содержит три кнопки:
1. [Посмотреть записи](#кнопка-посмотреть-записи)
2. [Добавить запись](#кнопка-добавить-запись)
3. [Обновить запись](#кнопка-обновить-запись)
<p align="center">
<img src="https://github.com/vikussssssya/llaba3/blob/main/3.1.png" width="250" height="500"> 
</p>

## Кнопка "Посмотреть записи"
При нажатии открывается второй экран, выводящий информацию из таблицы «Одногруппники» в удобном для восприятия формате.
При запуске приложение:
1. Создает БД, если ее не существует.
```java
 private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_FULL_NAME + " TEXT NOT NULL, " +
                    COLUMN_TIMESTAMP + " TIME DEFAULT CURRENT_TIME" + ");";
```
3. Создает таблицу «Одногруппники», содержащую поля:
- ID;
- ФИО;
- Время добавления записи.
```java
    public static final String TABLE_NAME = "groupmates";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_FULL_NAME = "full_name";
    public static final String COLUMN_TIMESTAMP = "timestamp";
```
5. Удаляет все записи из БД, а затем вносит 5 записей об одногруппниках.
```java
private void initializeData(SQLiteDatabase db) {
        db.execSQL("DELETE FROM " + TABLE_NAME);
        String[] fullNames = {
                "Бобылева Виктория Алексеевна",
                "Сергеев Антон Геннадьевич",
                "Петров Петр Петрович",
                "Соловьева Наталья Андреевна",
                "Цветкова Мария Федоровна"
        };
        for (String name : fullNames) {
            ContentValues values = new ContentValues();
            values.put(COLUMN_FULL_NAME, name);
            db.insert(TABLE_NAME, null, values);
        }
    }
```
<p align="center">
<img src="https://github.com/vikussssssya/llaba3/blob/main/3.2.png" width="250" height="500"> 
 <img src="https://github.com/vikussssssya/llaba3/blob/main/3.3.png" width="250" height="500"> 
</p>

## Кнопка "Добавить запись"
При нажатии вносит еще одну запись в таблицу.
```java
addGroupmateButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SQLiteDatabase db = dbHelper.getWritableDatabase();
                    db.execSQL("INSERT INTO " + DatabaseHelper.TABLE_NAME + " (" +
                            DatabaseHelper.COLUMN_FULL_NAME + ") VALUES ('никитин илья сергеевич');");
                }
            });
```
<p align="center">
<img src="https://github.com/vikussssssya/llaba3/blob/main/3.4.png" width="250" height="500"> 
</p>

## Кнопка "Обновить запись"
При нажатии заменяет ФИО в последней внесенной записи на Иванов Иван Иванович.
```java
updateGroupmateButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SQLiteDatabase db = dbHelper.getWritableDatabase();
                    db.execSQL("UPDATE " + DatabaseHelper.TABLE_NAME +
                            " SET " + DatabaseHelper.COLUMN_FULL_NAME + " = 'Иванов Иван Иванович' " +
                            "WHERE " + DatabaseHelper.COLUMN_ID + " = (SELECT MAX(" + DatabaseHelper.COLUMN_ID + ") FROM " + DatabaseHelper.TABLE_NAME + ");");
                }
            });
```
<p align="center">
<img src="https://github.com/vikussssssya/llaba3/blob/main/3.6.png" width="250" height="500"> 
</p>
