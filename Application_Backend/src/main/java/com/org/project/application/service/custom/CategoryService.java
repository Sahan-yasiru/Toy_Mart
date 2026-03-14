package com.org.project.application.service.custom;

import com.org.project.application.dto.DtoCategory;
import com.org.project.application.service.SuperService;

public interface CategoryService extends SuperService<DtoCategory> {
    long getCount();
}
