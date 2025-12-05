package com.osd.prefect.system.app.facade.request;

import com.osd.prefect.system.model.request.Request;

import java.util.List;

public interface RequestFacade {
    void setRequest(String deptHeadID, String details, String message);
    List<Request> getAllRequests();
    boolean updateRequestStatus(String requestID, String newStatus);
}
