package librasteclado.qualhato.tecladolibras.introducao;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.support.v4.content.res.ResourcesCompat;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import agency.tango.materialintroscreen.MaterialIntroActivity;
import agency.tango.materialintroscreen.MessageButtonBehaviour;
import agency.tango.materialintroscreen.SlideFragmentBuilder;
import agency.tango.materialintroscreen.animations.IViewTranslation;
import librasteclado.qualhato.tecladolibras.R;

import static librasteclado.qualhato.tecladolibras.util.SubscreverFontes.subscreverFonte;

public class Introducao extends MaterialIntroActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Typeface oTypeface = ResourcesCompat.getFont(this, R.font.libras);
        subscreverFonte("DEFAULT", oTypeface);
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

                        startActivity(new Intent("android.settings.INPUT_METHOD_SETTINGS"));
                        InputMethodManager imeManager = (InputMethodManager)
                                getApplicationContext().getSystemService(INPUT_METHOD_SERVICE);
                        imeManager.showInputMethodPicker();
                    }
                }, "Alterar e selecionar Teclado"));


        getBackButtonTranslationWrapper()
                .setEnterTranslation(new IViewTranslation() {
                    @Override
                    public void translate(View view, @FloatRange(from = 0, to = 1.0) float percentage) {
                        view.setAlpha(percentage);
                    }
                });
    }


}