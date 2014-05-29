package playn.html;

import com.google.gwt.core.client.JsArray;
import java.util.ArrayList;
import java.util.List;
import playn.core.Gamepad;
import playn.core.Gamepads;

/**
 *
 * @author devnewton
 */
public class HtmlGamepads implements Gamepads {

    private final List<Gamepad> gamepads = new ArrayList<Gamepad>();

    @Override
    public native boolean hasGamepads() /*-{
     return ('getGamepads' in navigator);
     }-*/;

    @Override
    public List<Gamepad> plugged() {
        if (hasGamepads()) {
            updateGamepads();
        }
        return gamepads;
    }

    private void updateGamepads() {
        JsArray<HtmlGamepadJavascriptObject> gamepadArray = nativePlugged();
        if (gamepadArray.length() != gamepads.size()) {
            gamepads.clear();
            for (int i = 0, n = gamepadArray.length(); i < n; ++i) {
                HtmlGamepadJavascriptObject js = gamepadArray.get(i);
                if(null != js) {
                    final HtmlGamepad gamepad = new HtmlGamepad(js);
                    gamepads.add(gamepad);
                }
            }
        }
    }

    private static native JsArray<HtmlGamepadJavascriptObject> nativePlugged() /*-{
     return navigator.getGamepads();
     }-*/;

}
