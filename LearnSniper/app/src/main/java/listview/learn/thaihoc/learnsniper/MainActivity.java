package listview.learn.thaihoc.learnsniper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import listview.learn.thaihoc.model.NhanVien;

public class MainActivity extends AppCompatActivity {

    EditText txtTen,txtSoNgay;
    Button btnXacNhan;
    Spinner spThu;

    ArrayList<String>dsThu;
    ArrayAdapter<String>adapterThu;

    int lastedSelected = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControl();
        addEvent();
    }

    private void addEvent() {
        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyXacNhanCongTac();
            }
        });
        spThu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //position: vi tri dong dang chon

                //hien thi thong tin dong dang chon
                Toast.makeText(MainActivity.this, "Bạn chọn " + dsThu.get(position),Toast.LENGTH_SHORT).show();
                //bam them vao xac nhan (danh dau lai vi tri chon)
                lastedSelected = position;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void xuLyXacNhanCongTac() {
        if (lastedSelected == -1)
        {
            Toast.makeText(MainActivity.this, "Chưa chọn thứ",Toast.LENGTH_SHORT).show();
            return;
        }

        NhanVien nv = new NhanVien();
        nv.setSoNgayCongTac(Integer.parseInt(txtSoNgay.getText().toString()));
        nv.setTenNhanVien(txtTen.getText().toString());
        nv.setThuBatDauCongTac(dsThu.get(lastedSelected));//lay vi tri trong danh sach da gan gia tri

        Toast.makeText(MainActivity.this, nv.toString(),Toast.LENGTH_SHORT).show();
    }

    private void addControl() {
        txtTen = (EditText) findViewById(R.id.txtTen);
        txtSoNgay = (EditText) findViewById(R.id.txtNgay);
        btnXacNhan = (Button) findViewById(R.id.btnXacNhan);

        spThu = (Spinner) findViewById(R.id.spThuCongTac);
        dsThu = new ArrayList<>();
        dsThu.add("Thứ 2");
        dsThu.add("Thứ 3");
        dsThu.add("Thứ 4");
        dsThu.add("Thứ 5");
        dsThu.add("Thứ 6");
        dsThu.add("Thứ 7");
        dsThu.add("Chủ nhật");

        adapterThu = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,dsThu);
        adapterThu.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spThu.setAdapter(adapterThu);
    }


}
