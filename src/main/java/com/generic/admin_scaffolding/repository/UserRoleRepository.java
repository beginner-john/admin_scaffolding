package com.generic.admin_scaffolding.repository;

import com.generic.admin_scaffolding.entity.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xiong.bo
 * @version 1.0
 * @date 2020/11/29 10:51
 */
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {


    /**
     * 批量删除用户绑定的权限
     * 加上limit是避免错误删除所有数据
     *
     * @param ids
     * @return
     */
    @Modifying
    @Transactional
    @Query(nativeQuery = true,
            value = "DELETE FROM t_user_role WHERE role_id IN(:ids) LIMIT 100")
    Integer deleteByRoleIds(List<Long> ids);

}
