package com.chat.query;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chat.dao.DataObject;
import com.chat.pojo.TablesEnum;

public class Query {
	public String query = "";

	public  Query select(TablesEnum table) {
		query += " * FROM " + table;
		return this;
	}

	public  Query select(TablesEnum table, List<String> columnList) {
		for (String column : columnList)
			query += column + " ,";
		query = query.replaceAll(",$", "");
		query += " FROM " + table;
		return this;
	}
	
	public Query delete(TablesEnum table) {
		query += " FROM " + table;
		return this;
	}
	public Query update(TablesEnum table,DataObject dataObject) {
		String setQuery = table+" SET ";
		for (Map.Entry<String, String> entry : dataObject.map.entrySet()) {
			setQuery += entry.getKey() + "='" + entry.getValue() + "',";
		}
		setQuery = setQuery.replaceAll(",$", "");
		query = setQuery;
		return this;
	}

	public Query where(HashMap<String, String> whereClauseMap) {
		query += " WHERE ";
		for (Map.Entry<String, String> entry : whereClauseMap.entrySet()) {
			query += entry.getKey() + "='" + entry.getValue() + "' AND ";
		}
		query = query.replaceAll("(and |AND )$", "");
		return this;
	}

	public Query limit(int n) {
		query += " LIMIT " + n;
		return this;
	}
}
