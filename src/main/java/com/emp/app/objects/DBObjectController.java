package com.emp.app.objects;

import com.emp.app.objects.model.DBObject;
import com.emp.app.objects.service.DBObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DBObjectController {
	
	private DBObjectService personService;
	
	@Autowired(required=true)
	@Qualifier(value="dbobjectService")
	public void setDBObjectService(DBObjectService ps){
		this.personService = ps;
	}
	
	@RequestMapping(value = "/objects", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("object", new DBObject());
		model.addAttribute("listDBObjects", this.personService.listDBObjects());
		return "objects";
	}
	
	//For add and update person both
	@RequestMapping(value= "/object/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("object") DBObject p){
		
		if(p.getId() == 0){
			//new person, add it
			this.personService.addDBObject(p);
		}else{
			//existing person, call update
			this.personService.updateDBObject(p);
		}
		
		return "redirect:/objects";
		
	}
	
	@RequestMapping("/remove/{object_id}")
    public String removePerson(@PathVariable("object_id") long id){
        this.personService.removeDBObject(id);
        return "redirect:/objects";
    }
 
    @RequestMapping("/edit/{object_id}")
    public String editPerson(@PathVariable("object_id") long id, Model model){
        model.addAttribute("object", this.personService.getDBObjectById(id));
        model.addAttribute("listPersons", this.personService.listDBObjects());
        return "objects";
    }

}
