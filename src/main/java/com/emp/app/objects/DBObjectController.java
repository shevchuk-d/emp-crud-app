package com.emp.app.objects;

import com.emp.app.Upd;
import com.emp.app.objects.model.DBObject;
import com.emp.app.objects.service.DBObjectService;
import com.emp.app.objecttypes.model.DBObjectType;
import com.emp.app.objecttypes.service.DBObjectTypeService;
import com.emp.app.params.service.ParamsService;
import com.emp.app.params.service.ParamsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("objects")
public class DBObjectController {
	
	private DBObjectService dbObjectService;
	private ParamsService paramsService;
	private DBObjectTypeService dbObjectTypeService;

	private Upd upd = new Upd();

	@Autowired(required=true)
	@Qualifier(value= "dbObjectService")
	public void setDBObjectService(DBObjectService ps){
		this.dbObjectService = ps;
	}

	@Autowired(required=true)
	@Qualifier(value= "dbObjectTypeService")
	public void setDBObjectTypeService(DBObjectTypeService ps){
		this.dbObjectTypeService = ps;
	}

//	@RequestMapping(value = "/objects", method = RequestMethod.GET)
//	public String listDBObjects(Model model) {
//		model.addAttribute("object", new DBObject());
//		model.addAttribute("listDBObjects", this.dbObjectService.listDBObjects());
//		return "objects";
//	}
	
	//For add and update person both
	@RequestMapping(value= "/object/add", method = RequestMethod.POST)
	public String addDBObject(@ModelAttribute("object") DBObject p){
		if(p.getObjectId() == 0){
			//new person, add it
			this.dbObjectService.addDBObject(p);
		}else{
			//existing person, call update
			this.dbObjectService.updateDBObject(p);
		}
		return "redirect:/objects";
	}
	
	@RequestMapping("/remove/{object_id}")
    public String removeDBObject(@PathVariable("object_id") long id){
        this.paramsService.removeParams(id);
        this.dbObjectService.removeDBObject(id);
        return "redirect:/objects";
    }
 
    @RequestMapping("/edit/{object_id}")
    public String editDBObject(@PathVariable("object_id") long id, Model model){
		model.addAttribute("upd", new Upd());
        model.addAttribute("object", this.dbObjectService.getDBObjectById(id));
        return "objAdd";
    }

	@RequestMapping(value = "/objects", method = RequestMethod.GET)
	public String listDBObjects(Model model) {
//		model.addAttribute("listParams", this.paramsService.listParams(objectId));
		model.addAttribute("upd", new Upd());
		model.addAttribute("object", new DBObject());
		upd.setLimit("10");
		model.addAttribute("listExtendedDBObjects",
				this.dbObjectService.listExtendedDBObjects(Integer.parseInt(upd.getLimit())));
		return "objects";
	}

	@RequestMapping(value = "/objects", method = RequestMethod.POST)
	public String saveOrUpdateUser(@ModelAttribute("upd") Upd upd,
								   BindingResult result, Model model) {
		Upd u = (Upd) result.getModel().get("upd");
		int limit;
		try {limit = Integer.parseInt(u.getLimit());} catch (NumberFormatException nfe){limit = 10;}
		model.addAttribute("object", new DBObject());
		model.addAttribute("listExtendedDBObjects",
				this.dbObjectService.listExtendedDBObjects(limit));
		return "objects";
	}

	@Autowired(required=true)
	@Qualifier(value= "paramService")
	public void setParamsService(ParamsService paramsService) {
		this.paramsService = paramsService;
	}

	@RequestMapping("/add")
	public String addd(Model model){
		model.addAttribute("object", new DBObject());
		return "objAdd";
	}
}