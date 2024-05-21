package com.sh.model.service;

import com.sh.model.dto.InventoryDto;
import com.sh.model.dao.InventoryMapper;
//import com.sh.menu.model.dto.CategoryDto;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.sh.common.MyBatisTemplate.getSqlSession;

public class InventoryService {
    public List<InventoryDto> findAllInventory() {
        SqlSession sqlSession = getSqlSession();
        InventoryMapper inventoryMapper = sqlSession.getMapper(InventoryMapper.class);
        List<InventoryDto> list = inventoryMapper.findAllInventory();
        sqlSession.close();
        return list;
    }

    public InventoryDto findInventoryByInventoryId(int inventoryId) {
        SqlSession sqlSession = getSqlSession();
        InventoryMapper inventoryMapper = sqlSession.getMapper(InventoryMapper.class);
        InventoryDto areaDto = inventoryMapper.findInventoryByInventoryId(inventoryId);
        sqlSession.close();
        return areaDto;
    }

    public int insertInventory(InventoryDto inventoryDto) {
        SqlSession sqlSession = getSqlSession();
        InventoryMapper inventoryMapper = sqlSession.getMapper(InventoryMapper.class);
        try {
            // dao 메세지 전달
            int result = inventoryMapper.insertInventory(inventoryDto);
            sqlSession.commit();
            return result;
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }

    public int updateInventory(InventoryDto inventoryDto) {
        SqlSession sqlSession = getSqlSession();
        InventoryMapper inventoryMapper = sqlSession.getMapper(InventoryMapper.class);
        try {
            // dao 메세지 전달
            int result = inventoryMapper.updateInventory(inventoryDto);
            sqlSession.commit();
            return result;
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }

    public int deleteInventory(int inventoryId) {
        SqlSession sqlSession = getSqlSession();
        InventoryMapper inventoryMapper = sqlSession.getMapper(InventoryMapper.class);
        try {
            // dao 메세지 전달
            int result = inventoryMapper.deleteInventory(inventoryId);
            sqlSession.commit();
            return result;
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }

}
