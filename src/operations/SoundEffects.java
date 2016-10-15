package operations;

import javafx.scene.media.AudioClip;

import java.net.URL;

/**
 * create and play sound effect events for game play
 * Created by Liandri on 2/10/2016.
 */
public class SoundEffects {


    final  URL clipURL1 = getClass().getResource("/sounds/inv.wav");
    final AudioClip clip1 = new AudioClip(clipURL1.toString());

    final  URL clipURL2 = getClass().getResource("/sounds/blast3.wav");
    final AudioClip clip2 = new AudioClip(clipURL2.toString());

    final  URL clipURL3 = getClass().getResource("/sounds/launch.wav");
    final AudioClip clip3 = new AudioClip(clipURL3.toString());

    final  URL clipURL4 = getClass().getResource("/sounds/tankHit.wav");
    final AudioClip clip4 = new AudioClip(clipURL4.toString());

    final  URL clipURL5 = getClass().getResource("/sounds/powerup.wav");
    final AudioClip clip5 = new AudioClip(clipURL5.toString());

    public void invaderExplosion() {
        clip1.play();
    }
    public void playBlast() {
        clip2.play();
    }
    public void playLaunch() {
        clip3.play();
    }
    public void tankHit() {
        clip4.play();
    }
    public void powerUp() {
        clip5.play();
    }
}
