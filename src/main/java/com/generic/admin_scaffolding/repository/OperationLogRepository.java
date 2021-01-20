package com.generic.admin_scaffolding.repository;

import com.generic.admin_scaffolding.entity.model.OperationRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author xiong.bo
 * @version 1.0
 * @date 2021/1/7 13:58
 */
@Repository
public interface OperationLogRepository extends JpaRepository<OperationRecord,Long> {



}
