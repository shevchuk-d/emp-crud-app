package com.journaldev.spring.employees.departments;

import com.journaldev.spring.employees.departments.model.Departments;
import com.journaldev.spring.employees.departments.service.DepartmentsService;
import com.journaldev.spring.persons.model.Person;
import com.journaldev.spring.persons.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DepartmentsController {
	
	private DepartmentsService departmentsService;
	
	@Autowired(required=true)
	@Qualifier(value="departmentsService")
	public void setDepartmentsService(DepartmentsService ps){
		this.departmentsService = ps;
	}
	
	@RequestMapping(value = "/departments", method = RequestMethod.GET)
	public String listDepartments(Model model) {
		model.addAttribute("departments", new Departments());
		model.addAttribute("listPersons", this.departmentsService.listDepartments());
		return "person";
	}
	
	//For add and update person both
	@RequestMapping(value= "/person/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("departments") Departments p){
		
		if(p.getId() == 0){
			//new person, add it
			this.departmentsService.addDepartments(p);
		}else{
			//existing person, call update
			this.personService.updatePerson(p);
		}
		return "redirect:/persons";
	}
	
	@RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") int id){
		
        this.personService.removePerson(id);
        return "redirect:/persons";
    }
 
    @RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("person", this.personService.getPersonById(id));
        model.addAttribute("listPersons", this.personService.listPersons());
        return "person";
    }
	
}
