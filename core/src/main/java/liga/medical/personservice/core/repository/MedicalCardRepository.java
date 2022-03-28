package liga.medical.personservice.core.repository;

import liga.medical.personservice.core.model.MedicalCardEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MedicalCardRepository {

    @Select("select * from medical_card")
    List<MedicalCardEntity> findAll();

    @Select("select * from medical_card where id = #{cardId}")
    MedicalCardEntity findById(Long medicalCardId);

    @Insert("insert into medical_card (client_status, med_status, registry_dt, comment) " +
            "values(#{clientStatus}, #{medStatus}, #{registryDt}, #{comment})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(MedicalCardEntity medicalCardEntity);

    List<MedicalCardEntity> findByListId(@Param("medicalCardListId") List<Long> medicalCardListId);

    int insertAll(@Param("medicalCardList") List<MedicalCardEntity> medicalCardEntityList);

    Boolean updateById(@Param("medicalCardEntity") MedicalCardEntity medicalCardEntity);

    Boolean deleteById(@Param("medicalCardId") Long medicalCardId);
}