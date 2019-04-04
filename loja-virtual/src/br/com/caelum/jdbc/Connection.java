package br.com.caelum.jdbc;

import org.hsqldb.result.Result;

public interface Connection {
	Result execute(String sql);
}
