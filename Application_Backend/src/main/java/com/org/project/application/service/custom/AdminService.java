package com.org.project.application.service.custom;

import com.org.project.application.dto.DtoAdmin;
import com.org.project.application.service.SuperService;

public interface AdminService extends SuperService<DtoAdmin> {
    long getCount();

}
