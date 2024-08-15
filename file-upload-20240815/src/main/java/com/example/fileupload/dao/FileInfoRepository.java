package com.example.fileupload.dao;


import com.example.fileupload.pojo.FileInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileInfoRepository extends JpaRepository<FileInfo, Long> {
}
