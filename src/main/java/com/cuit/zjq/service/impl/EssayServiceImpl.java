package com.cuit.zjq.service.impl;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.UUID;
import com.cuit.zjq.common.DeleteRequest;
import com.cuit.zjq.mapper.EssayMapper;
import com.cuit.zjq.model.domain.Essay;
import com.cuit.zjq.model.dto.essay.EssayAddRequest;
import com.cuit.zjq.model.dto.essay.EssayQueryRequest;
import com.cuit.zjq.model.dto.essay.EssayUpdateRequest;
import com.cuit.zjq.service.EssayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description 针对表【essay】的数据库操作Service实现
 */
@Service
public class EssayServiceImpl implements EssayService {
    @Resource
    private EssayMapper essayMapper;


    @Override
    public Boolean essayAdd(EssayAddRequest essayAddRequest) {
        Essay essay = new Essay();
        BeanUtil.copyProperties(essayAddRequest, essay);
        String id = UUID.randomUUID().toString().replace("-", "");
        essay.setId(id);
        essay.setIsDelete(0);
        int insert = essayMapper.insert(essay);
        return insert > 0;
    }

    @Override
    public Boolean essayUpdate(EssayUpdateRequest essayUpdateRequest) {
        Essay essay = essayMapper.selectById(essayUpdateRequest.getId());
        BeanUtil.copyProperties(essayUpdateRequest, essay);
        int result = essayMapper.updateById(essay);
        return result > 0;
    }

    @Override
    public List<Essay> essaySelect(EssayQueryRequest essayQueryRequest) {
        List<Essay> essayList = essayMapper.select(essayQueryRequest);
        return essayList;
    }

    @Override
    public Boolean essayDelete(DeleteRequest deleteRequest) {
        int delete = essayMapper.deleteById(deleteRequest);
        return delete > 0;
    }
}




