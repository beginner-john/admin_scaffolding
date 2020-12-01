package com.generic.admin_scaffolding.repository;

import com.generic.admin_scaffolding.entity.model.RoleResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xiong.bo
 * @version 1.0
 * @date 2020/11/29 17:15
 */

@Repository
public interface RoleResourceRepository extends JpaRepository<RoleResource, Long> {


    /**
     * 批量删除角色绑定的资源
     *
     * @param resourceIds
     * @return
     */
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "DELETE FROM t_role_resource WHERE resource_id IN(:resourceIds) LIMIT 100")
    Integer deleteByResourceIds(List<Long> resourceIds);
}
