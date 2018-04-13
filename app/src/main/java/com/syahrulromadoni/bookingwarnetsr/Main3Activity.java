package com.syahrulromadoni.bookingwarnetsr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Bundle a = getIntent().getExtras();

        TextView nama_booking = (TextView) findViewById(R.id.namaBooking1);
        TextView waktu_booking = (TextView) findViewById(R.id.textWaktu1);
        TextView tanggal_booking = (TextView) findViewById(R.id.teksTanggal1);
        TextView pilih_pc = (TextView) findViewById(R.id.listPc1);

        nama_booking.setText(a.getCharSequence("Nama Booking"));
        waktu_booking.setText(a.getCharSequence("Waktu Booking"));
        tanggal_booking.setText(a.getCharSequence("Tanggal Booking"));
        pilih_pc.setText(a.getCharSequence("Pilih PC"));
    }
}
