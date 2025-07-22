package com.jaberrantisi.mystery_box_service.service;

import com.jaberrantisi.mystery_box_service.model.MysteryBox;
import com.jaberrantisi.mystery_box_service.repo.MysteryBoxRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MysteryBoxService {
    private final MysteryBoxRepo mysteryBoxRepo;

    public MysteryBoxService(MysteryBoxRepo mysteryBoxRepo) {
        this.mysteryBoxRepo = mysteryBoxRepo;
    }

    public List<MysteryBox> getAllMysteryBoxes() {
        return mysteryBoxRepo.findAll();
    }
}
