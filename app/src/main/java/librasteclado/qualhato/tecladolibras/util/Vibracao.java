package librasteclado.qualhato.tecladolibras.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.widget.SeekBar;

public class Vibracao {


    public static void ativarVibracao(Context mContext,int intensidade){
        Vibrator v = (Vibrator) mContext.getSystemService(Context.VIBRATOR_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(VibrationEffect.createOneShot(intensidade, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {
            v.vibrate(intensidade);
        }
    }

    public static void mostrarAjusteVibracao(final Activity mActivity) {
        final AlertDialog.Builder popDialog = new AlertDialog.Builder(mActivity);
        final SeekBar seek = new SeekBar(mActivity);
        seek.setMax(255);
        seek.setKeyProgressIncrement(1);

        popDialog.setTitle("Selecione a intensidade da vibração");
        popDialog.setView(seek);

        popDialog.setPositiveButton("Salvar",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        popDialog.create();
        popDialog.show();

        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {


            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {


                Log.d("intensidade",""+progress);
                Vibracao.ativarVibracao(mActivity,progress);
                PreferenciasCompartilhadas.setValor(mActivity,"vibracao",progress);
            }


            public void onStartTrackingTouch(SeekBar arg0) {

            }


            public void onStopTrackingTouch(SeekBar seekBar) {


            }
        });


    }
}