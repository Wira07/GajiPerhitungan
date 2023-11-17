package com.example.gajiperhitungan;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText edtNama;
    private CheckBox menikah;
    private RadioGroup gol;
    private Button btnSimpan;
    private TextView tvResult;

    public void onCheckboxClicked(View view) {
        if (menikah.isChecked()) {
            tvResult.setText("Menikah: Ya");
        } else {
            tvResult.setText("Menikah: Tidak");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNama = (EditText) findViewById(R.id.edt_nama);
        menikah = (CheckBox) findViewById(R.id.menikah);
        gol = (RadioGroup) findViewById(R.id.gol);
        btnSimpan = (Button) findViewById(R.id.btn_simpan);
        tvResult = (TextView) findViewById(R.id.tv_result);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = edtNama.getText().toString();
                boolean statusMenikah = menikah.isChecked();
                int golongan = 0;

                if (gol.getCheckedRadioButtonId() == R.id.gol1) {
                    golongan = 1;
                } else if (gol.getCheckedRadioButtonId() == R.id.gol2) {
                    golongan = 2;
                }

                double gajiPokok = hitungGajiPokok(golongan);

                String hasil = " Total Gaji Atas Nama " + nama + gajiPokok;

                tvResult.setText(hasil);
            }
        });
    }

    private double hitungGajiPokok(int golongan) {
        switch (golongan) {
            case 1:
                return 2000000.0;
            case 2:
                return 2500000.0;
            default:
                return 0.0;
        }
    }

    private double hitungTunjanganSuamiIstri(double gajiPokok, boolean statusMenikah) {
        if (statusMenikah) {
            return 0.1 * gajiPokok;
        } else {
            return 0.0;
        }
    }
}