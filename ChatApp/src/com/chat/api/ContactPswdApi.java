package com.chat.api;

import java.util.HashMap;

import com.chat.dao.DBQuery;
import com.chat.dao.DataObject;

import com.chat.pojo.ContactPswd;
import com.chat.pojo.TablesEnum;
import com.chat.pojo.ContactPswd.ContactPswdEnum;

import com.chat.query.Query;

public class ContactPswdApi {
	DBQuery dq = DBQuery.getInstance();
	
	
	public ContactPswd getContactPswdByID(String contactID) {
		ContactPswd contactPswd=new ContactPswd();
		HashMap<String, String> whereClauseMap = new HashMap<>();
		whereClauseMap.put(ContactPswdEnum.contact_id.toString(), contactID );
		DataObject dataObject = dq.selectRow(new Query().select(TablesEnum.ContactPswd).where(whereClauseMap));
		HashMap<String, String> map = dataObject.map;
		contactPswd = new ContactPswd(map);
		//System.out.println(contactPswd);
		return contactPswd;
	}
}
