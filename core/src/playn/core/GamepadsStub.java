package playn.core;

import java.util.Collections;
import java.util.List;

/**
 * A NOOP gamepads service for use on platforms that don't support gamepad
 * interaction.
 *
 * @author devnewton
 */
public class GamepadsStub implements Gamepads {

    @Override
    public boolean hasGamepads() {
        return false;
    }

    @Override
    public List<Gamepad> plugged() {
        return Collections.emptyList();
    }

}
