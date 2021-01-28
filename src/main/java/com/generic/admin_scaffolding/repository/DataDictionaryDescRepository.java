package com.generic.admin_scaffolding.repository;

import com.generic.admin_scaffolding.entity.model.DataDictionaryDesc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xiong.bo
 * @version 1.0
 * @date 2020/12/1 17:08
 */

@Repository
public interface DataDictionaryDescRepository extends JpaRepository<DataDictionaryDesc, Long> {


    /**
     * 批量删除数据字典详情数据
     *
     * @param ids
     * @return
     */
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "DELETE FROM t_data_dictionary_desc WHERE id IN(:ids) LIMIT 100")
    Integer deleteByIds(List<Long> ids);

}
