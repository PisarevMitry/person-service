package liga.medical.personservice.core.repository;

import liga.medical.personservice.core.model.IllnessEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IllnessRepository {

    @Select("select * from illness")
    IllnessEntity findAll();

    @Select("select * from illness where id = #{illnessId}")
    IllnessEntity findById(Long illnessId);

    @Insert("insert into illness (id, medical_card_id, type_id, heaviness, appearance_dttm, recovery_dt)" +
            "values (#{medicalCardId}, #{typeId}, #{heaviness}, #{appearanceDttm}, #{recoveryDt})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(IllnessEntity illnessEntity);

    List<IllnessEntity> findByListId(@Param("illnessListId") List<Long> illnessListId);

    int insertAll(@Param("illnessList") List<IllnessEntity> illnessEntityList);

    Boolean updateById(@Param("illnessEntity") IllnessEntity illnessEntity);

    Boolean deleteById(@Param("illnessId") Long illnessId);
}