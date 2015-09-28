/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kotys.monika.menucreator.interfaces;

import java.security.InvalidParameterException;
import java.util.TreeMap;



/**
 *
 * @author oem
 */
public interface IMenuCreatorLoader {
    
    public String getName();
    public String getLoadedClassName();
    public String getDataSourceType();
    public TreeMap<String, String> getDataSourceParameters();
    
    public boolean connect() throws InvalidParameterException;
    public boolean isConnected();
    
    public void setTargetObject(Object o);
    public boolean loadData() throws Exception;
    public boolean saveData();
        
}
