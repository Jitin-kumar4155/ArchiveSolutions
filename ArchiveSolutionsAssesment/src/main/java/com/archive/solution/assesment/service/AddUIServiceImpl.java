package com.archive.solution.assesment.service;

import com.archive.solution.assesment.dao.AddUIRepository;
import com.archive.solution.assesment.dto.AddUIDTO;
import com.archive.solution.assesment.dto.UserRegisteredDTO;
import com.archive.solution.assesment.model.AddUI;
import com.archive.solution.assesment.model.Role;
import com.archive.solution.assesment.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddUIServiceImpl implements AddUIService{

    @Autowired
    AddUIRepository addUIRepository;

    public AddUIServiceImpl(AddUIRepository addUIRepository) {
        super();
        this.addUIRepository = addUIRepository;
    }

    @Override
    public AddUI save(AddUIDTO addUIDTO){
        AddUI addUI = new AddUI();
        addUI.setTitle(addUIDTO.getTitle());
        addUI.setDescription(addUIDTO.getDescription());
        addUI.setImage(addUIDTO.getImage());
        addUI.setPublicURL(addUIDTO.getPublicURL());
        addUI.setAuthors(addUIDTO.getAuthors());
        addUI.setArticle(addUIDTO.getArticle());
        addUI.setAccess(addUIDTO.getAccess());
        addUI.setPdf(addUIDTO.getPdf());
        return addUIRepository.save(addUI);
    }

}
