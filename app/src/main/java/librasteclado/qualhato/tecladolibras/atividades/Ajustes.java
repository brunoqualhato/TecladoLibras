package librasteclado.qualhato.tecladolibras.atividades;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import librasteclado.qualhato.tecladolibras.R;
import librasteclado.qualhato.tecladolibras.util.Vibracao;

public class Ajustes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);


        ListView lv = findViewById(R.id.lv_opcoes);
        List<String> oArrayOpcoes = new ArrayList<>();

        oArrayOpcoes.add("Ajustar Vibração");
        oArrayOpcoes.add("Sobre");


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                oArrayOpcoes);

        lv.setAdapter(arrayAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long l) {
                switch (posicao){
                    case 0:
                        Vibracao.mostrarAjusteVibracao(Ajustes.this);
                        break;
                }
            }
        });

    }


}
