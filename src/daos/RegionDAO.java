/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.IRegionDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Region;

/**
 *
 * @author HP
 */
public class RegionDAO implements IRegionDAO{
    
    private Connection connection;

    public RegionDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Region> getAll() {
        List<Region> listRegion = new ArrayList<Region>();
        String query = "SELECT * FROM HR.REGIONS";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Region r = new Region(resultSet.getInt(1), resultSet.getString(2));
//                r.setId(resultSet.getInt(1));
//                r.setName(resultSet.getString(2));
                listRegion.add(r);
            }
            preparedStatement.close();
            resultSet.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return listRegion;
    }

//    @Override
//    public List<Region> getById(int id) {
//        List<Region> listRegion = new ArrayList<Region>();
//        String query = "Select * FROM HR.REGIONS WHERE region_id= "+id;
//        try{
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()){
//                Region r = new Region();
//                r.setId(resultSet.getInt(1));
//                r.setName(resultSet.getString(2));
//                listRegion.add(r);   
//            }
//        }catch(Exception e){
//            e.getStackTrace();
//        }
//        return listRegion;
//    }
    
    @Override
    public Region getById(int id) {
        Region r = new Region();
        String query = "Select * FROM HR.REGIONS WHERE region_id=" + id;
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
//            if (rs.first()) {
            if (rs.next()) {
                r.setId(rs.getInt(1));
                r.setName(rs.getString(2));
            } else {
                return null;
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return r;
    }

    @Override
    public List<Region> search(String key) {
        List<Region> listRegion = new ArrayList<Region>();
        String query = "SELECT * FROM HR.REGIONS WHERE region_name LIKE ?";
        
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, "%" + key + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Region r = new Region(rs.getInt(1), rs.getString(2));
                listRegion.add(r);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return listRegion;
    }

//    @Override
//    public boolean insert(Region r) {
//        boolean result = false;
//        String query = "INSERT INTO HR.REGIONS(region_id, region_name) VALUES (?, ?)";
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setInt(1, r.getId());
//            preparedStatement.setString(2, r.getName());
//            System.out.println(preparedStatement);
//            preparedStatement.executeQuery();
//            result = true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
    
    @Override
    public Region insert(Region region) {
        Region r = region;
        String query = "INSERT INTO HR.REGIONS(region_id, region_name) VALUES (?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, r.getId());
            preparedStatement.setString(2, r.getName());
            preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return r;
    }

//    @Override
//    public boolean update(Region r) {
//        boolean result = false;
//        String query = "UPDATE HR.REGIONS SET region_name= ? WHERE region_id= ?";
//        try{
//            PreparedStatement update = connection.prepareStatement(query);
//            update.setString(1,r.getName());
//            update.setInt(2,r.getId());
//            update.executeQuery();
//            result = true;
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        
//        return result;
//    }
    
//    @Override
//    public Region update(Region region) {
//        Region r = region;
////        System.out.println(r.getId());
////        System.out.println(r.getName());
//        String query = "UPDATE HR.REGIONS SET region_name= ? WHERE region_id= ?";
//        try{
//            PreparedStatement update = connection.prepareStatement(query);
////            update.setString(1,r.getName());
////            update.setInt(2,r.getId());
//            update.setInt(1,r.getId());
//            update.setString(2,r.getName());
//            update.executeQuery();
//        } catch (Exception e){
//            e.printStackTrace();
//            return null;
//        }
//        
//        return r;
//    }
    
    @Override
    public Region update(Region r) {
        String query = "UPDATE HR.REGIONS SET REGION_NAME = ? WHERE REGION_ID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, r.getName());
            ps.setInt(2, r.getId());
            ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return r;
    }

//    @Override
//    public boolean delete(int id) {
//        boolean result = false;
//        String query = "DELETE FROM HR.REGIONS WHERE region_id = ?";
//        
//        try {
//            PreparedStatement ps = connection.prepareStatement(query);
//            ps.setInt(1, id);
//            result = true;
//            System.out.println("Data berhasil dihapus.");
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Data gagal dihapus.");
//        }       
//        return result;
//    }
    
    @Override
    public void delete(int id) {
        String query = "DELETE FROM HR.REGIONS WHERE REGION_ID = ?  ";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeQuery();
//            System.out.println("The procedure succesfully deleted");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error");
//            System.out.println("See the details below");

        }

    }
    
}
