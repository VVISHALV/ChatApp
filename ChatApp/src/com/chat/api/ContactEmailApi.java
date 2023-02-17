package com.chat.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.chat.dao.DBQuery;
import com.chat.dao.DataObject;
import com.chat.pojo.ContactEmail;

import com.chat.pojo.TablesEnum;
import com.chat.pojo.ContactEmail.ContactEmailEnum;


import com.chat.query.Query;

public class ContactEmailApi {
	DBQuery dq = DBQuery.getInstance();
	
	
	public ContactEmail getContactEmailByPrimaryEmail(String email) {
		ContactEmail contactEmail=new ContactEmail();
		HashMap<String, String> whereClauseMap = new HashMap<>();
		whereClauseMap.put(ContactEmailEnum.email_address.toString(), email );
		whereClauseMap.put(ContactEmailEnum.is_primary.toString(),"1");
		DataObject dataObject = dq.selectRow(new Query().select(TablesEnum.ContactEmail).where(whereClauseMap));
		contactEmail = new ContactEmail(dataObject.map);
		//System.out.println(contactEmail);
		return contactEmail;
	}
	public List<ContactEmail> getContactEmailById(String contactID){
		ArrayList<ContactEmail>contactEmailList=new ArrayList<>();
		HashMap<String, String> whereClauseMap = new HashMap<>();
		whereClauseMap.put(ContactEmailEnum.contact_id.toString(), contactID+"" );
		DataObject dataObject = dq.selectRows(new Query().select(TablesEnum.ContactEmail).where(whereClauseMap));
		for(HashMap<String,String> map:dataObject.mapList) {
			contactEmailList.add(new ContactEmail(map));
		}
		//System.out.println(contactEmailList);
		return contactEmailList;
	}
}
