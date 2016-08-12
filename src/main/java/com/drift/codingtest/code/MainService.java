package com.drift.codingtest.code;

import org.skife.jdbi.v2.DBI;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class MainService extends Application<MainConfiguration> {

	public static void main(String[] args) throws Exception {
		new MainService().run(args);
	}

	@Override
	public void initialize(Bootstrap<MainConfiguration> bootstrap) {

	}

	@Override
	public void run(MainConfiguration conf, Environment env) throws Exception {
		final DBIFactory factory = new DBIFactory();
		final DBI jdbi = factory.build(env, conf.getDataSourceFactory(), "sqlserver");
		final UserDAO dao = jdbi.onDemand(UserDAO.class);
		env.jersey().register(new UserResource(dao));
	}
}
