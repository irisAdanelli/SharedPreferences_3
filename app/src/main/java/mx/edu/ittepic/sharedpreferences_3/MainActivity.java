package mx.edu.ittepic.sharedpreferences_3;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText mail;
    String mailS;
    RadioButton genero1,g2;
    Boolean gen1,gen2;
    CheckBox progra, write, trotar;
    Boolean pro,wr,tr;
    Spinner sp;
    Button save, get;
    public static final String Pref_3 = "Shared";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mail = findViewById(R.id.editmail);
        genero1 = findViewById(R.id.mas);
        g2 = findViewById(R.id.fem);
        progra = findViewById(R.id.programar);
        write = findViewById(R.id.escribir);
        trotar = findViewById(R.id.trotar);
        sp = findViewById(R.id.opciones);
        save = findViewById(R.id.saveme);
        get = findViewById(R.id.getme);


        mailS=mail.getText().toString();

        //if (genero1 is checked){}


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createShared();
            }
        });

        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readShared();
            }
        });


    }

    public void createShared(){
        SharedPreferences settings = getSharedPreferences(Pref_3,MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        mailS=mail.getText().toString();
        editor.putString("CORREO",mailS);
        editor.putBoolean("MADCULINO",genero1.isChecked());
        editor.putBoolean("FEMENINO",g2.isChecked());
        editor.putBoolean("PROGRAMAR",progra.isChecked());
        editor.putBoolean("ESCRIBIR",write.isChecked());
        editor.putBoolean("TROTAR",trotar.isChecked());
        //Spiner
        editor.putInt("ZODIACO",sp.getSelectedItemPosition());


        editor.commit();
        Toast.makeText(this, "Guardado...", Toast.LENGTH_SHORT).show();

    }

    private void readShared(){
        SharedPreferences settings = getSharedPreferences(Pref_3,MODE_PRIVATE);

        String valor = settings.getString("CORREO",mailS);
        Boolean ms = settings.getBoolean("MADCULINO",genero1.isChecked());
        Boolean fm = settings.getBoolean("FEMENINO",g2.isChecked());
        Boolean prog = settings.getBoolean("PROGRAMAR",progra.isChecked());
        Boolean wr = settings.getBoolean("ESCRIBIR",write.isChecked());
        Boolean tr = settings.getBoolean("TROTAR",trotar.isChecked());
        Integer ps = settings.getInt("ZODIACO",sp.getSelectedItemPosition());


        mail.setText(valor);
        genero1.setChecked(ms);
        g2.setChecked(fm);
        progra.setChecked(prog);
        write.setChecked(wr);
        trotar.setChecked(tr);
        sp.setSelection(ps);

        Toast.makeText(this, "Reading...", Toast.LENGTH_SHORT).show();

    }
}
