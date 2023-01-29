/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import java.util.List;
import models.Job;

/**
 *
 * @author HP
 */
public interface IJobDAO {
    
    public Job getById(int id);
    
    public List<Job> getAll();
    
    public List<Job> search(String key);
    
    public Job insert(Job job);
    
    public Job update(Job job);
    
    public void delete(int id);
}
