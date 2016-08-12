package com.drift.codingtest.code;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface UserDAO {

	@SqlUpdate("insert into users (name, email, phone) values (:name, :email, :phone)")
	void insertUser(@Bind("name") String name, @Bind("email") String email, @Bind("phone") String phone);

	@SqlUpdate("delete from users where name = :name and phone = :phone")
	void deleteUser(@Bind("name") String name, @Bind("phone") String phone);

	@SqlQuery("select * from users where name = :name")
	String findUser(@Bind("name") String name);

	void close();
}
