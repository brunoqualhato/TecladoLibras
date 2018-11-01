package librasteclado.qualhato.tecladolibras.util;

import android.graphics.Typeface;

import java.lang.reflect.Field;

public class SubscreverFontes {
    public static void subscreverFonte(String staticTypefaceFieldName,
                                       final Typeface newTypeface) {
        try {
            final Field staticField = Typeface.class.getDeclaredField(staticTypefaceFieldName);
            staticField.setAccessible(true);
            staticField.set(null, newTypeface);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
