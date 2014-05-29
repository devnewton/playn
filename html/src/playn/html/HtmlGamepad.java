package playn.html;

import playn.core.Gamepad;

/**
 *
 * @author devnewton <devnewton@bci.im>
 */
class HtmlGamepad implements Gamepad {

    private final HtmlGamepadJavascriptObject js;

    HtmlGamepad(HtmlGamepadJavascriptObject js) {
        this.js = js;
    }

    @Override
    public String name() {
        return js.name();
    }

    @Override
    public int buttonCount() {
        return js.buttonCount();
    }

    @Override
    public float buttonValue(int index) {
        return js.buttonValue(index);
    }

    @Override
    public boolean isButtonInDeadZone(int index) {
        return js.isButtonInDeadZone(index);
    }

    @Override
    public int axisCount() {
        return js.axisCount();
    }

    @Override
    public float axisValue(int index) {
        return js.axisValue(index);
    }

    @Override
    public boolean isAxisInDeadZone(int index) {
        return js.isAxisInDeadZone(index);
    }

}
