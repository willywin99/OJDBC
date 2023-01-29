/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.RegionDAO;
import icontrollers.IRegionController;
import models.Region;
import idaos.IRegionDAO;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class RegionController implements IRegionController {
    
    private IRegionDAO irdao;

    public RegionController(Connection connection) {
        irdao = new RegionDAO(connection);
    }

    @Override
    public List<Region> getAll() {
        return irdao.getAll();
    }

    @Override
    public Region getById(String id) {
//        return irdao.getById(Integer.parseInt(id));

        Region r = new Region(0, "");
        try {
            if (id.isEmpty()) {
                System.out.println("Error!! Please fill id on getById param.");
            } else if (Integer.parseInt(id) < 1) {
                System.out.println("Error!! REGION_ID must be higher than zero(0).");
            } else if (Integer.parseInt(id) != irdao.getById(Integer.parseInt(id)).getId()) {
                System.out.println("Error!! REGION_ID does not exist.");
            } else {
                r = irdao.getById(Integer.parseInt(id));
                r.print();
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Error!! Enter ID correctly.");
            nfe.printStackTrace();
        }
        return r;
    }

    @Override
    public List<Region> search(String key) {
        List<Region> r = new ArrayList<Region>();
        try {
            if (key.isEmpty()) {
                System.out.println("Error!! Keyword is empty.");
            } else if (key.length() > 15) {
                System.out.println("Error!! Region name length is moore than 15.");
            } else {
                r = irdao.search(key);
            }
        } catch (NullPointerException npe) {
            System.out.println("Error!! Enter data correctly.");
            npe.printStackTrace();
        }
        return r;
    }

    @Override
    public Region insert(String id, String name) {
        Region r = new Region(Integer.parseInt(id), name);
        
        try {
            if (name.isEmpty()) {
                System.out.println("Error!! Name can not be empty.");
            } else if (name.length() > 15) {
                System.out.println("Error!! Name length can not be moore than 15.");
            } else if (name.length() < 3) {
                System.out.println("Error!! Name length can not be less than 3.");
            } else {
                r = irdao.insert(r);
                System.out.println("Region successfully inserted.");
            }
        } catch (NullPointerException npe) {
            System.out.println("Error!! Region is null");
            npe.printStackTrace();
        }
        
        return r;
    }

    @Override
    public Region update(String id, String name) {
        Region r = new Region(Integer.parseInt(id), name);
        
        try {
            if (name.isEmpty()) {
                System.out.println("Error!! Name can not be empty.");
            } else if(name.length() > 15) {
                System.out.println("Error!! Name length can not be moore than 15.");
            } else if (name.length() < 3) {
                System.out.println("Error!! Name length can not be less than 3.");
            } else {
                r = irdao.update(r);
                System.out.println("Region successfully updated.");
            }
        } catch (NullPointerException npe) {
            System.out.println("Error!! Region is null.");
            npe.printStackTrace();
        }
        
        return r;
    }

    @Override
    public String delete(String id) {
        String result = "";
        
        Region r = new Region();
        r.setId(Integer.parseInt(id));
        System.out.println(r.getId());
        
//        if (irdao.getById(Integer.parseInt(id))) {
//            result = "Data berhasil dihapus";
//        } else {
//            result = "Maaf data gagal dihapus";
//        }
        return result;
    }
    
}
