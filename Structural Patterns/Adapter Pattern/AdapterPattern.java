interface MediaPlayer{
    void play(String filename);
}
class VlcPlayer{
    public void playVlc(String filename){
        System.out.println("Playing VLC: "+filename);
    }
}

class Mp4Player{
    public void playMp4(String filename){
        System.out.println("Playing MP4" + filename);
    }
}

class MediaAdapter implements MediaPlayer{
    private Object mediaPlayer;
    public MediaAdapter(String audioType){
        if(audioType.equalsIgnoreCase("vlc")){
            mediaPlayer = new VlcPlayer();
        }
        else if(audioType.equalsIgnoreCase("mp4")){
            mediaPlayer = new Mp4Player();
        }
    }
    @Override
    public void play(String fileName){
        if(mediaPlayer instanceof VlcPlayer){
            ((VlcPlayer) mediaPlayer).playVlc(fileName);
        }
        else if(mediaPlayer instanceof Mp4Player){
            ((Mp4Player) mediaPlayer).playMp4(fileName);
        }
    }
}
public class AdapterPattern {
    public static void main(String[] args) {
        MediaPlayer player = new MediaAdapter("vlc");
        player.play("myfile.vlc");
        player = new MediaAdapter("mp4");
        player.play(("anotherfile.mp4"));
        player = new MediaAdapter("avi"); // No adapter for AVI
        player.play("unsupported.avi"); // Does nothing, could throw an exception

    }
}
