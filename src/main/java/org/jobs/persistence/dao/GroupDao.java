package org.jobs.persistence.dao;

import java.util.List;

import org.jobs.persistence.bean.Group;

@Deprecated
public interface GroupDao extends Dao<Group> {

	List<Group> getAll();

	Group get(Long id);
}
