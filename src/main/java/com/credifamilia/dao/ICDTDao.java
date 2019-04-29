package com.credifamilia.dao;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface ICDTDao {
	
	List<Object[]> getDataExcel(String year, String month);

}
