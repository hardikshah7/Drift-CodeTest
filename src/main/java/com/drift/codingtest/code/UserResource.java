package com.drift.codingtest.code;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/users")
public class UserResource {

	private UserDAO userDAO;

	public UserResource(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@GET
	public void insertUser(@QueryParam("name") String name, @QueryParam("email") String email,
			@QueryParam("phone") String phone) {
		userDAO.insertUser(name, email, phone);
	}

	@GET
	public void findUser(@QueryParam("name") String name) {
		userDAO.findUser(name);
	}

	@GET
	public void deleteUser(@QueryParam("name") String name, @QueryParam("phone") String phone) {
		userDAO.deleteUser(name, phone);
	}

}
