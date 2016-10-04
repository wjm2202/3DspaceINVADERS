package operations;

import application.MainView;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.net.URL;

/**
 * Created by Liandri on 2/10/2016.
 */
public class SoundEffects {

    private String musicFile1 = "src/sounds/blast3.wav";
    private Media sound1 = new Media(new File(musicFile1).toURI().toString());


    private String musicFile2 = "src/sounds/launch.wav";
    private Media sound2 = new Media(new File(musicFile2).toURI().toString());


    private String musicFile3 = "src/Sounds/smallexplosion.wav";
    private Media sound3 = new Media(new File(musicFile3).toURI().toString());


    private String musicFile4 = "src/Sounds/tankHit.wav";
    private Media sound4 = new Media(new File(musicFile4).toURI().toString());

    private String musicFile5 = "src/Sounds/invaderexplosion.wav";
    private Media sound5 = new Media(new File(musicFile5).toURI().toString());

    public void invaderExplosion() {
        MediaPlayer mediaPlayer5 = new MediaPlayer(sound5);
        mediaPlayer5.play();
    }

    public void playBlast() {
        MediaPlayer mediaPlayer1 = new MediaPlayer(sound1);
        mediaPlayer1.play();
    }
    public void playLaunch() {
        MediaPlayer mediaPlayer2 = new MediaPlayer(sound2);
        mediaPlayer2.play();
    }
    public void invaderHit() {
        MediaPlayer mediaPlayer3 = new MediaPlayer(sound3);
        mediaPlayer3.play();
    }
    public void tankHit() {
        MediaPlayer mediaPlayer4 = new MediaPlayer(sound4);
        mediaPlayer4.play();
    }
}
