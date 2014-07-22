package com.sp.common.dao;

import java.util.List;
import java.util.Map;

public interface CommonDAO {
	public int insertData(String id, Object value) throws Exception;
	
	public int updateData(String id, Object pData) throws Exception;
	public int updateData(String id, Map<String, Object> map) throws Exception;
	
	public int deleteData(String id, Map<String, Object> map) throws Exception;
	public int deleteData(String id, Object value) throws Exception;
	public int deleteAll(String id) throws Exception;
	
	public int getIntValue(String id, Map<String, Object> map) throws Exception;
	public int getIntValue(String id, Object value) throws Exception;
	public int getIntValue(String id) throws Exception;
	
	public List<Object> getListData(String id, Map<String, Object> map) throws Exception;
	public List<Object> getListData(String id, Object value) throws Exception;
	public List<Object> getListData(String id) throws Exception;
	
	public Object getReadData(String id) throws Exception;
	public Object getReadData(String id, Object value) throws Exception;
	public Object getReadData(String id, Map<String, Object> map) throws Exception;
	
	// INSERT, UPDATE, DELETE 프로시져(IN)
	public void callUpdateProcedure(String id, Object value) throws Exception;
	
	// SELECT(OUT)
	public Map<String, Object> callSelectProcedureMap(String id, Map<String, Object> map) throws Exception;
}
