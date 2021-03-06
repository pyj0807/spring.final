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
	//부서
	public List<Map> getDeparments(){
		return template.selectList("department.getDepartment");
	}
	//직책
	public List<Map> getPositions(){
		return template.selectList("department.getPosition");
	}
	//id
	public String getNewEmployeeId() {
		return "em" + template.selectOne("department.getEmployeeSeq");
	}
	
	//데이터 추가
	public int addEmployee(Map map) {
		return template.insert("department.addEmployee",map);
		
	}
	
	//로그인
	public Map loginck(Map map){
		return template.selectOne("department.loginck", map);
	}
	
	public Map getEmployee(String id) {
		return template.selectOne("department.getEmployee", id);
	}
	
	//메세지 보내기
	public int setMessage(Map map) {
		return template.insert("department.setMessage", map);
	}
	
	//메세지 가져오기
	public List<Map> getMessage(String receiver) {
		return template.selectList("department.getMessage", receiver);
	}
	
	public int upcho(int no) {
		return template.update("department.upcho", no);
	}
	
}
