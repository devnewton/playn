package playn.core;

/**
 * Input-device interface for one gamepad
 * 
 * @author devnewton
 */
public interface Gamepad {

    /**
     * @return gamepad name
     */
    String name();

    /**
     * @return number of buttons on gamepad
     */
    int buttonCount();

    /**
     * @return button state value in range [0 .. 1] indicating how much a button is pressed
     */
    float buttonValue(int index);
    
    /**
     * @return return true if button should be considered as not triggered
     */
    boolean isButtonInDeadZone(int index);

    /**
     * @return number of axis on gamepad
     */
    int axisCount();

    /**
     * @return axis state value in range [-1 .. 1] 
     */
    float axisValue(int index);
    
    /**
     * @return return true if axis state should be considered as not triggered
     */
    boolean isAxisInDeadZone(int index);

}
