package librasteclado.qualhato.tecladolibras.introducao;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.res.ResourcesCompat;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import agency.tango.materialintroscreen.MaterialIntroActivity;
import agency.tango.materialintroscreen.MessageButtonBehaviour;
import agency.tango.materialintroscreen.SlideFragmentBuilder;
import librasteclado.qualhato.tecladolibras.R;
import librasteclado.qualhato.tecladolibras.atividades.Ajustes;
import librasteclado.qualhato.tecladolibras.util.PreferenciasCompartilhadas;

import static librasteclado.qualhato.tecladolibras.util.SubscreverFontes.subscreverFonte;

public class Introducao extends MaterialIntroActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (PreferenciasCompartilhadas.verificaApp(this)){
            startActivity(new Intent(this,Ajustes.class));
        }

        addSlide(new SlideFragmentBuilder()
                        .backgroundColor(R.color.colorPrimary)
                        .buttonsColor(R.color.colorAccent)
                        .image(agency.tango.materialintroscreen.R.drawable.ic_next)
                        .title("Selecione o Teclado")
                        .description("Altere o teclado para o Libras teclado")
                        .build(),
                new MessageButtonBehaviour(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showMessage("Perfeito");
                        PreferenciasCompartilhadas.setValor(Introducao.this,"app_aberto","passei_aqui");
                        startActivity(new Intent("android.settings.INPUT_METHOD_SETTINGS"));

                        InputMethodManager imeManager = (InputMethodManager)
                                getApplicationContext().getSystemService(INPUT_METHOD_SERVICE);
                        imeManager.showInputMethodPicker();
                    }
                }, "Alterar e selecionar Teclado"));

    }


}