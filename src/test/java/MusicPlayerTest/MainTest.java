/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MusicPlayerTest;

import MusicPlayer.Tracks;
import junit.framework.TestCase;
import org.apache.commons.lang.builder.EqualsBuilder;
import static org.junit.Assert.*;
import org.junit.*;

/**
 *
 * @author LENOVO
 */
public class MainTest extends TestCase {

    public MainTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    Tracks a = new Tracks("A", "B", "C", "D", "2000");
    Tracks b = new Tracks("", "", "", "", "");

    @Test
    public void testPlaylistNotEmpty() {
        assertNotNull(a.getPlaylist());
        assertNotEquals("", a.getPlaylist());
    }

    @Test
    public void testTrackNotNull() {
        assertNotNull(a.getTrack());
    }

    @Test
    public void testDuplicate() {
        assertFalse(EqualsBuilder.reflectionEquals(a, b));
    }
}
