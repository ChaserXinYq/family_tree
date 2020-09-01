package com.xyq.dao;

import com.xyq.domain.Detail;

import java.util.List;

public interface DetailDao {

    public List<Detail> findAllDetail(String fid);

    void saveDetail(Detail detail);

    public boolean findFid(String fid);

    Detail findDetail(String fid, Integer nodeId);

    void updateDetail(Detail detail);
}
