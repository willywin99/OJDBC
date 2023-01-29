/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Region;

/**
 *
 * @author HP
 */
public interface IRegionController {
    /**
     * getAll method mengambil semua data pada tabel Regions
     */
    public List<Region> getAll();
    
    /**
     * Method yang digunakan untuk mendapatkan dan menyeleksi data dari tabel Regions
     */
//    public List<Region> getById(String id);
    public Region getById(String id);
    
    /**
     * Method yang digunakan untuk mendapatkan dan menyeleksi data dari tabel Regions
     */
    public List<Region> search(String key);
    
    /**
     * Method yang digunakan untuk memasukkan data ke dalam tabel Regions
     */
    public Region insert(String id, String name);
    
    /**
     * Method yang digunakan untuk mengganti nilai data di dalam tabel Regions
     */
    public Region update(String id, String name);
    
    /**
     * Method yang digunakan untuk menghapus satu baris data sesuai id masukan
     */
    public String delete(String id);
    
}
