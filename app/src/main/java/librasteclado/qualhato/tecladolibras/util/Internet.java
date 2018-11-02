package librasteclado.qualhato.tecladolibras.util;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

public class Internet {

    public static void abrirLink(String url, Activity mActivity){

        if (!url.startsWith("http://") && !url.startsWith("https://")){
            url = "http://" + url;
        }
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        mActivity.startActivity(i);
    }
}
