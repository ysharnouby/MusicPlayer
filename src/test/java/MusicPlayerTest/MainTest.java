/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MusicPlayerTest;

import MusicPlayer.Tracks;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

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

    @Test
    public void testPlaylist() {
        assertNotNull(Tracks.class);
    }
    
    
}
