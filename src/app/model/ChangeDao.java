package app.model;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ChangeDao {
	
	@Autowired
	SqlSessionTemplate template;
	
	public int setPass(Map map) {
		return template.update("department.setPass",map);
	}
}
