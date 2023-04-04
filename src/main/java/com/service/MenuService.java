package com.service;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.FoodMenu;
import com.repository.MenuRepository;

@Service
public class MenuService {


	@Autowired
	MenuRepository menurepo;
	
	//to add menu
	public void addmenu(FoodMenu menu) 
	{
		
		menurepo.save(menu);
		
	}	
	
	public List<FoodMenu> getallMenus() {
		
		List<FoodMenu> list=menurepo.findAll();
		return list;
	}
	

	
	public FoodMenu UpdateMenu(int id)
	{
		return this.menurepo.getById(id);
	}


	public void deleteReasurantById(int id) {
		  this.menurepo.deleteById(id);
		
	}
	
	

	// cart menu getter
		public FoodMenu getCartMenuById(int id)
		{
			FoodMenu menu=menurepo.getCartMenuById(id);
			System.out.println(menu.toString());
			return menu;
		}
		
		
		public List<FoodMenu> getMenuById(int id)
		{
			List<FoodMenu> menuList=menurepo.GetMenuById(id);
			System.out.println(menuList.toString());
			return menuList;
		}

		
		
		
		
	
}
