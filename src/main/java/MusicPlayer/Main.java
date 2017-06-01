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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <h1>Create and delete playlists and tracks</h1>
 * The MusicPlayer program implements an application that allows the user to
 * create playlists, add tracks to them, delete playlists and tracks.
 * <p>
 *
 * @author Yassine
 * @version 1.0
 */
public class Main {

    private static final Logger Log = LoggerFactory.getLogger(Main.class.getName());

    /**
     * The creatTable method connects to the database and creates a table in the
     * database to store tracks and playlist details. It then takes the user's
     * {@code choice} from the {@link Menu menu}, and makes an action
     * accordingly.
     * <p>
     * For every integer from 1 to 7 that can be chosen by the user from the
     * {@link Menu menu}, there is a method that describes the action to be
     * taken. It can add or delete a playlist, add or delete a track, show the
     * contents of a certain playlist, show or all the tracks in the database,
     * or exit the program.
     *
     * @param choice accepts selection from menu as parameter to do an action
     */
    public static void createTable(int choice) {

        ArrayList<Tracks> tracksList = new ArrayList();
        String input;
        Scanner sc = new Scanner(System.in);

        try {
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        } catch (SQLException ex) {
            Log.trace("Driver Manager failed to register", ex);
        }

        try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@db.inf.unideb.hu:1521:ora11g", "ENG_T0B4CE", "kassai");
                Statement st = conn.createStatement();) {
            Log.debug("Database connection established");
            try {
                st.executeUpdate("CREATE TABLE PLAYLISTS (playlist VARCHAR2(12)"
                        + " ,track VARCHAR2(12)"
                        + " ,artist VARCHAR2(12)"
                        + " ,publisher VARCHAR2(12)"
                        + " ,year VARCHAR2(12))");
            } catch (SQLException ex) {
                if (ex.getErrorCode() == 955) {
                    Log.info("Table already exists; no need to create a new one");
                } else {
                    throw ex;
                }
            }

            switch (choice) {
                case 1:
                    System.out.println("Enter playlist name:");
                    PreparedStatement pst = conn.prepareStatement("INSERT INTO PLAYLISTS (playlist, track, artist, publisher, year) "
                            + "VALUES (?,?,?,?,?)");
                    input = sc.nextLine();
                    Log.info("Playlist created");
                    try {
                        pst.setString(1, input);
                        pst.executeUpdate();
                    } catch (SQLException ex) {
                        Log.debug("Could create playlist", ex);
                    }
                    break;

                case 2:
                    PreparedStatement pst2 = conn.prepareStatement("INSERT INTO PLAYLISTS (playlist, track, artist, publisher, year) "
                            + "VALUES (?,?,?,?,?)");

                    try {
                        input = "";
                        while ("".equals(input)) {
                            System.out.println("Enter playlist name:");
                            input = sc.nextLine();
                        }
                        pst2.setString(1, input);

                        input = "";
                        while ("".equals(input)) {
                            System.out.println("Enter track name:");
                            input = sc.nextLine();
                        }
                        pst2.setString(2, input);

                        input = "";
                        while ("".equals(input)) {
                            System.out.println("Enter artist name:");
                            input = sc.nextLine();
                        }
                        pst2.setString(3, input);

                        input = "";
                        while ("".equals(input)) {
                            System.out.println("Enter publisher name:");
                            input = sc.nextLine();
                        }
                        pst2.setString(4, input);

                        input = "";
                        while ("".equals(input)) {
                            System.out.println("Enter year:");
                            input = sc.nextLine();
                        }
                        pst2.setString(5, input);

                        pst2.executeUpdate();
                        Log.info("Track created");
                    } catch (SQLException ex) {
                        Log.debug("Failed to create track", ex);
                    }
                    break;

                case 3:
                    System.out.println("Name of playlist to be deleted:");
                    PreparedStatement pst4 = conn.prepareStatement("DELETE FROM PLAYLISTS WHERE playlist=?");
                    input = sc.nextLine();
                    try {
                        pst4.setString(1, input);
                        pst4.executeUpdate();
                        Log.info("Playlist deleted");
                    } catch (SQLException ex) {
                        Log.warn("Playlist could not be deleted. Playlist does not exist", ex);
                    }
                    break;

                case 4:
                    System.out.println("Name of track to be deleted:");
                    PreparedStatement pst3 = conn.prepareStatement("DELETE FROM PLAYLISTS WHERE track=?");
                    input = sc.nextLine();

                    try {
                        pst3.setString(1, input);
                        pst3.executeUpdate();
                        Log.info("Track deleted");
                    } catch (SQLException ex) {
                        Log.warn("Track could not be deleted. Track does not exist", ex);
                    }
                    break;

                case 5:
                    System.out.println("Enter playlist name:");
                    input = sc.nextLine();
                    try (ResultSet rs = st.executeQuery("SELECT * FROM PLAYLISTS")) {
                        while (rs.next()) {
                            String playlist = rs.getString(1);
                            String track = rs.getString(2);
                            String artist = rs.getString(3);
                            String publisher = rs.getString(4);
                            String year = rs.getString(5);

                            if (input.equals(playlist)) {
                                tracksList.add(new Tracks(playlist, track, artist, publisher, year));
                            }
                        }
                        for (int i = 0; i < tracksList.size(); i++) {
                            if (sorting(tracksList).get(i).track == null) {
                            } else {
                                System.out.println(sorting(tracksList).get(i));
                            }
                        }
                    } catch (SQLException ex) {
                        Log.warn("Playlist does not exist", ex);
                    }
                    break;

                case 6:
                    try (ResultSet rs = st.executeQuery("SELECT * FROM PLAYLISTS")) {
                        while (rs.next()) {
                            String playlist = rs.getString(1);
                            String track = rs.getString(2);
                            String artist = rs.getString(3);
                            String publisher = rs.getString(4);
                            String year = rs.getString(5);
                            tracksList.add(new Tracks(playlist, track, artist, publisher, year));

                        }
                        for (int i = 0; i < tracksList.size(); i++) {
                            if (sorting(tracksList).get(i).track == null) {
                            } else {
                                System.out.println(sorting(tracksList).get(i));
                            }
                        }
                    }
                    break;
                    
                case 7:
                    break;

            }
        } catch (SQLException ex) {
            Log.debug("Failed to create table", ex);
        }
    }

    /**
     * This method takes the user's {@code choice} from the {@link Menu menu}
     * and give it as a parameter to {@link #createTable(int) createTable}
     * method in order to do the action chosen by the user.
     *
     * @param args
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter number 1 to start!");
        int userchoice = 0;

        while (!(input.hasNextInt() && input.nextInt() == 1)) {
            System.out.println("Invalid input! You must type 1!");
            input.nextLine();
        }

        while (true) {
            Menu.menu();

            if (input.hasNextInt()) {
                userchoice = input.nextInt();
            } else {
                while (!input.hasNextInt()) {
                    System.out.println("Invalid input! Enter a number from 1 to 7!");
                    Menu.menu();
                    input.nextLine();
                }
            }

            if (userchoice > 0 && userchoice < 8) {

            } else {
                while (true) {
                    System.out.println("Invalid input! Enter a number from 1 to 7!");
                    Menu.menu();
                    input.nextLine();
                }
            }

            createTable(userchoice);
        }

    }

    /**
     * This method creates an ArrayList out of tracks and sorts them according
     * to alphabetical order of the playlist name.
     *
     * @param pList list of tracks to be sorted
     * @return sorted list of tracks
     */
    public static ArrayList<Tracks> sorting(ArrayList<Tracks> pList) {

        List<Tracks> tempList = pList.stream()
                .sorted((p1, p2) -> p1.getPlaylist().compareTo(p2.getPlaylist()))
                .collect(Collectors.toList());
        return new ArrayList<>(tempList);
    }
}
