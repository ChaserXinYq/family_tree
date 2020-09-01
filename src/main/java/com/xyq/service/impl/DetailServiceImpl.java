package com.xyq.service.impl;

import com.xyq.dao.DetailDao;
import com.xyq.dao.impl.DetailDaoImpl;
import com.xyq.domain.Detail;
import com.xyq.service.DetailService;

import java.util.List;

public class DetailServiceImpl implements DetailService {

    DetailDao dao = new DetailDaoImpl();

    @Override
    public List<Detail> findAllDetail(String fid) {
        List<Detail> list = dao.findAllDetail(fid);
        return list;
    }

    @Override
    public void saveDetail(Detail detail) {
        dao.saveDetail(detail);
    }

    @Override
    public boolean findFid(String fid) {
        boolean flag = dao.findFid(fid);
        return flag;
    }

    /**
     * 通过fid和nodeId查询一个详细信息
     * @param fid
     * @param nodeId
     * @return
     */
    @Override
    public Detail findDetail(String fid, Integer nodeId) {
        Detail dt= dao.findDetail(fid,nodeId);
        return dt;
    }

    @Override
    public void updateDetail(Detail detail) {
        dao.updateDetail(detail);
    }
}
