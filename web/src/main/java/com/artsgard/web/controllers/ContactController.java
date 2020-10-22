package com.artsgard.web.controllers;

import com.artsgard.core.model.Contact;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.artsgard.core.repository.ContactRepository;

@Controller
@RequestMapping("/")
public class ContactController {

    @Autowired 
    ContactRepository contactsRepo;

    @RequestMapping(method=RequestMethod.GET)
 	public String home(Map<String,Object> model) throws Exception {
  		List<Contact> contacts = contactsRepo.findAll();
  		model.put("contacts", contacts);                
  		return "home";
	} 

	@RequestMapping(method=RequestMethod.POST)
   		public String submit(Contact contact) throws Exception {
    		Contact c = contactsRepo.save(contact);
    		return "redirect:/";
  	}

}
