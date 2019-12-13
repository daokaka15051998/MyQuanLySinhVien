package vn.com.myquanlysinhvien;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class QuanLyStudentHelper extends SQLiteOpenHelper {
    final String CREATE_TABLE = "CREATE TABLE Student (name TEXT PRIMARY KEY, lop TEXT,date Text)";
    public static final String TABLE_NAME_STUDENT = "Student";

    public static final String COL_NAME_STUDENT = "name";
    public static final String COL_DATE_STUDENT = "date";

    public QuanLyStudentHelper(Context context) {
        super(context, "Student", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
