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


import java.util.Scanner;

/**
 * <h1>Menu to choose action</h1>
 * This class prints to the console a menu of options; these are actions that can be done
 * by the program, for the user to choose an action that he wishes to be done.
 * <p>
 * @author Yassine
 */
public class Menu {

    /**
     * This class prints to the console a menu of options and takes the user's
     * {@code choice} as input to decide what to do next.
     * 
     * @return returns user choice
     */
    public static int menu() {


        System.out.println("Choose from these choices");
        System.out.println("-------------------------\n");
        System.out.println("1 - Add playlist");
        System.out.println("2 - Add track");
        System.out.println("3 - Delete playlist");
        System.out.println("4 - Delete track");
        System.out.println("5 - Print playlist");
        System.out.println("6 - Print all playlists");
        System.out.println("7 - Quit");


        return 1;
    }
}
