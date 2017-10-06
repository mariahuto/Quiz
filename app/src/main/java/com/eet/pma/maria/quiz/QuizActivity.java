package com.eet.pma.maria.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private int id_respostes[]={
            R.id.resposta1, R.id.resposta2, R.id.resposta3, R.id.resposta4
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        TextView texto_pregunta = (TextView) findViewById(R.id.texto_pregunta);
        texto_pregunta.setText(R.string.contenido_pregunta); //poner como texto la pregunta que ponemos en el strings.xml
        String[] respostes =getResources().getStringArray(R.array.respostes);

        for(int i = 0; i < id_respostes.length; i++){
            RadioButton rb = (RadioButton) findViewById(id_respostes[i]);
            rb.setText(respostes[i]); //surten el text de resposta que està en el strings.xml
        }

        final int resposta_correc = getResources().getInteger(R.integer.res_correcta);
        final RadioGroup rd = (RadioGroup) findViewById(R.id.respostes_btn);

        Button button_check = (Button) findViewById(R.id.btn_comprovar);
        button_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = rd.getCheckedRadioButtonId();//pedirle al RadioGroup cual de los botones estan activados (-1 = cuando no hay ninguno apretado)
                int index = -1;

                for(int j = 0; j < id_respostes.length; j++){
                    if(id == id_respostes[j]) index = j;
                }

                int solucio = index;
                if(solucio == resposta_correc) { //sacar por pantalla que la respuesta es CORRECTA
                    Toast.makeText(QuizActivity.this, R.string.missatge_correcte, Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(QuizActivity.this, R.string.missatge_incorrecte, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
