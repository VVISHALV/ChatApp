package com.chat.dao;

import java.util.ArrayList;
import java.util.HashMap;

public class DataObject {
	public HashMap<String,String> map=new HashMap<>();
	public ArrayList<HashMap<String, String>> mapList = new ArrayList<>();
	public DataObject(HashMap<String,String> map) {
		this.map=map;
	}
	public DataObject(ArrayList<HashMap<String, String>> mapList) {
		this.mapList = mapList;
	}
}
