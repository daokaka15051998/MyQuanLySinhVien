package vn.com.myquanlysinhvien;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class XemDanhSachLopActivity extends AppCompatActivity {
    private ListView lvlop;
    public static List<Lop> dsLop = new ArrayList<>();
    LopDao lopDao;
    LopAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xem_danh_sach_lop);
        lvlop = findViewById(R.id.lvlop);
        registerForContextMenu(lvlop);
        lopDao = new LopDao(XemDanhSachLopActivity.this);
        dsLop = lopDao.getAllLop();
        adapter = new LopAdapter(dsLop, getLayoutInflater(), XemDanhSachLopActivity.this);
        lvlop.setAdapter(adapter);
    }
    @Override
    protected void onResume() {
        super.onResume();
        dsLop.clear();
        dsLop = lopDao.getAllLop();
        adapter.changeDataset(dsLop);
    }
}
