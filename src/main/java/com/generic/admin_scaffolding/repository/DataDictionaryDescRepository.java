package com.generic.admin_scaffolding.repository;

import com.generic.admin_scaffolding.entity.model.DataDictionaryDesc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author xiong.bo
 * @version 1.0
 * @date 2020/12/1 17:08
 */

@Repository
public interface DataDictionaryDescRepository extends JpaRepository<DataDictionaryDesc, Long> {


}
