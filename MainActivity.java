package com.example.ngoduchiep_qlsp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText edtmasp, edttensp, edtloaisp, edtsoluong,edtdongia;
    Button btnThem, btnSua, btnXoa, btnThoat;
    ListView lvsp;
    SPAdapter adapter;
    List<SanPham> listSP;
    int index = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //B2: Ánh xạ
        anhxa();
        listSP = new ArrayList<>();

        setAdapter();
        //bắt sự kiện cho các button
        // Nút Thêm
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //lấy dl từ các ô edittext
                String masp = edtmasp.getText().toString();
                String tensp = edttensp.getText().toString();
                String loaisp = edtloaisp.getText().toString();
                int soluong = Integer.parseInt(edtsoluong.getText().toString());
                float dongia = Float.parseFloat(edtdongia.getText().toString());

                listSP.add(new SanPham(masp, tensp, loaisp, soluong, dongia));
                setAdapter();
            }
        });
        // Nút Sửa
        btnSua.setOnClickListener(v -> {
            if (index < 0) return;

            String masp = edtmasp.getText().toString();
            String tensp = edttensp.getText().toString();
            String loaisp = edtloaisp.getText().toString();
            int soluong = Integer.parseInt(edtsoluong.getText().toString());
            float dongia = Float.parseFloat(edtdongia.getText().toString());

            SanPham sp = listSP.get(index);

            sp.setMasp(masp);
            sp.setTensp(tensp);
            sp.setLoaisp(loaisp);
            sp.setSoluong(soluong);
            sp.setDongia(dongia);

            setAdapter();
            index = -1;
        });
        //Nút Xóa

        btnXoa.setOnClickListener(v -> {
            if (index < 0) return;

            listSP.remove(index);
            setAdapter();
            index = -1;
        });
        //Nút Thoát
        btnThoat.setOnClickListener(v -> finish());
    }

    private void anhxa() {
        edtmasp = findViewById(R.id.edt_masp);
        edttensp = findViewById(R.id.edt_tensp);
        edtloaisp = findViewById(R.id.edt_loaisp);
        edtsoluong = findViewById(R.id.edt_soluong);
        edtdongia = findViewById(R.id.edt_dongia);

        btnThem = findViewById(R.id.btn_Them);
        btnSua = findViewById(R.id.btn_Sua);
        btnXoa = findViewById(R.id.btn_Xoa);
        btnThoat = findViewById(R.id.btn_Thoat);

        lvsp = findViewById(R.id.lv_sp);
    }
    private void setAdapter() {
        if (adapter == null) {
            adapter = new SPAdapter(MainActivity.this, R.layout.list_sp, listSP);
            lvsp.setAdapter(adapter);
        }else{

            adapter.notifyDataSetChanged();
            edtmasp.setText("");
            edttensp.setText("");
            edtloaisp.setText("");
            edtsoluong.setText("");
            edtdongia.setText("");

        }
        lvsp.setOnItemClickListener((parent, view, position, id) -> {
            SanPham sp = listSP.get(position);

            edtmasp.setText(sp.getMasp());
            edttensp.setText(sp.getTensp());
            edtloaisp.setText(sp.getLoaisp());
            edtsoluong.setText(String.valueOf(sp.getSoluong()));
            edtdongia.setText(String.valueOf(sp.getDongia()));


            index = position;
        });



    }



}
