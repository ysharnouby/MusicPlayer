/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MusicPlayer;

/*
 * #%L
 * MusicPlayer
 * %%
 * Copyright (C) 2017 Debreceni Egyetem
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */


/**
 * This class simply defines tracks and parameters for it.
 * <p>
 * The {@code playlist} that it belongs to, the {@code track name}, the {@code artist},
 * the {@code publisher}, and the {@code year} it was released in.
 * 
 * @author Yassine
 */
public class Tracks {

    
    public String playlist;    
    public String track;
    public String artist;
    public String publisher;
    public String year;

    /**
     * Constructor for {@code Track} objects.
     * 
     * @param playlist playlist it belongs to
     * @param track holds the track name
     * @param artist is the author of the track
     * @param publisher name of the publishing firm
     * @param year year of release
     */
    public Tracks(String playlist, String track, String artist, String publisher, String year) {
        this.playlist = playlist;
        this.track = track;
        this.artist = artist;
        this.publisher = publisher;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Playlist = " + getPlaylist() + ", Track = " + track + ", Artist = " + artist + ", Publisher = " + publisher + ", Year = " + year;
    }

    /**
     *
     * @return current track name
     */
    public String getTrack() {
        return track;
    }

    /**
     *
     * @param Track sets name of the track
     */
    public void setTrack(String Track) {
        this.track = Track;
    }

    /**
     *
     * @return current author name
     */
    public String getArtist() {
        return artist;
    }

    /**
     *
     * @param Artist sets name of the author
     */
    public void setArtist(String Artist) {
        this.artist = Artist;
    }

    /**
     *
     * @return current publisher name
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     *
     * @param Publisher sets name of the publisher
     */
    public void setPublisher(String Publisher) {
        this.publisher = Publisher;
    }

    /**
     *
     * @return current object's release year
     */
    public String getYear() {
        return year;
    }

    /**
     *
     * @param Year sets release year
     */
    public void setYear(String Year) {
        this.year = Year;
    }

    /**
     * @return the playlist that it currently belongs to
     */
    public String getPlaylist() {
        return playlist;
    }

    /**
     * @param playlist sets which playlist it belongs to
     */
    public void setPlaylist(String playlist) {
        this.playlist = playlist;
    }

}
