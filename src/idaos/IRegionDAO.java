/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import java.util.List;
import models.Region;

/**
 *
 * @author HP
 */
public interface IRegionDAO {
    
    /**
     * Method unntuk mengambil 1 Region berdasarkan id
     */
    public Region getById(int id);
    
    /**
     * getAll method untuk mengambil semua data pada tabel Regions 
     */
    public List<Region> getAll();
    
    /**
     * Method yang digunakan untuk mendapatkan dan menyeleksi data dari tabel Regions
     */
//    public List<Region> getById(int id);
    
    /**
     * Method yang digunakan untuk mendapatkan dan menyeleksi data dari tabel Regions
     */
    public List<Region> search(String key);
    
    /**
     * Method yang digunakan untuk memasukkan data ke dalam tabel Regions
     */
//    public boolean insert(Region r);
    public Region insert(Region region);
    
    /**
     * Method yang digunakan untuk mengganti nilai data di dalam tabel regions
     */
//    public boolean update(Region r);
    public Region update(Region region);
    
    /**
     * Method yang digunakan untuk menghapus satu baris data sesuai id masukan
     */
//    public boolean delete(int id);
    public void delete(int id);
}
