package playn.java;

import org.lwjgl.input.Controller;
import playn.core.Gamepad;

/**
 *
 * @author devnewton
 */
class JavaGamepad implements Gamepad {

    private final Controller controller;

    JavaGamepad(Controller controller) {
        this.controller = controller;
    }

    @Override
    public String name() {
        return controller.getName();
    }

    @Override
    public int buttonCount() {
        return controller.getButtonCount();
    }

    @Override
    public float buttonValue(int index) {
        return controller.isButtonPressed(index) ? 1.0f : 0.0f;
    }

    @Override
    public boolean isButtonInDeadZone(int index) {
        return buttonValue(index) < 0.1f;
    }

    @Override
    public int axisCount() {
        return controller.getAxisCount();
    }

    @Override
    public float axisValue(int index) {
        return controller.getAxisValue(index);
    }

    @Override
    public boolean isAxisInDeadZone(int index) {
        float deadZone = controller.getDeadZone(index);
        float value = axisValue(index);
        return value > deadZone || value < -deadZone;
    }

}
