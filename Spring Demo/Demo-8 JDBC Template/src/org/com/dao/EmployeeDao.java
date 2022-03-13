package org.com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.com.beans.Employee;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.StatementCallback;

public class EmployeeDao {
	private JdbcTemplate jdbcTemplate;
	public EmployeeDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}
	
	public int save(Employee employee) {
		String sql="insert into employee values("+employee.getId()+",'"+employee.getName()+"','"+employee.getEmail()+"')";
		return this.jdbcTemplate.update(sql);
	}
	
	public int update(Employee employee) {
		String sql="update employee set name='"+employee.getName()+"',  email='"+employee.getEmail()+"' "+" where id="+employee.getId()+"";
		return this.jdbcTemplate.update(sql);
	}
	public int delete(Employee employee) {
		String sql="delete employee where email='"+employee.getEmail()+"'";
		return this.jdbcTemplate.update(sql);
	}
	
	public List<Employee> getEmployee(Integer id){
		String sql=null;
		if(id!=null) {
			sql="select * from employee where id="+id;
		}
		else {
			sql="select * from employee";
		}
		
		return this.jdbcTemplate.query(sql,new ResultSetExtractor<List<Employee>>() {

			@Override
			public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				List<Employee> list=new ArrayList<Employee>();
				while(rs.next()) {
					Employee e=new Employee();
					e.setId(rs.getInt("id"));
					e.setName(rs.getString("name"));
					e.setEmail(rs.getString("email"));;
					list.add(e);
				}
				return list;
			}
		});
	}
}
