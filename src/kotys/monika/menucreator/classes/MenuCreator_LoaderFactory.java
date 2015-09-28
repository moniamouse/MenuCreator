/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kotys.monika.menucreator.classes;

import kotys.monika.menucreator.interfaces.IMenuCreatorLoader;
import java.util.ArrayList;

/**
 *
 * @author oem
 */
public class MenuCreator_LoaderFactory {
    
    private static MenuCreator_LoaderFactory instance;
    private ArrayList<IMenuCreatorLoader> loaders;
    protected MenuCreator_LoaderFactory(){
        loaders = new ArrayList<>();
    };
    
    public static MenuCreator_LoaderFactory getInstance(){
        if(instance == null)
            instance = new MenuCreator_LoaderFactory();
        return instance;
    }
    
    public void addFoodComponent_Loader(IMenuCreatorLoader loader){
        if(loaders.contains(loader))
            loaders.add(loader);
    }
    
    public void removeFoodComponent_Loader(IMenuCreatorLoader loader){
        if(loaders.contains(loader))
            loaders.remove(loader);
    }
    
    public IMenuCreatorLoader findLoaderByName(String name){
        ArrayList<IMenuCreatorLoader> founded = new ArrayList<>();
        loaders.forEach(l -> { if(name.equals(l.getName())) { founded.add(l);}});
        if(founded.isEmpty()) return null;
                else   return founded.get(0);
    };
    public ArrayList<String> listAvailbleLoaders(){
        ArrayList<String> lList = new ArrayList<>();
        loaders.forEach(l -> {lList.add(l.getName());});
        return lList;
    };
}
