package lpa.music;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name="albums")
public class Album implements Comparable<Album>{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "album_id")
    private int albumId;

    @Column(name = "album_name")
    private String albumName;

    @OneToMany()
    @JoinColumn(name = "album_id")
    private List<Song> songs = new ArrayList<>();

    public Album(){}

    public Album(String albumName) {
        this.albumName = albumName;
    }

    public int getAlbumId() {
        return albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void addSong(String songName, int track_Number){
        songs.add(new Song(songName, track_Number));
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public Album(int albumId, String albumName) {
        this.albumId = albumId;
        this.albumName = albumName;
    }



    @Override
    public String toString() {

        Collections.sort(songs);
        StringBuilder sb = new StringBuilder();

        for(Song s: songs){
            sb.append("\n\t").append(s);
        }

        return "Album{" +
                "albumId=" + albumId +
                ", albumName='" + albumName + '\'' +
                ", songs = "+ sb+
                '}';
    }

    @Override
    public int compareTo(Album o) {
        return this.albumName.compareTo(o.getAlbumName());
    }
}
