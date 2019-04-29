package com.credifamilia.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.credifamilia.start.CdtExportApplication;
import com.credifamilia.utils.UtilCredifamilia;

@Transactional
@Repository
public class CDTDao implements ICDTDao {

	@Autowired(required = true)
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Object[]> getDataExcel(String year, String month) {
		List<Object[]> dataCdtList = new ArrayList<>();
		
		try {
			String in = this.getClass().getClassLoader().getResource("query.properties").getPath();
			String query = UtilCredifamilia.getQueryString("query.CDT", in);
			
			query = query.replace("{year}", year).replace("{month}", month);
			
			List<Map<String, Object>> dataList = jdbcTemplate.queryForList(query);

			for (int i = 0; i < dataList.size(); i++) {
				dataCdtList.add(dataList.get(i).values().toArray());

			}
			return dataCdtList;
		} catch (Exception e) {
			CdtExportApplication.logger.log(Level.SEVERE,"Query	", e);
		}

		return dataCdtList;
	}

}
