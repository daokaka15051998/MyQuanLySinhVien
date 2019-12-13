package vn.com.myquanlysinhvien;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;

public class QuanLyAcityvity extends AppCompatActivity {
    private Spinner spinner;
    private StudentAdapter studentAdapter;
    private LopAdapter lopAdapter;
    private QuanLyStudentHelper quanLyStudentHelper;
    private StudentDao studentDao;
    private EditText edtNameSV, edtDate;
    private ListView lvSV;
    private SpinerAdapter spinerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_acityvity);
        spinner = findViewById(R.id.spinner);
        edtNameSV = findViewById(R.id.editten);
        edtDate = findViewById(R.id.editngaysinh);
        lvSV = findViewById(R.id.listview);

        studentDao = new StudentDao(QuanLyAcityvity.this);
        final List<Lop> lopAndSutdentList = studentDao.getALL();
        spinerAdapter = new SpinerAdapter(this, lopAndSutdentList);

        spinner.setAdapter(spinerAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(QuanLyAcityvity.this, lopAndSutdentList.get(position).name, LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void Open(View view) {

        String name = edtNameSV.getText().toString().trim();
        String date = edtDate.getText().toString().trim();

        if (name.equals("")) {

            Toast.makeText(this, "Vui long nhap Name", Toast.LENGTH_SHORT).show();
        } else if (date.equals("")) {

            Toast.makeText(this, "Vui long nhap Date", Toast.LENGTH_SHORT).show();
        } else {

            Lop lopAndSutdent = new Lop();
            lopAndSutdent.name = name;
            lopAndSutdent.date = date;

            long result = studentDao.insert(lopAndSutdent);

            if (result > 0) {
                Toast.makeText(this, "Thanh Cong", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this, "Khong Thanh Cong!", Toast.LENGTH_SHORT).show();

            }

            List<Lop> lopAndSutdentList = studentDao.getALL();

            studentAdapter = new StudentAdapter(this, lopAndSutdentList);
            lvSV.setAdapter(studentAdapter);
        }
    }


}

