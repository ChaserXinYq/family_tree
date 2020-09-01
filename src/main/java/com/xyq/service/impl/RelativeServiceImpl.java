package com.xyq.service.impl;

import com.xyq.dao.RelativeDao;
import com.xyq.dao.impl.RelativeDaoImpl;
import com.xyq.domain.Detail;
import com.xyq.service.RelativeService;

public class RelativeServiceImpl implements RelativeService {

    RelativeDao dao = new RelativeDaoImpl();

    @Override
    public Detail findNodeId(String fid, String phone) {
        Detail detail = dao.findNodeId(fid, phone);
        return detail;
    }
}
