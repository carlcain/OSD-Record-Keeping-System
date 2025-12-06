package com.osd.prefect.system.app.facade.request.impl;

import com.osd.prefect.system.app.facade.request.RequestFacade;
import com.osd.prefect.system.data.dao.request.RequestDao;
import com.osd.prefect.system.data.dao.request.impl.RequestDaoImpl;
import com.osd.prefect.system.model.request.Request;

import java.util.List;

public class RequestFacadeImpl implements RequestFacade {
    private RequestDao request;

    public RequestFacadeImpl(){this.request = new RequestDaoImpl();}

    @Override
    public void setRequest(String deptHeadID, String details, String message, String type) {
        request.setRequest(deptHeadID, details, message, type);
    }

    @Override
    public List<Request> getAllRequests() {
        return request.getAllRequests() ;
    }

    @Override
    public boolean updateRequestStatus(String requestID, String newStatus) {
        return request.updateRequestStatus(requestID, newStatus);
    }
}
