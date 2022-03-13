package org.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.com.beans.Employee;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;

public class EmployeeDaoNamedParameter {
	private JdbcTemplate jdbcTemplate;
	public EmployeeDaoNamedParameter(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}
	
	public void save(Employee employee) {
		String sql="insert into employee values(:id,:name,:email)";
		Map<String, Object> map=new HashMap();
		map.put("id", employee.getId());
		map.put("name", employee.getName());
		map.put("email", employee.getEmail());
		
		jdbcTemplate.update(sql,map,new PreparedStatementCallback() {  
		    @Override  
		    public Object doInPreparedStatement(PreparedStatement ps)  
		            throws SQLException, DataAccessException {  
		        return ps.executeUpdate();  
		    }  
		});  
	}
	

	public int update(Employee employee) {
		String sql = "update employee set name=:name,email=:email where id=:id";
		Map<String, Object> map=new HashMap();
		map.put("id", employee.getId());
		map.put("name", employee.getName());
		map.put("email", employee.getEmail());
		return this.jdbcTemplate.update(sql,map, new PreparedStatementCallback<Integer>() {

			@Override
			public Integer doInPreparedStatement(PreparedStatement pst) throws SQLException, DataAccessException {
				pst.setInt(3, employee.getId());
				pst.setString(1, employee.getName());
				pst.setString(2, employee.getEmail());

				return pst.executeUpdate();
			}
		});
	}

	public int delete(Employee employee) {
		String sql = "delete employee where id=:id";
		Map<String, Object> map=new HashMap();
		map.put("id", employee.getId());
		return this.jdbcTemplate.update(sql,map, new PreparedStatementCallback<Integer>() {

			@Override
			public Integer doInPreparedStatement(PreparedStatement pst) throws SQLException, DataAccessException {
				pst.setInt(1, employee.getId());
				return pst.executeUpdate();
			}
		});
	}

	public List<Employee> getEmployee(final Integer id) {

		PreparedStatementCreator creator = new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql = null;

				if (id != null) {
					sql = "select * from employee where id=?";

				} else {
					sql = "select * from employee";
				}
				PreparedStatement pst = con.prepareStatement(sql);
				if (id != null) {
					pst.setInt(1, id);
				}

				return pst;
			}
		};
		
		return this.jdbcTemplate.query(creator, new ResultSetExtractor<List<Employee>>() {

			@Override
			public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Employee> list = new ArrayList<Employee>();
				while (rs.next()) {
					Employee e = new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("email"));
					list.add(e);
				}
				return list;
			}
		});

	}

}
