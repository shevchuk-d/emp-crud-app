package com.emp.app.params;

import com.emp.app.objects.model.DBObject;
import com.emp.app.objects.service.DBObjectService;
import com.emp.app.params.model.Params;
import com.emp.app.params.service.ParamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("objects")
public class ParamsController {
	
//	private ParamsService dbObjectService;
//
//	@Autowired(required=true)
//	@Qualifier(value= "dbObjectService")
//	public void setDBObjectService(ParamsService ps){
//		this.dbObjectService = ps;
//	}
//
////	@RequestMapping(value = "/objects", method = RequestMethod.GET)
////	public String listDBObjects(Model model) {
////		model.addAttribute("object", new DBObject());
////		model.addAttribute("listDBObjects", this.dbObjectService.listDBObjects());
////		return "objects";
////	}
//
//	//For add and update person both
//	@RequestMapping(value= "/object/add", method = RequestMethod.POST)
//	public String addDBObject(@ModelAttribute("object") Params p){
//
//		if(p.getId() == 0){
//			//new person, add it
//			this.dbObjectService.addDBObject(p);
//		}else{
//			//existing person, call update
//			this.dbObjectService.updateDBObject(p);
//		}
//
//		return "redirect:/objects";
//
//	}
//
//	@RequestMapping("/remove/{object_id}")
//    public String removeDBObject(@PathVariable("object_id") long id){
//        this.dbObjectService.removeDBObject(id);
//        return "redirect:/objects";
//    }
//
//    @RequestMapping("/edit/{object_id}")
//    public String editDBObject(@PathVariable("object_id") long id, Model model){
//        model.addAttribute("object", this.dbObjectService.getDBObjectById(id));
//        model.addAttribute("listObjects", this.dbObjectService.listDBObjects());
//        return "objects";
//    }
//
//	@RequestMapping(value = "/objects", method = RequestMethod.GET)
//	public String listDBObjects(Model model) {
//		model.addAttribute("object", new Object());
//		model.addAttribute("listExtendedDBObjects", this.dbObjectService.listExtendedDBObjects());
//		return "objects";
//	}

}
