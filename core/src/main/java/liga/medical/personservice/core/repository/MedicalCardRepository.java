package liga.medical.personservice.core.repository;

import liga.medical.personservice.core.model.MedicalCardEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MedicalCardRepository {

    @Select("select * from medical_card where id = #{cardId}")
    MedicalCardEntity findById(Long cardId);

    @Insert("insert into medical_card (client_status, med_status, registry_dt, comment) " +
            "values(#{clientStatus}, #{medStatus}, #{registryDt}, #{comment})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(MedicalCardEntity cardEntity);

    List<MedicalCardEntity> findByIds(@Param("cardIds") List<Long> cardIds);

    int insertAll(@Param("cardList") List<MedicalCardEntity> cardEntityList);

    Boolean updateById(@Param("cardEntity") MedicalCardEntity cardEntity);

    Boolean deleteById(@Param("cardId") Long cardId);
}
