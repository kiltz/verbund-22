package gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class YourButton implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            //Hier kannst du dann deine Methoden ausführen lassen.
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
