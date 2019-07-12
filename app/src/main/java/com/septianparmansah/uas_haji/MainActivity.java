package com.septianparmansah.uas_haji;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText addNama;
    private EditText addNohp;
    private EditText addAlamat;
    private Spinner pilihGender;
    private Button btnSimpan;
    private Button btnTampil;
    String[] JK = {"Laki-Laki", "Perempuan"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addNama = findViewById(R.id.ed_nama);
        addNohp = findViewById(R.id.ed_nohp);
        addAlamat = findViewById(R.id.ed_alamat);
        pilihGender = findViewById(R.id.spiner_pilihgender);

        btnSimpan = findViewById(R.id.btn_simpan);
        btnTampil = findViewById(R.id.btn_tampil);

        btnSimpan.setOnClickListener(this);
        btnTampil.setOnClickListener(this);
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, JK);
        pilihGender.setAdapter(adapter);
    }

    private void addEmployee(){

        final String nama = addNama.getText().toString().trim();
        final String nohp = addNohp.getText().toString().trim();
        final String alamat = addAlamat.getText().toString().trim();
        final String jenis_kelamin = pilihGender.getSelectedItem().toString();

        class AddEmployee extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(MainActivity.this,"Menambahkan...","Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(MainActivity.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put(Konfigurasi.KEY_EMP_NAMA,nama);
                params.put(Konfigurasi.KEY_EMP_NOHP,nohp);
                params.put(Konfigurasi.KEY_EMP_ALAMAT,alamat);
                params.put(Konfigurasi.KEY_EMP_JENISKELAMIN,jenis_kelamin);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Konfigurasi.URL_ADD, params);
                return res;
            }
        }

        AddEmployee ae = new AddEmployee();
        ae.execute();
    }

    @Override
    public void onClick(View v) {
        if(v == btnSimpan){
            addEmployee();
        }

        if(v == btnTampil){
            startActivity(new Intent(this,TampilActivity.class));
        }
    }
}
