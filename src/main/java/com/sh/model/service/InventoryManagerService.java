package com.sh.model.service;

import com.sh.model.dao.InventoryManagerMapper;
import com.sh.model.entity.InventoryManagerDto;
import org.apache.ibatis.session.SqlSession;

import java.sql.Timestamp;

import static com.sh.common.MyBatisTemplate.getSqlSession;

public class InventoryManagerService {
    public void selectInventoryManager(SqlSession sqlSession, Timestamp entryDate, int empNumber, int inventoryId, int memberId) {
        InventoryManagerMapper inventoryManagerMapper = sqlSession.getMapper(InventoryManagerMapper.class);
        InventoryManagerDto inventoryManagerDto = new InventoryManagerDto(entryDate ,empNumber, inventoryId, memberId);

        inventoryManagerMapper.selectInventoryManager(inventoryManagerDto);
    }


}

