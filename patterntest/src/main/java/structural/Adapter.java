package structural;

import javax.print.attribute.standard.Media;

/**
 * Created by Orest on 2/24/2017.
 * <p>
 * Adapter pattern works as a bridge between two incompatible interfaces.
 * This type of design pattern comes under structural pattern as this pattern combines the capability of two independent interfaces.
 */
public class Adapter {

    /**
     * Step 1: Create interfaces for Media Player and Advanced Media Player.
     */

    public interface MediaPlayer {
        public void play(String audioType, String fileName);
    }

    public interface AdvancedMediaPlayer {
        public void playVlc(String fileName);

        public void playMp4(String fileName);
    }

    /**
     * Step 2: Create concrete classes implementing the AdvancedMediaPlayer interface.
     */

    public class VlcPlayer implements AdvancedMediaPlayer {

        @Override
        public void playVlc(String fileName) {
            System.out.println("Play vlc file : " + fileName);
        }

        @Override
        public void playMp4(String fileName) {
            // Nothing
        }
    }

    public class Mp4Player implements AdvancedMediaPlayer {

        @Override
        public void playVlc(String fileName) {
            // Nothing
        }

        @Override
        public void playMp4(String fileName) {
            System.out.println("Play mp4 file : " + fileName);
        }
    }

    /**
     * Step 3 : Create adapter class implementing the MediaPlayer interface.
     */
    public class MediaAdapter implements MediaPlayer {

        AdvancedMediaPlayer advancedMediaPlayer;

        public MediaAdapter(String audioType) {
            if (audioType.equalsIgnoreCase("vlc")) {
                advancedMediaPlayer = new VlcPlayer();
            } else if (audioType.equalsIgnoreCase("mp4")) {
                advancedMediaPlayer = new Mp4Player();
            }
        }

        @Override
        public void play(String audioType, String fileName) {
            if (audioType.equalsIgnoreCase("vlc")) {
                advancedMediaPlayer.playVlc(fileName);
            } else if (audioType.equalsIgnoreCase("mp4")) {
                advancedMediaPlayer.playMp4(fileName);
            }
        }
    }

    /**
     * Step 4 : Create concrete class implementing the MediaPlayer interface.
     */

    public class AudioPlayer implements MediaPlayer {

        MediaAdapter mediaAdapter;

        @Override
        public void play(String audioType, String fileName) {
            //induild support of mp3
            if (audioType.equalsIgnoreCase("mp3")) {
                System.out.println("Playing mp3 file : " + fileName);
            }

            //mediaAdapter is providing support to play other file formats
            else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
                mediaAdapter = new MediaAdapter(audioType);
                mediaAdapter.play(audioType, fileName);
            } else {
                System.out.println("Invalid media. " + audioType + " format not supported");
            }
        }
    }

    /**
     * Step 5 : Use the AudioPlayer to play different types of audio formats.
     */
    public static void main(String[] args) {
        Adapter adapter = new Adapter();
        AudioPlayer audioPlayer = adapter.new AudioPlayer();

        audioPlayer.play("mp3","I STAND ALONE.mp3");
        audioPlayer.play("mp4","Matrix.mp4");
        audioPlayer.play("vlc","Cats&Dogs.vlc");
        audioPlayer.play("avi","TheMask.avi");


    }

}
