package com.antoninrgb.finalprojectrpg.service;
import com.antoninrgb.finalprojectrpg.repository.PathRepo;
import org.springframework.stereotype.Service;

@Service
public class PathService {

    private final PathRepo pathRepo;

    public PathService(PathRepo pathRepo) {
        this.pathRepo = pathRepo;
    }
}
