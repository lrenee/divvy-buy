package org.divvybuy.divvybuy.data;

import org.divvybuy.divvybuy.models.Thread;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThreadRepository extends CrudRepository<Thread, Integer> {
}
