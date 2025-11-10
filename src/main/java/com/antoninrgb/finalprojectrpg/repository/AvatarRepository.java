package com.antoninrgb.finalprojectrpg.repository;
import com.antoninrgb.finalprojectrpg.model.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvatarRepository extends JpaRepository<Avatar, Integer> {

    Avatar findById(int id);

}
