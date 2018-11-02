package librasteclado.qualhato.tecladolibras.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import static android.content.Context.MODE_PRIVATE;
import static librasteclado.qualhato.tecladolibras.entidade.KeyPreferencias.PREFERENCIAS;

public class PreferenciasCompartilhadas {

    public static boolean verificaApp(Context mContext) {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(PREFERENCIAS, Context.MODE_PRIVATE);
        return sharedPreferences.getString("app_aberto", null) != null;
    }

    public static void deletarValor(Context context, String key) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(key).apply();
    }

    public static void setValor(Context context, String key, String value) {
        SharedPreferences.Editor editor = context.getSharedPreferences(PREFERENCIAS, MODE_PRIVATE).edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static void setValor(Context context, String key, boolean value) {
        SharedPreferences.Editor editor = context.getSharedPreferences(PREFERENCIAS, MODE_PRIVATE).edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public static void setValor(Context context, String key, double value) {
        String doubleVal = String.valueOf(value);
        SharedPreferences.Editor editor = context.getSharedPreferences(PREFERENCIAS, MODE_PRIVATE).edit();
        editor.putString(key, doubleVal);
        editor.apply();
    }

    public static void setValor(Context context, String key, float value) {
        SharedPreferences.Editor editor = context.getSharedPreferences(PREFERENCIAS, MODE_PRIVATE).edit();
        editor.putFloat(key, value);
        editor.apply();
    }

    public static void setValor(Context context, String key, long value) {
        SharedPreferences.Editor editor = context.getSharedPreferences(PREFERENCIAS, MODE_PRIVATE).edit();
        editor.putLong(key, value);
        editor.apply();
    }

    public static void setValor(Context context, String key, int value) {
        SharedPreferences.Editor editor = context.getSharedPreferences(PREFERENCIAS, MODE_PRIVATE).edit();
        editor.putInt(key, value);
        editor.apply();
    }

    /*************************
     * GET Methods
     ***************************************/
    public static String getValor(Context context, String key, String defValue) {
        SharedPreferences preferences = context.getSharedPreferences(PREFERENCIAS, MODE_PRIVATE);
        return preferences.getString(key, defValue);
    }

    public static boolean getValor(Context context, String key, boolean defValue) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getBoolean(key, defValue);
    }

    public static double getValor(Context context, String key, double defValue) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        String doubleVal = String.valueOf(defValue);
        return Double.parseDouble(preferences.getString(key, doubleVal));
    }

    public static float getValor(Context context, String key, float defValue) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getFloat(key, defValue);
    }

    public static long getValor(Context context, String key, long defValue) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getLong(key, defValue);
    }

    public static int getValor(Context context, String key, int defValue) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getInt(key, defValue);
    }
}
