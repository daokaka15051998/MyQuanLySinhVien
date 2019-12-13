package vn.com.myquanlysinhvien;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import vn.com.myquanlysinhvien.Lop;
import vn.com.myquanlysinhvien.QuanLyStudentHelper;

import static vn.com.myquanlysinhvien.QuanLyStudentHelper.COL_DATE_STUDENT;
import static vn.com.myquanlysinhvien.QuanLyStudentHelper.COL_NAME_STUDENT;
import static vn.com.myquanlysinhvien.QuanLyStudentHelper.TABLE_NAME_STUDENT;

public class StudentDao {

    private QuanLyStudentHelper quanLyStudentHelper;

     StudentDao(Context context) {
        quanLyStudentHelper = new QuanLyStudentHelper(context);
    }

    public long insert(Lop lopAndSutdent) {
        //B1 sin quen
        SQLiteDatabase sqLiteDatabase = quanLyStudentHelper.getWritableDatabase();
        //B2
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_NAME_STUDENT, lopAndSutdent.name);
        contentValues.put(COL_DATE_STUDENT, lopAndSutdent.date);
        //b3
        long resutl = sqLiteDatabase.insert(TABLE_NAME_STUDENT, null, contentValues);
        // b4 ket thuc ket noi
        sqLiteDatabase.close();
        return resutl;
    }

    public List<Lop> getALL() {

        List<Lop> lopAndSutdentList = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = quanLyStudentHelper.getReadableDatabase();

        String SELECT = "SELECT * FROM " + TABLE_NAME_STUDENT;

        Cursor cursor = sqLiteDatabase.rawQuery(SELECT, null);

        if (cursor.moveToFirst()) {
            do {
                Lop lopAndSutdent = new Lop();

                lopAndSutdent.name = cursor.getString(cursor.getColumnIndex(COL_NAME_STUDENT));
                lopAndSutdent.date = cursor.getString(cursor.getColumnIndex(COL_DATE_STUDENT));

                lopAndSutdentList.add(lopAndSutdent);

            } while (cursor.moveToNext());

            cursor.close();
        }
        sqLiteDatabase.close();
        return lopAndSutdentList;
    }

    public long update(Lop lopAndSutdent) {

        SQLiteDatabase sqLiteDatabase = quanLyStudentHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();


        contentValues.put(COL_NAME_STUDENT, lopAndSutdent.name);
        contentValues.put(COL_DATE_STUDENT, lopAndSutdent.date);

        long resutl = sqLiteDatabase.update(TABLE_NAME_STUDENT, contentValues, COL_NAME_STUDENT + "=?", new String[]{lopAndSutdent.name});

        sqLiteDatabase.close();
        return resutl;

    }

    public long delete(Lop lopAndSutdent) {

        SQLiteDatabase sqLiteDatabase = quanLyStudentHelper.getWritableDatabase();


        long resutl = sqLiteDatabase.delete(TABLE_NAME_STUDENT, COL_NAME_STUDENT + "=?", new String[]{lopAndSutdent.name});

        sqLiteDatabase.close();
        return resutl;
    }
}
