package playn.core;

import java.util.List;

/**
 * Input-device interface for gamepads
 * 
 * @author devnewton
 */
public interface Gamepads {
    
    /**
     * @return true if current platform support gamepads
     */
    boolean hasGamepads();

    /**
     * @return list of plugged gamepads
     */
    List<Gamepad> plugged();
}
