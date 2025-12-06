package com.osd.prefect.system.data.dao.request;

import com.osd.prefect.system.model.request.Request;

import java.util.List;

public interface RequestDao {
    void setRequest(String deptHeadID, String details, String message, String type);
    public List<Request> getAllRequests();
    boolean updateRequestStatus(String requestID, String newStatus);
}
