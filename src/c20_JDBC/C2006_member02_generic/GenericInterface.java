package c20_JDBC.C2006_member02_generic;

import java.util.List;

public interface GenericInterface<T> {

	public int insert(T entity);
	public T search(int Id);
	public List<T> search(String name);
	public List<T> listAll();
	public int update(T entity);
	public int delete(int Id);
	
}