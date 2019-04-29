package com.credifamilia.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.credifamilia.dao.ICDTDao;

@RestController
@RequestMapping("/cdt")
public class CDTController {
	
	@Autowired(required=true)
	ICDTDao icdtDao;
	
	@GetMapping("/reporte")
	public ResponseEntity<List<Object[]>> getAllArticles(@RequestParam Map<String, String> data) {
			
		List<Object[]> list = icdtDao.getDataExcel(data.get("year"),data.get("month"));
		return new ResponseEntity<List<Object[]>>(list, HttpStatus.OK);
	}

}
