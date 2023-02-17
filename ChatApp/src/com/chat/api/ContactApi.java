package com.chat.api;

import java.util.HashMap;

import com.chat.query.Query;
import com.chat.dao.DBQuery;
import com.chat.dao.DataObject;

import com.chat.pojo.Contact;
import com.chat.pojo.Contact.ContactEnum;
import com.chat.pojo.TablesEnum;

public class ContactApi {
	DBQuery dq = DBQuery.getInstance();

	public Contact getContactByID(String contactID) {
		Contact contact = new Contact();
		HashMap<String, String> whereClauseMap = new HashMap<>();
		whereClauseMap.put(ContactEnum.contact_id.toString(), contactID );
		DataObject dataObject = dq.selectRow(new Query().select(TablesEnum.Contact).where(whereClauseMap));
		contact = new Contact(dataObject.map);
		//System.out.println(contact);
		return contact;
	}

	public Contact getContactByPhoneNumber(String phoneNumber) {
		Contact contact = new Contact();
		HashMap<String, String> whereClauseMap = new HashMap<>();
		whereClauseMap.put(ContactEnum.phone_number.toString(), phoneNumber );
		DataObject dataObject = dq.selectRow(new Query().select(TablesEnum.Contact).where(whereClauseMap));
		contact = new Contact(dataObject.map);
		//System.out.println(contact);
		return contact;
	}
}