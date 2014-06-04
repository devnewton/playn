package playn.java;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Controllers;
import playn.core.Gamepad;
import playn.core.Gamepads;
import playn.core.Platform;

/**
 *
 * @author devnewton
 */
class JavaGamepads implements Gamepads {

    private final List<Gamepad> gamepads = new ArrayList<Gamepad>();
    private final Platform platform;
    
    public JavaGamepads(Platform platform) {
        this.platform = platform;
    }

    public void init() {
        gamepads.clear();
        try {
            Controllers.create();
            for (int i = 0, n = Controllers.getControllerCount(); i < n; ++i) {
                gamepads.add(new JavaGamepad(Controllers.getController(i)));
            }
        } catch (LWJGLException e) {
            platform.log().error("Cannot init gamepads service", e);
        }

    }

    @Override
    public boolean hasGamepads() {
        return true;
    }

    @Override
    public List<Gamepad> plugged() {
        return gamepads;
    }

    public void update() {
        while(Controllers.next()) {
            if(Controllers.isEventAxis()) {
                int index = Controllers.getEventSource().getIndex();
                JavaGamepad gamepad = (JavaGamepad) plugged().get(index);
                gamepad.axisReady[Controllers.getEventControlIndex()] = true;
            }
        }
    }

}
