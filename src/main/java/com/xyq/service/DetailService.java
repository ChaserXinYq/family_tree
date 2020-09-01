package com.xyq.service;

import com.xyq.domain.Detail;

import java.util.List;

public interface DetailService {


    public List<Detail> findAllDetail(String fid);

    public void saveDetail(Detail detail);

    public boolean findFid(String fid);

    public Detail findDetail(String fid,Integer nodeId);

    void updateDetail(Detail detail);
}
