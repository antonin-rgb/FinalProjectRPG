package com.antoninrgb.finalprojectrpg.service;
import com.antoninrgb.finalprojectrpg.model.Path;
import com.antoninrgb.finalprojectrpg.repository.PathRepo;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PathService {

    private final PathRepo pathRepo;

    public PathService(PathRepo pathRepo) {
        this.pathRepo = pathRepo;
    }

    public List<Path> findAllPaths() {
        return pathRepo.findAll();
    }

    public Path save(Path path) {
        return pathRepo.save(path);
    }
}
