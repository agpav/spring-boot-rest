package org.springbootrest.crud.user;

public interface UserService {

	void save(User user);

	User findByUsername(String username);
}
