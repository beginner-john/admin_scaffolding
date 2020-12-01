package com.generic.admin_scaffolding.repository;

import com.generic.admin_scaffolding.entity.model.SystemRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author xiong.bo
 * @version 1.0
 * @date 2020/11/21 9:48
 */
@Repository
public interface SystemRoleRepository extends JpaRepository<SystemRole,Long> {




}
