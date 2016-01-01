package com.example.soulchavez.volado108317;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import static android.graphics.Color.*;

public class selectBet extends AppCompatActivity {

    TextView saldo;

    final int AGUILA_RESULT=2;
    final int SELLO_RESULT=1;
    ImageButton aguila;
    ImageButton sello;
    int ladoselec;
    ImageButton ready;
    EditText apuesta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_bet);

        Bundle extras=getIntent().getExtras();
        aguila=(ImageButton)findViewById(R.id.btnaguila);
        sello=(ImageButton)findViewById(R.id.btnsello);
        ready=(ImageButton)findViewById(R.id.readybtn);
        apuesta=(EditText) findViewById(R.id.apuesta);
        saldo=(TextView)findViewById(R.id.saldo);
        saldo.setText(String.valueOf(extras.getInt("saldo")));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_select_bet, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void aguilaChoice(View view){
        ladoselec=AGUILA_RESULT;
        aguila.setBackgroundColor(YELLOW);
        sello.setBackgroundColor(TRANSPARENT);
    }

    public void selloChoice(View view){
        ladoselec=SELLO_RESULT;
        sello.setBackgroundColor(YELLOW);
        aguila.setBackgroundColor(TRANSPARENT);
    }

    public void apostar(View v){
        if(Integer.parseInt(apuesta.getText().toString()) > Integer.parseInt(saldo.getText().toString())){
            apuesta.setBackgroundColor(RED);
        }else {
            Intent segunda = new Intent(this, ShowResult.class);
            segunda.putExtra("apuesta", apuesta.getText().toString());
            segunda.putExtra("seleccion", ladoselec);
            segunda.putExtra("saldo", saldo.getText().toString());
            startActivity(segunda);
        }
    }
}
