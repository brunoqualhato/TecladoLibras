package librasteclado.qualhato.tecladolibras;


import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputConnection;


public class MetodoEntradaTeclado extends InputMethodService
        implements KeyboardView.OnKeyboardActionListener {

    private KeyboardView tecladoVew;
    private Keyboard teclado;
    private boolean caps = false;

    @Override
    public View onCreateInputView() {
        tecladoVew = (KeyboardView) getLayoutInflater().inflate(R.layout.keyboard_view, null);
        teclado = new Keyboard(this, R.xml.number_pad);
        tecladoVew.setKeyboard(teclado);
        tecladoVew.setOnKeyboardActionListener(this);
        return tecladoVew;
    }

    @Override
    public void onPress(int i) {

    }

    @Override
    public void onRelease(int i) {

    }

    @Override
    public void onKey(int primaryCode, int[] keyCodes) {
        InputConnection ic = getCurrentInputConnection();
        switch(primaryCode){
            case Keyboard.KEYCODE_DELETE :
                ic.deleteSurroundingText(1, 0);
                break;
            case Keyboard.KEYCODE_SHIFT:
                caps = !caps;
                tecladoVew.setShifted(caps);
                tecladoVew.invalidateAllKeys();
                break;
            case Keyboard.KEYCODE_DONE:
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
                break;
            default:
                char code = (char)primaryCode;
                if(Character.isLetter(code) && caps){
                    code = Character.toUpperCase(code);
                }
                ic.commitText(String.valueOf(code),1);
        }
    }

    @Override
    public void onText(CharSequence charSequence) {

    }

    @Override
    public void swipeLeft() {

    }

    @Override
    public void swipeRight() {

    }

    @Override
    public void swipeDown() {

    }

    @Override
    public void swipeUp() {

    }
}