package com.ty.employeeManagement.model.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ty.employeeManagement.model.employeeModel;

public class employeeRowmapper implements RowMapper<employeeModel> {

	@Override
	public employeeModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		employeeModel empModel = new employeeModel();
		empModel.setId(rs.getInt("id"));
		empModel.setFirstName(rs.getString("firstName"));
		empModel.setLastName(rs.getString("lastName"));
		empModel.setEmail(rs.getString("email"));
		return empModel;
	}

}
