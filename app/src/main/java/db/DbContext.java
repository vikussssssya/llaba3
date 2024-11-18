package db;

import android.content.ContentValues;
import android.content.Context;
import android.database.ContentObservable;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DbContext {
    private Context context;
    private MyDbHelper myDbHelper;
    private SQLiteDatabase db;

    public DbContext(Context context){
        this.context = context;
        myDbHelper = new MyDbHelper(context);
    }




    public void OpenDb(){
        db = myDbHelper.getReadableDatabase();
    }

    public void CloseDb(){
        myDbHelper.close();
    }

    public void Add(Human human){
        ContentValues cv = new ContentValues();
        cv.put(MyConst.FULL_NAME,human.getFull_name());
        cv.put(MyConst.DATE,human.getDate());
        db.insert(MyConst.TABLE_NAME,null,cv);
    }

    public List<Human> GetHuman(){
        List<Human> humans = new ArrayList<>();
        Cursor cursor = db.query(MyConst.TABLE_NAME,null,null,null
                ,null,null,null);

        while(cursor.moveToNext()){
            Human human = new Human();
            human.setId(cursor.getString(0));
            human.setFull_name(cursor.getString(1));
            human.setDate(cursor.getString(2));
            humans.add(human);
        }
        cursor.close();
        return humans;
    }

    public void UpdateLastHuman(){
        String selection = MyConst.ID +"= (SELECT MAX(" + MyConst.ID + ") " +
                "FROM " + MyConst.TABLE_NAME + ")";
        ContentValues cv = new ContentValues();
        cv.put(MyConst.FULL_NAME,"ИВАНОВ ИВАН ИВАНОВИЧ");
        db.update(MyConst.TABLE_NAME,cv,selection,null);
    }

}
