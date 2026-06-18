package com.skills.hub.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skills.hub.model.SkillPack;
import com.skills.hub.repository.SkillPackRepository;
import com.skills.hub.service.SkillPackService;
@Service
public class SkillPackServiceImpl implements SkillPackService {

    private final SkillPackRepository packRepo;

    public SkillPackServiceImpl(SkillPackRepository packRepo) {
        this.packRepo = packRepo;
    }

    @Override
    public SkillPack addSkillPack(SkillPack pack) {

        if (pack == null) {
            return null;
        }

        return packRepo.save(pack);
    }

    @Override
    public List<SkillPack> getAllPacks() {

        return packRepo.findAll();
    }

    @Override
    public SkillPack updateSkillPack(SkillPack pack) {

        if (pack == null || pack.getId() == null) {
            return null;
        }

        if (!packRepo.existsById(pack.getId())) {
            return null;
        }

        return packRepo.save(pack);
    }

    @Override
    public void deleteSkillPack(Long id) {

        packRepo.deleteById(id);
    }

    public SkillPackRepository getPackRepo() {
        return packRepo;
    }
}