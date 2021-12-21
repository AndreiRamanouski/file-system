package htp.by.ramanouski.filesystem.repository;

import htp.by.ramanouski.filesystem.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FileRepository extends JpaRepository<FileEntity, Integer> {
    FileEntity findByFileId(String fileId);
}
