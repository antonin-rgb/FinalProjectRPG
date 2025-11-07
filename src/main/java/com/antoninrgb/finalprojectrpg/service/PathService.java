package com.antoninrgb.finalprojectrpg.service;
import com.antoninrgb.finalprojectrpg.model.Path;
import com.antoninrgb.finalprojectrpg.repository.PathRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PathService {

    private final PathRepository pathRepository;

    public PathService(PathRepository pathRepository) {
        this.pathRepository = pathRepository;
    }

    public List<Path> findAllPaths() {
        return pathRepository.findAll();
    }

    public Path save(Path path) {
        return pathRepository.save(path);
    }

    public Path findByName(String name) {
        return pathRepository.findByName(name);
    }

    public Path findById(int id) {
        return pathRepository.findById(id);
    }

}
