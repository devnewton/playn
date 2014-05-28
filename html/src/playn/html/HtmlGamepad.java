package playn.html;

import com.google.gwt.core.client.JavaScriptObject;
import playn.core.Gamepad;

/**
 *
 * @author devnewton
 */
public class HtmlGamepad extends JavaScriptObject implements Gamepad {

    @Override
    public native String name() /*-{
     return this.id;
     }-*/;

    @Override
    public native int buttonCount() /*-{
     return this.buttons.length;
     }-*/;

    @Override
    public native float buttonValue(int index) /*-{
        return this.buttons[index].value;
     }-*/;

    @Override
    public native boolean isButtonInDeadZone(int index) /*-{
        return !this.buttons[index].pressed;
     }-*/;

    @Override
    public native int axisCount() /*-{
        return this.axes.length;
     }-*/;

    @Override
    public native float axisValue(int index) /*-{
        return this.axes[index];
     }-*/;

    @Override
    public native boolean isAxisInDeadZone(int index) /*-{
        return this.axes[index] < 0.1f;
     }-*/;

}
