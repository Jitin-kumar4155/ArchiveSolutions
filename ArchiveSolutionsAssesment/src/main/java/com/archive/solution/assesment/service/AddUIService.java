package com.archive.solution.assesment.service;

import com.archive.solution.assesment.dao.AddUIRepository;
import com.archive.solution.assesment.dto.AddUIDTO;
import com.archive.solution.assesment.model.AddUI;

public interface AddUIService {
    AddUI save(AddUIDTO addUI);
}
