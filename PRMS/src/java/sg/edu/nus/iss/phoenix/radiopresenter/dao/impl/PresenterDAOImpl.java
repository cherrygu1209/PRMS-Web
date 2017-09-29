/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.radiopresenter.dao.impl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sg.edu.nus.iss.phoenix.core.dao.DBConstants;
import sg.edu.nus.iss.phoenix.core.exceptions.NotFoundException;
import sg.edu.nus.iss.phoenix.radiopresenter.dao.PresenterDAO;
import sg.edu.nus.iss.phoenix.radiopresenter.entity.RadioPresenter;
/**
 *
 * @author Raghu
 */
public class PresenterDAOImpl implements PresenterDAO {

	Connection connection;

	
	@Override
	public RadioPresenter createValueObject() {
		return new RadioPresenter();
	}

	
	@Override
	public RadioPresenter getObject(String name) throws NotFoundException,
			SQLException {

		RadioPresenter valueObject = createValueObject();
		valueObject.setName(name);
		load(valueObject);
		return valueObject;
	}

	
	@Override
	public void load(RadioPresenter valueObject) throws NotFoundException,
			SQLException {

		if (valueObject.getName() == null) {
			// System.out.println("Can not select without Primary-Key!");
			throw new NotFoundException("Can not select without Primary-Key!");
		}

		String sql = "SELECT * FROM `user` WHERE (`name` = ? ); ";
		PreparedStatement stmt = null;
		openConnection();
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, valueObject.getName());

			singleQuery(stmt, valueObject);

		} finally {
			if (stmt != null)
				stmt.close();
			closeConnection();
		}
	}

	

   

	@Override
	public List<RadioPresenter> loadAll() throws SQLException {
		openConnection();
		String sql = "SELECT * FROM phoenix.user WHERE role LIKE '%presenter%'OR role LIKE '%producer%'";
		List<RadioPresenter> searchResults = listQuery(connection.prepareStatement(sql));
		closeConnection();
		System.out.println("record size"+searchResults.size());
		return searchResults;
	}

	
            protected void singleQuery(PreparedStatement stmt, RadioPresenter valueObject)
			throws NotFoundException, SQLException {

		ResultSet result = null;
		openConnection();
		try {
			result = stmt.executeQuery();

			if (result.next()) {

				valueObject.setName(result.getString("name"));
				

			} else {
				// System.out.println("RadioProgram Object Not Found!");
				throw new NotFoundException("RadioProgram Object Not Found!");
			}
		} finally {
			if (result != null)
				result.close();
			if (stmt != null)
				stmt.close();
			closeConnection();
		}
	}


	 	protected List<RadioPresenter> listQuery(PreparedStatement stmt) throws SQLException {

		ArrayList<RadioPresenter> searchResults = new ArrayList<>();
		ResultSet result = null;
		openConnection();
		try {
			result = stmt.executeQuery();

			while (result.next()) {
				RadioPresenter temp = createValueObject();

				temp.setName(result.getString("name"));
				
				searchResults.add(temp);
			}

		} finally {
			if (result != null)
				result.close();
			if (stmt != null)
				stmt.close();
			closeConnection();
		}

		return (List<RadioPresenter>) searchResults;
	}

	private void openConnection() {
		try {
			Class.forName(DBConstants.COM_MYSQL_JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.connection = DriverManager.getConnection(DBConstants.dbUrl,
					DBConstants.dbUserName, DBConstants.dbPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void closeConnection() {
		try {
			this.connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

   
   
    @Override
    public List<RadioPresenter> searchMatching(RadioPresenter valueObject) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
