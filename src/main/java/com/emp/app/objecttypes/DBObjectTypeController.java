package com.emp.app.objecttypes;

import com.emp.app.objects.model.DBObject;
import com.emp.app.objecttypes.model.DBObjectType;
import com.emp.app.objecttypes.service.DBObjectTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("object_types")
public class DBObjectTypeController {
	
	private DBObjectTypeService dbObjectTypeService;
	
	@Autowired(required=true)
	@Qualifier(value= "dbObjectTypeService")
	public void setDBObjectTypeService(DBObjectTypeService ps){
		this.dbObjectTypeService = ps;
	}
	
	@RequestMapping(value = "/object_types", method = RequestMethod.GET)
	public String listObjectTypes(Model model) {
		model.addAttribute("objectType", new DBObject());
		model.addAttribute("listDBObjectTypes", this.dbObjectTypeService.listDBObjectTypes());
		return "object_types";
	}
	
	//For add and update person both
	@RequestMapping(value= "/object_type/add", method = RequestMethod.POST)
	public String addObjectType(@ModelAttribute("objectType") DBObjectType p){
		
		if(p.getObjectTypeId() == 0){
			//new person, add it
			this.dbObjectTypeService.addDBObjectType(p);
		}else{
			//existing person, call update
			this.dbObjectTypeService.updateDBObjectType(p);
		}
		return "redirect:/object_types";
	}
	
	@RequestMapping("/removeOT/{object_type_id}")
    public String removeObjectType(@PathVariable("object_type_id") long id){
        this.dbObjectTypeService.removeDBObjectType(id);
        return "redirect:/object_types";
    }
 
    @RequestMapping("/editOT/{object_type_id}")
    public String editObjectType(@PathVariable("object_type_id") long id, Model model){
        model.addAttribute("objectType", this.dbObjectTypeService.getDBObjectTypeById(id));
        model.addAttribute("listObjectTypes", this.dbObjectTypeService.listDBObjectTypes());
        return "object_types";
    }

}
