package com.syahrulromadoni.bookingwarnetsr;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class Main2Activity extends AppCompatActivity {

    Button pilihWaktu, pilihTanggal, kirimDara;
    EditText namaBooking, txtWaktu, txtTanggal;
    ListView pilihPc;

    int mHour,mMinute , mYear, mMonth, mDay;

    String [] pc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        pilihWaktu = findViewById(R.id.pilihWaktu);
        pilihTanggal = findViewById(R.id.pilihTanggal);
        namaBooking = findViewById(R.id.namaBooking);
        txtWaktu = findViewById(R.id.teksWaktu);
        txtTanggal = findViewById(R.id.teksTanggal);
        kirimDara = findViewById(R.id.kirim);

        pc = getResources().getStringArray(R.array.pc_array);
        Spinner s1 = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, pc);
        s1.setAdapter(adapter);
        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                int index = arg0.getSelectedItemPosition();
                Toast.makeText(getBaseContext(),
                        "You have selected item : " + pc[index],
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

    }

    public void pilihwaktu (View view){
       final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);

        TimePickerDialog pilihWaktu1 = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                txtWaktu.setText(hourOfDay + ":" + minutes);
            }
        }, mHour, mMinute, false);
        pilihWaktu1.show();
    }

    public void pilihTanggal (View view){
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog pilihtanggal1 = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfyear, int dayOfMonth) {
                txtTanggal.setText(dayOfMonth + "/" + monthOfyear + "/" + year);
            }
        }, mYear, mMonth, mDay);
        pilihtanggal1.show();
    }

    public void onClick_hasil (View view){

        Intent baru = new Intent(getApplicationContext(), Main3Activity.class);

        Bundle b = new Bundle();

        EditText nama_booking = (EditText) findViewById(R.id.namaBooking);
        baru.putExtra("Nama Booking", nama_booking.getText().toString());

        EditText waktu_booking = (EditText) findViewById(R.id.teksWaktu);
        baru.putExtra("Waktu Booking", waktu_booking.getText().toString());

        EditText tanggal_booking = (EditText) findViewById(R.id.teksTanggal);
        baru.putExtra("Tanggal Booking", tanggal_booking.getText().toString());

        Spinner pilih_pc = (Spinner) findViewById(R.id.spinner1);
        baru.putExtra("Pilih PC", pilih_pc.getSelectedItem().toString());

        startActivity(baru);
    }

}
