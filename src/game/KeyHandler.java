package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    private boolean upPressed, downPressed, leftPressed, rightPressed;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int kCode = e.getKeyCode();
        keyMap(kCode, true);
    }

    @Override
    public void keyReleased(KeyEvent e) {

        int kCode = e.getKeyCode();
        keyMap(kCode, false);
    }

    private void keyMap(int kCode, boolean keyPressed){

        if(kCode == KeyEvent.VK_W) {
            upPressed = keyPressed;
        }
        if(kCode == KeyEvent.VK_S) {
            downPressed = keyPressed;
        }
        if(kCode == KeyEvent.VK_A) {
            leftPressed = keyPressed;
        }
        if(kCode == KeyEvent.VK_D) {
            rightPressed = keyPressed;
        }
    }

    public boolean isUpPressed() {
        return upPressed;
    }

    public boolean isDownPressed() {
        return downPressed;
    }

    public boolean isLeftPressed() {
        return leftPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }
}
