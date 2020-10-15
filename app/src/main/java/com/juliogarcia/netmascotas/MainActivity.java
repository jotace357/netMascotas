package com.juliogarcia.netmascotas;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Mascota>contactos;
    private RecyclerView listaContactos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // Defino los objetos de la interface
        Button button;
        EditText correo, asunto, mensaje;

        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            // Obtengo los elementos de la interface
            correo = findViewById(R.id.caja_correo);
            asunto = findViewById(R.id.caja_asunto);
            mensaje = findViewById(R.id.caja_mensaje);
            button = findViewById(R.id.btn_enviar);
            button.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view)
                {
                    String enviarcorreo = correo.getText().toString();
                    String enviarasunto = asunto.getText().toString();
                    String enviarmensaje = mensaje.getText().toString();

                    // Defino mi Intent y hago uso del objeto ACTION_SEND
                    Intent intent = new Intent(Intent.ACTION_SEND);

                    // Defino los Strings Email, Asunto y Mensaje con la función putExtra
                    intent.putExtra(Intent.EXTRA_EMAIL,
                            new String[] { enviarcorreo });
                    intent.putExtra(Intent.EXTRA_SUBJECT, enviarasunto);
                    intent.putExtra(Intent.EXTRA_TEXT, enviarmensaje);

                    // Establezco el tipo de Intent
                    intent.setType("message/rfc822");

                    // Lanzo el selector de cliente de Correo
                    startActivity(
                            Intent
                                    .createChooser(intent,
                                            "Elije un cliente de Correo:"));
                }
            });

        }

    }
    GridLayoutManager glm = new GridLayoutManager(this,2);
    listaContactos.setLayoutManager(glm);
    inicializarListaMascotas();
    inicializaAdaptador();
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void inicializaAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    //  public static class MascotaAdaptador {
    //  }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.bear,"Bear", 4));
        mascotas.add(new Mascota(R.drawable.catty,"Catty", 8));
        mascotas.add(new Mascota(R.drawable.chupin,"Chupin", 5));
        mascotas.add(new Mascota(R.drawable.done,"Done", 1));
    }
}