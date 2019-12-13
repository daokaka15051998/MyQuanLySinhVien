package vn.com.myquanlysinhvien;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
public class LopDao {

    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;
    public static final String TABLE_NAME = "Lop";
    public static final String SQL_LOP = "CREATE TABLE Lop(MaLop TEXT primary key, TenLop TEXT)";
    public static final String TAG = "TheLoaiDAO";
    public LopDao(Context context) {
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public int inserLop(Lop theLoai) {
        ContentValues values = new ContentValues();
        values.put("MaLop", theLoai.getMalop());
        values.put("TenLop", theLoai.getTenlop());
        try {
            if (db.insert(TABLE_NAME, null, values) == -1) {
                return -1;
            }
        } catch (Exception ex) {
            Log.e(TAG, ex.toString());
        }
        return 1;
    }

    public List<Lop> getAllLop() {
        List<Lop> dslop = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            Lop ee = new Lop();
            ee.setMalop(c.getString(0));
            ee.setTenlop(c.getString(1));
            dslop.add(ee);
            Log.d("//=====", ee.toString());
            c.moveToNext();
        }
        c.close();
        return dslop;
    }

    //update
    public int updateLop(Lop theLoai) {
        ContentValues values = new ContentValues();
        values.put("MaLop", theLoai.getMalop());
        values.put("TenLop", theLoai.getTenlop());
        int result = db.update(TABLE_NAME, values, "MaLop=?", new String[]{theLoai.getMalop()});
        if (result == 0) {
            return -1;
        }
        return 1;
    }

    //delete
    public int deleteLopByID(String malop) {
        int result = db.delete(TABLE_NAME, "MaLop=?", new String[]{malop});
        if (result == 0) return -1;
        return 1;
    }

    public int updateinfoTheLoai(String malop, String tenlop) {
        ContentValues values = new ContentValues();
        values.put("TenLop", tenlop);
        int result = db.update(TABLE_NAME, values, "MaLop=?", new String[]{malop});
        if (result == 0) {
            return -1;
        }
        return 1;
    }
}
