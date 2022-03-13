package org.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.com.beans.Employee;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeDaoPreparedStatement {
	private JdbcTemplate jdbcTemplate;

	public EmployeeDaoPreparedStatement(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Boolean save(Employee employee) {
		String sql = "insert into employee values(?,?,?)";
		return this.jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement pst) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				pst.setInt(1, employee.getId());
				pst.setString(2, employee.getName());
				pst.setString(3, employee.getEmail());

				return pst.execute();
			}
		});
	}

	public int update(Employee employee) {
		String sql = "update employee set name=?,email=? where id=?";
		return this.jdbcTemplate.execute(sql, new PreparedStatementCallback<Integer>() {

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
		String sql = "delete employee where id=?";
		return this.jdbcTemplate.execute(sql, new PreparedStatementCallback<Integer>() {

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

	public List<Employee> getEmpoyeesWithRowMap(Integer id){
		String sql=null;
		if(id!=null) {
			sql="select * from employee where id="+id;
			
		}
		else {
			sql="select * from employee";
		}
		return this.jdbcTemplate.query(sql, new RowMapper() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNumber) throws SQLException {
				System.out.println("rowNumber : "+rowNumber);
				Employee e=new Employee();
				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setEmail(rs.getString("email"));
				return e;
			}
		});
		
	}

}
