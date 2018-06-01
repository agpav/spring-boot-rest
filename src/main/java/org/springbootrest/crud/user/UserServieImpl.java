package org.springbootrest.crud.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServieImpl implements UserService {

	@Autowired
	private UserRepository repository;

	public void save(User user) {
		user.setPassword(user.getPassword());
		repository.save(user);
	}

	public User findByUsername(String username) {
		return repository.findByUsername(username);
	}
}
