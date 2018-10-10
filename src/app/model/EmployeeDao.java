package app.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {
	
	@Autowired
	SqlSessionTemplate template;
	
	public List<Map> getDeparments(){
		return template.selectList("department.getDepartment");
	}
	
	public List<Map> getPositions(){
		return template.selectList("department.getPosition");
	}
	
}
