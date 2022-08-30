package com.crmappp.services;


import java.util.List;

import com.crmappp.entity.Contact;

public interface ContactService {
	
	public void saveContact(Contact contact);
	public List<Contact>getAllContacts();
//	public Lead findLeadById(long id);
	public Contact findContactById(long id);

}
