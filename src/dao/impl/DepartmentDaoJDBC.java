package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.DepartmentDao;
import db.DB;
import db.DbException;
import entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao {
	
	private Connection conn;
	public DepartmentDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	
	//INSERT -- OK
	@Override
	public void insert(Department obj) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {

			st = conn.prepareStatement(
					"INSERT INTO department "
					+ "(Name) "
					+ "VALUES (?)",
					Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, obj.getName());
			
			int rows = st.executeUpdate();
			rs = st.getGeneratedKeys();
			if(rows > 0 && rs.next()) {
				obj.setId(rs.getInt(1));
			}			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}

	//UPDATE -- OK
	@Override
	public void update(Department obj) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(
					"UPDATE department " 
					+ "SET Name = ? "
					+ "WHERE Id = ?");
			st.setString(1, obj.getName());
			st.setInt(2, obj.getId());
			
			st.executeUpdate();
			
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}
	
	//DELETE BY ID -- OK
	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(
					"DELETE FROM department "
					+ "WHERE Id = ?"
					);
			
			st.setInt(1, id);
			
			int rows = st.executeUpdate();
			
			st.execute("ALTER TABLE department AUTO_INCREMENT = 1");
			
			if(rows == 0) {
				System.out.println("ID DOESN'T EXISTS! PROGRAM WILL BE INTERRUPTED");
				throw new DbException("ID does not exists!");
			}
		}
		
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}
	
	//FIND BY ID  --OK
	@Override
	public Department findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		
		try {
			st = conn.prepareStatement(
					"SELECT * FROM department " 
					+"WHERE Id = ?");
			
			st.setInt(1, id);
			
			rs = st.executeQuery();
			
			if(rs.next()) {
				Department dep = new Department();
				dep.setId(rs.getInt(1));
				dep.setName(rs.getString(2));
				return dep;
			}
			else {
				return null;
			}
			
			
			
		} 
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}
	
	//FIND ALL -- OK
	@Override
	public List<Department> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		
		try {
			st = conn.prepareStatement(
					"SELECT * FROM department ");
			rs = st.executeQuery();
			
			List<Department> list = new ArrayList<>();
			while(rs.next()) {
				Department dep = new Department(rs.getInt(1), rs.getString(2));
				list.add(dep);
			}
			return list;
			
		} 
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

}
