/**
 *
 */
package businessLogic;

import GUI.LogIn;
/**
 * @author Felipe Páez González
 *
 */
public class Runner {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        EventManager manager = new EventManager("data/events.csv");
        manager.loadRegisters();
        LogIn log = new LogIn(manager);
    }
}

