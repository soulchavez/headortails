package com.example.soulchavez.volado108317;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowResult extends AppCompatActivity {
    int saldoR;
    int resultado;
    int apuesta;
    boolean win;
    int ladoElegido;
    TextView saldo;
    TextView resultadotv;
    ImageButton playag;
    ImageButton salir;
    int nuevosal=0;
    ImageView monedar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);
        Bundle extras = getIntent().getExtras();
        saldoR=Integer.parseInt(extras.getString("saldo"));

        ladoElegido=extras.getInt("seleccion");

        apuesta=Integer.parseInt(extras.getString("apuesta"));

        resultado=generaResultado();

        win=winner();
        resultadotv=(TextView)findViewById(R.id.resultado);
        saldo=(TextView)findViewById(R.id.saldotxt);

        if(win==true){
            resultadotv.setText("¡Ganaste!");
            nuevosal = saldoR+apuesta;
            saldo.setText(String.valueOf(nuevosal));

        }else{
            resultadotv.setText("Perdiste :(");
            nuevosal=saldoR-apuesta;
            saldo.setText(String.valueOf(nuevosal));
        }

        playag=(ImageButton)findViewById(R.id.playagain);
        salir=(ImageButton)findViewById(R.id.salir);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_show_result, menu);
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

    public int generaResultado(){
        int moneda=1+new Double(Math.random()*2).intValue();
        return moneda;
    }

    public boolean winner(){
        if(resultado==ladoElegido){
            return true;
        }
        return false;
    }

    public void jugarDeNuevo(View v){
        Intent segunda = new Intent(this, selectBet.class);
         segunda.putExtra("saldo", nuevosal);
        startActivity(segunda);
    }

    public void salir(View v){
       finish();
    }
}
