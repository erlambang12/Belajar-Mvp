package com.praktikummp.mvp_mp3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.praktikummp.mvp_mp3.Presenter.MainPresenterImp;
import com.praktikummp.mvp_mp3.Presenter.MainView;

public abstract class MainActivity extends AppCompatActivity implements MainView {
    private EditText edtAlas,edtTinggi,edtPanjang,edtLebar;
    private Button btnHitungLuas,btnHitungKeliling;
    private TextView tvHasilLuas,tvHasilKeliling;
    private MainPresenterImp presenterImp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtAlas = findViewById(R.id.edt_alas);
        edtTinggi = findViewById(R.id.edt_tinggi);
        edtPanjang = findViewById(R.id.edt_panjang);
        edtLebar = findViewById(R.id.edt_lebar);
        btnHitungLuas = findViewById(R.id.btn_hitung_luas);
        btnHitungKeliling = findViewById(R.id.btn_hitung_keliling);
        tvHasilKeliling = findViewById(R.id.tv_hasil_keliling);
        tvHasilLuas = findViewById(R.id.tv_hasil_luas);

        initPresenter();
        btnHitungLuas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double alas = Double.valueOf(edtAlas.getText().toString());
                Double tinggi = Double.valueOf(edtTinggi.getText().toString());
                presenterImp.hitungLuas(alas,tinggi);
            }
        });

        btnHitungKeliling.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double panjang = Double.valueOf(edtPanjang.getText().toString());
                Double lebar = Double.valueOf(edtLebar.getText().toString());
            presenterImp.hitungKeliling(panjang,lebar);
            }
        }));
    }

    private void initPresenter(){
        presenterImp = new MainPresenterImp(this);
    }

    @Override
    public void updateTextHasilLuas(Double luas) {
        tvHasilLuas.setText(luas.toString());
    }

    @Override
    public void updateTextHasilKeliling(Double keliling) {
        tvHasilKeliling.setText(keliling.toString());
    }
}