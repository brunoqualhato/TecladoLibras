package librasteclado.qualhato.tecladolibras.atividades;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.shaishavgandhi.loginbuttons.FacebookButton;
import com.shaishavgandhi.loginbuttons.LinkedInButton;
import com.shaishavgandhi.loginbuttons.TwitterButton;

import librasteclado.qualhato.tecladolibras.R;
import librasteclado.qualhato.tecladolibras.util.Internet;

public class Sobre extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);

        FacebookButton facebookButton = findViewById(R.id.meu_facebook);
        LinkedInButton linkedInButton = findViewById(R.id.meu_linkedin);
        TwitterButton twitterButton = findViewById(R.id.meu_twitter);

        facebookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Internet.abrirLink("https://www.facebook.com/bruno.qualhato",Sobre.this);
            }
        });

        linkedInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Internet.abrirLink("https://www.linkedin.com/in/bruno-qualhato-398765125/",Sobre.this);
            }
        });

        twitterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Internet.abrirLink("https://twitter.com/brunoqualhato1",Sobre.this);
            }
        });

    }


}
