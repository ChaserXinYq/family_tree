package com.xyq.dao;

import com.xyq.dao.impl.DetailDaoImpl;
import com.xyq.domain.Detail;
import org.junit.Test;

import java.util.List;

public class FindAllDetailsTest {
    
    @Test
    public void testFindAll(){
        DetailDaoImpl dao = new DetailDaoImpl();
        List<Detail> list = dao.findAllDetail("123");
        for (int i = 0; i <3 ; i++) {
            System.out.println(list.get(i));
        }
    }
}
