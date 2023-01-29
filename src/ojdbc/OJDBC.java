/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ojdbc;

import daos.RegionDAO;
import idaos.IRegionDAO;
import models.Region;
import tools.DBConnection;

/**
 *
 * @author HP
 */
public class OJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Manual Test DBConnection
        DBConnection connection = new DBConnection();
        System.out.println(connection);
        
//        Manual Test Model
//        Region region = new Region();
//        region.setId(0);
//        region.setName("region");
//        System.out.println(region.getId() + " " + region.getName());
//        
//        Region r = new Region(1, "Region New");
//        System.out.println(r.getId() + " " + r.getName());
        
//        Manual Test DAO insert
//        IRegionDAO irdao = new RegionDAO(connection.getConnection());
////        Region region = new Region(31, "My Region");
////        Region region = new Region(32, "My Region");
//        Region region = new Region(35, "My Region 35");
////        region = new Region(31, "My Region");
//        System.out.println(irdao.insert(region));

//        Manual Test DAO insert
        IRegionDAO irdao = new RegionDAO(connection.getConnection());
        Region r = new Region(70, "My Region 70");
        System.out.println(irdao.insert(r));
        System.out.println(irdao.getById(70).getId());
        System.out.println(irdao.getById(70).getName());       
        
//        Manual Test DAO getAll
//        IRegionDAO irdao = new RegionDAO(connection.getConnection());
//        
//        for (Region region : irdao.getAll()) {
//            System.out.println(region.getId());
//            System.out.println(region.getName());
//        }
        
//        Manual Test DAO getById
//        IRegionDAO irdao = new RegionDAO(connection.getConnection());
        
//        System.out.println(irdao.getById(33));
        
//        for (Region region : irdao.getById(32)) {
//            System.out.println(region.getId());
//            System.out.println(region.getName());
//        }
        
//        for (Iterator<Region> it = irdao.getAll().iterator(); it.hasNext();) {
//            region = it.next();
//            System.out.println(region.getId());
//            System.out.println(region.getName());
//        }

//        Manual Test update
//        IRegionDAO irdao = new RegionDAO(connection.getConnection());
//        
//        Region region = irdao.getById(33);
//        Region regionNew = new Region(33, "Region 20");
//        System.out.println(irdao.update(regionNew));

//        Manual Test DAO search
//        IRegionDAO irdao = new RegionDAO(connection.getConnection());
//        String searchKeyword = "egi"; 
//        for (Region region : irdao.search(searchKeyword)) {
//            System.out.println(region.getId());
//            System.out.println(region.getName());
//        }
        
//        Manual Test delete
//        IRegionDAO irdao = new RegionDAO(connection.getConnection());
//        irdao.delete(57);

//        New Version

//        Manual Test getById
//        IRegionDAO irdao = new RegionDAO(connection.getConnection());
//        irdao.getById(54).print();

//        Manual Test update
//        RegionDAO irdao = new RegionDAO(connection.getConnection());
//        Region lastRegion = irdao.getById(35);                          // change this to try
//        System.out.println(lastRegion.getName());
//        Region region = new Region(35, "My Region 35 updated");
//        System.out.println(irdao.update(region));
//        System.out.println(irdao.getById(35).getName());
    }
    
}
