package vn.com.myquanlysinhvien;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btthem;
    private Button btxem;
    private Button btql;

    LopDao lopDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btthem = (Button) findViewById(R.id.btthem);
        btxem = (Button) findViewById(R.id.btxem);
        btql = (Button) findViewById(R.id.btql);


        btthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog();
            }
        });

        btxem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, XemDanhSachLopActivity.class);
                startActivity(intent);
            }
        });

        btql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, QuanLyAcityvity.class);
                startActivity(intent);
            }
        });


    }

    public void Dialog() {

        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setTitle("Thêm mới lớp");
        //dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_them_lop);
        final EditText editmalop = dialog.findViewById(R.id.editmalop);
        final EditText edittenlop = dialog.findViewById(R.id.edittenlop);
        Button xoa = dialog.findViewById(R.id.btxoatranglop);
        Button luu = dialog.findViewById(R.id.btthemlop);


        //Button lưu
        luu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenlop = edittenlop.getText().toString();
                String malop = editmalop.getText().toString();
                lopDao = new LopDao(MainActivity.this);
                Lop lop = new Lop(malop, tenlop);

                if (malop.equals("") || tenlop.equals("")) {
                    Toast.makeText(MainActivity.this,
                            "Bạn chưa nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    if (lopDao.inserLop(lop) > 0) {
                        Toast.makeText(MainActivity.this, "Thêm Thành công", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    } else {
                        Toast.makeText(MainActivity.this, "Thêm thất bại", Toast.LENGTH_SHORT).show();
                    }
                }



            }
        });

        // Button Xóa
        xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editmalop.setText("");
                edittenlop.setText("");

            }
        });
        dialog.show();
    }
    }

