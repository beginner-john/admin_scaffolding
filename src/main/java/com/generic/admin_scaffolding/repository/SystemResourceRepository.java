package com.generic.admin_scaffolding.repository;

import com.generic.admin_scaffolding.entity.model.SystemResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xiong.bo
 * @version 1.0
 * @date 2020/11/29 12:36
 */

@Repository
public interface SystemResourceRepository extends JpaRepository<SystemResource, Long> {


    /**
     * 批量删除系统资源，根据ids
     * limit是限制以防删除太多数据
     *
     * @param ids
     * @return
     */
    @Modifying
    @Transactional
    @Query(nativeQuery = true,
            value = "DELETE FROM t_system_resource WHERE id IN(:ids) LIMIT 100")
    Integer deleteByIds(List<Long> ids);

}
