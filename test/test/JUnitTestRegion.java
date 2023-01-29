package test;


import controllers.RegionController;
import icontrollers.IRegionController;
import java.util.List;
import models.Region;
import tools.DBConnection;
import

//import

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class JUnitTestRegion {
    
    DBConnection connection = new DBConnection();
    IRegionController irc = new RegionController(connection.getConnection());
    
    public JUnitTestRegion() {
    }
    @Test
    public void testGetById() {
        List<Region> act = irc.getById("1");
        Assert.assertNotNull(act);
    }
    
    public void testGetAll() {
        List<Region> act3 = irc.getAll();
        Assert.assertNotNull(act3);
    }
}
