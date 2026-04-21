package module3.adapter;

/**
 * MODULE 3.7: Adapter Pattern
 *
 * Adapter bridges two incompatible interfaces.
 */

interface MediaPlayer {
    void play(String fileName);
}

class Mp3Player implements MediaPlayer {
    @Override
    public void play(String fileName) {
        System.out.println("Playing mp3 file: " + fileName);
    }
}

class OldVideoPlayer {
    public void playVideo(String fileName) {
        System.out.println("Playing video using old player: " + fileName);
    }
}

class VideoPlayerAdapter implements MediaPlayer {
    private final OldVideoPlayer oldVideoPlayer;

    public VideoPlayerAdapter(OldVideoPlayer oldVideoPlayer) {
        this.oldVideoPlayer = oldVideoPlayer;
    }

    @Override
    public void play(String fileName) {
        oldVideoPlayer.playVideo(fileName);
    }
}

public class AdapterLesson {
    public static void main(String[] args) {
        System.out.println("--- Adapter Demo ---");

        MediaPlayer mp3 = new Mp3Player();
        mp3.play("song.mp3");

        MediaPlayer video = new VideoPlayerAdapter(new OldVideoPlayer());
        video.play("movie.mp4");
    }
}
