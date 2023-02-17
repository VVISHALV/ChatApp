package com.chat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.chat.pojo.TablesEnum;
import com.chat.query.Query;

public class DBQuery {
	private static DBQuery obj;
	private DBQuery() {}
	public static DBQuery getInstance() {
		if(obj==null)
		synchronized (DBQuery.class) {
			if(obj==null)
				obj=new DBQuery();
			}
		return obj;
	}
	DBClass db = DBClass.getInstance();

	public DataObject selectRow(Query q) {
		q.query = "SELECT " + q.query;
		return executeSet(q.query);
	}
	public DataObject selectRows(Query q) {
		q.query = "SELECT " + q.query;
		return executeSets(q.query);
	}

	public boolean updateQuery(Query q) {
		q.query="UPDATE "+q.query;
		return execute(q.query);
	}

	public boolean deleteQuery(Query q) {
		q.query = "DELETE " + q.query;
		return execute(q.query);
	}

	public boolean insertQuery(TablesEnum table, DataObject dataObject) {
		String query = "";
		String tableQuery = "INSERT INTO " + table;
		String fieldsQuery = "";
		String valuesQuery = "";
		for (Map.Entry<String, String> entry : dataObject.map.entrySet()) {
			fieldsQuery += entry.getKey() + ",";
			valuesQuery += "'" + entry.getValue() + "',";
		}
		query = tableQuery + "(" + fieldsQuery + ")" + "VALUES (" + valuesQuery + ")";
		query = query.replaceAll(",[)]", ")");
		return execute(query);
	}

	private DataObject executeSet(String query) {
		ResultSet rs = null;
		try {
			Connection con = DBClass.getConnection();
			PreparedStatement pStatement = con.prepareStatement(query);
			System.out.println(query);
			rs = pStatement.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultSetToDataObject(rs);
	}
	private DataObject executeSets(String query) {
		ResultSet rs = null;
		try {
			Connection con = DBClass.getConnection();
			PreparedStatement pStatement = con.prepareStatement(query);
			System.out.println(query);
			rs = pStatement.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultSetsToDataObject(rs);
	}

	private boolean execute(String query) {
		try {
			Connection con = DBClass.getConnection();
			PreparedStatement pStatement = con.prepareStatement(query);
			System.out.println(query);
			pStatement.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	private DataObject resultSetToDataObject(ResultSet rs) {
		//ArrayList<HashMap<String, String>> mapList = new ArrayList<>();
		HashMap<String, String> map = new HashMap<>();
		ResultSetMetaData rsmd;
		try {
			rsmd = rs.getMetaData();
			int col = rsmd.getColumnCount();
			rs.next();
			map = new HashMap<>();
			for (int i = 1; i <= col; i++) {
			map.put(rsmd.getColumnName(i), rs.getString(i));
			}
			//mapList.add(map);
			} catch (SQLException e) {
			e.printStackTrace();
		}
		return new DataObject(map);
	}
	
	private DataObject resultSetsToDataObject(ResultSet rs) {
		ArrayList<HashMap<String, String>> mapList = new ArrayList<>();
		HashMap<String, String> map = new HashMap<>();
		ResultSetMetaData rsmd;
		try {
			rsmd = rs.getMetaData();
			int col = rsmd.getColumnCount();
			while(rs.next()) {
			map = new HashMap<>();
			for (int i = 1; i <= col; i++) {
			map.put(rsmd.getColumnName(i), rs.getString(i));
			}
			mapList.add(map);
			}
			} catch (SQLException e) {
			e.printStackTrace();
		}
		return new DataObject(mapList);
	}
}
