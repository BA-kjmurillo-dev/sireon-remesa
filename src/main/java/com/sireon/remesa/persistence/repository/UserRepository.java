package com.sireon.remesa.persistence.repository;

import com.sireon.remesa.persistence.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, String> {
}
