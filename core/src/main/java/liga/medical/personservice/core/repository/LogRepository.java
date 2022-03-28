package liga.medical.personservice.core.repository;

import liga.medical.personservice.core.model.logging.LogEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
public interface LogRepository {

    List<LogEntity> findAll();

    LogEntity findById(@Param("logId") Long logId);

    void insert(@RequestBody @Param("logEntity") LogEntity logEntity);
}

