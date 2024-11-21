package lpa.music;


import jakarta.persistence.*;

@Entity
@Table(name = "songs")
public class Song implements Comparable<Song>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "song_id")
    private int songId;

    @Column(name ="track_number")
    private int trackNumber;

    @Column(name="song_title")
    private String songTitle;

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }



    public Song(String songTitle, int trackNumber) {
        this.songTitle = songTitle;
        this.trackNumber = trackNumber;
    }

    @Override
    public String toString() {
        return "Song{" +
                "songId=" + songId +
                ", trackNumber=" + trackNumber +
                ", songTitle='" + songTitle + '\'' +
                '}';
    }

    public Song() {
    }

    @Override
    public int compareTo(Song o) {
        return this.getTrackNumber() - o.getTrackNumber();
    }
}
