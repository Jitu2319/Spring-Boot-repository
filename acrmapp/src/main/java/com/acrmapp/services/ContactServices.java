package com.acrmapp.services;

import java.util.List;

import com.acrmapp.entity.Contact;

public interface ContactServices {

	public void saveContact(Contact contact);

	public List<Contact> getAllContacts();

	public Contact findContactById(long id);
}
