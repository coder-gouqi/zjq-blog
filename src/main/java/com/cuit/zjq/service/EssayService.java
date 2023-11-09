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
     * 发布评论
     *
     * @return
     */
    Boolean essayAdd(EssayAddRequest essayAddRequest);

    /**
     * 修改评论
     *
     * @return
     */
    Boolean essayUpdate(EssayUpdateRequest essayUpdateRequest);

    /**
     * 查看评论
     */
    List<Essay> essaySelect(EssayQueryRequest essayQueryRequest);

    /**
     * 删除评论
     */
    Boolean essayDelete(DeleteRequest deleteRequest);
}
