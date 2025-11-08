package com.alchemist.dao;

import com.alchemist.entity.StudentCompositeKey;
import com.alchemist.entity.StudentEntity;

public interface StudentDao {
	void saveStudent(StudentEntity entity);
	StudentEntity fetchStudent(StudentCompositeKey key);
}
