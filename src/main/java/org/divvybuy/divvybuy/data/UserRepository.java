package org.divvybuy.divvybuy.data;

import org.divvybuy.divvybuy.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);

}
