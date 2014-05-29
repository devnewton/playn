package playn.html;

import com.google.gwt.core.client.JavaScriptObject;

/**
 *
 * @author devnewton
 */
public final class HtmlGamepadJavascriptObject extends JavaScriptObject {

    protected HtmlGamepadJavascriptObject() {

    }

    public native String name() /*-{
     return this.id;
     }-*/;

    public native int buttonCount() /*-{
     return this.buttons.length;
     }-*/;

    public native float buttonValue(int index) /*-{
     return this.buttons[index].value;
     }-*/;

    public native boolean isButtonInDeadZone(int index) /*-{
     return !this.buttons[index].pressed;
     }-*/;

    public native int axisCount() /*-{
     return this.axes.length;
     }-*/;

    public native float axisValue(int index) /*-{
     return this.axes[index];
     }-*/;

    public boolean isAxisInDeadZone(int index) {
        float value = axisValue(index);
        return value < 0.1f && value > -0.1f;
    }

}
