package com.cuit.zjq.service;


import com.cuit.zjq.common.DeleteRequest;
import com.cuit.zjq.model.domain.Essay;
import com.cuit.zjq.model.dto.essay.EssayAddRequest;
import com.cuit.zjq.model.dto.essay.EssayQueryRequest;
import com.cuit.zjq.model.dto.essay.EssayUpdateRequest;

import java.util.List;

/**
 * @description 针对表【essay】的数据库操作Service
 */
public interface EssayService {
    /**
     * 发布文章
     *
     * @return
     */
    Boolean essayAdd(EssayAddRequest essayAddRequest);

    /**
     * 修改文章
     *
     * @return
     */
    Boolean essayUpdate(EssayUpdateRequest essayUpdateRequest);

    /**
     * 查看文章
     */
    List<Essay> essaySelect(EssayQueryRequest essayQueryRequest);

    /**
     * 查看文章
     */
    Essay essaySelectById(String id);

    /**
     * 删除文章
     */
    Boolean essayDelete(DeleteRequest deleteRequest);
}
