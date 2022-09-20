package jp.co.act.domain.mybatis.mapper;

import static jp.co.act.domain.mybatis.mapper.UserInfoDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import jp.co.act.domain.mybatis.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonInsertMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface UserInfoMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<UserInfo>, CommonUpdateMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(userId, fileUploadCount, fileId, sex, bloodType, deleteFlg, createDate, updateDate);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="UserInfoResult", value = {
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="file_upload_count", property="fileUploadCount", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="file_id", property="fileId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="sex", property="sex", jdbcType=JdbcType.VARCHAR),
        @Result(column="blood_type", property="bloodType", jdbcType=JdbcType.VARCHAR),
        @Result(column="delete_flg", property="deleteFlg", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_date", property="updateDate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<UserInfo> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("UserInfoResult")
    Optional<UserInfo> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, userInfo, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, userInfo, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(String userId_, String fileUploadCount_, String fileId_) {
        return delete(c -> 
            c.where(userId, isEqualTo(userId_))
            .and(fileUploadCount, isEqualTo(fileUploadCount_))
            .and(fileId, isEqualTo(fileId_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(UserInfo row) {
        return MyBatis3Utils.insert(this::insert, row, userInfo, c ->
            c.map(userId).toProperty("userId")
            .map(fileUploadCount).toProperty("fileUploadCount")
            .map(fileId).toProperty("fileId")
            .map(sex).toProperty("sex")
            .map(bloodType).toProperty("bloodType")
            .map(deleteFlg).toProperty("deleteFlg")
            .map(createDate).toProperty("createDate")
            .map(updateDate).toProperty("updateDate")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<UserInfo> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, userInfo, c ->
            c.map(userId).toProperty("userId")
            .map(fileUploadCount).toProperty("fileUploadCount")
            .map(fileId).toProperty("fileId")
            .map(sex).toProperty("sex")
            .map(bloodType).toProperty("bloodType")
            .map(deleteFlg).toProperty("deleteFlg")
            .map(createDate).toProperty("createDate")
            .map(updateDate).toProperty("updateDate")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(UserInfo row) {
        return MyBatis3Utils.insert(this::insert, row, userInfo, c ->
            c.map(userId).toPropertyWhenPresent("userId", row::getUserId)
            .map(fileUploadCount).toPropertyWhenPresent("fileUploadCount", row::getFileUploadCount)
            .map(fileId).toPropertyWhenPresent("fileId", row::getFileId)
            .map(sex).toPropertyWhenPresent("sex", row::getSex)
            .map(bloodType).toPropertyWhenPresent("bloodType", row::getBloodType)
            .map(deleteFlg).toPropertyWhenPresent("deleteFlg", row::getDeleteFlg)
            .map(createDate).toPropertyWhenPresent("createDate", row::getCreateDate)
            .map(updateDate).toPropertyWhenPresent("updateDate", row::getUpdateDate)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<UserInfo> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, userInfo, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<UserInfo> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, userInfo, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<UserInfo> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, userInfo, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<UserInfo> selectByPrimaryKey(String userId_, String fileUploadCount_, String fileId_) {
        return selectOne(c ->
            c.where(userId, isEqualTo(userId_))
            .and(fileUploadCount, isEqualTo(fileUploadCount_))
            .and(fileId, isEqualTo(fileId_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, userInfo, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(UserInfo row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(userId).equalTo(row::getUserId)
                .set(fileUploadCount).equalTo(row::getFileUploadCount)
                .set(fileId).equalTo(row::getFileId)
                .set(sex).equalTo(row::getSex)
                .set(bloodType).equalTo(row::getBloodType)
                .set(deleteFlg).equalTo(row::getDeleteFlg)
                .set(createDate).equalTo(row::getCreateDate)
                .set(updateDate).equalTo(row::getUpdateDate);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(UserInfo row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(userId).equalToWhenPresent(row::getUserId)
                .set(fileUploadCount).equalToWhenPresent(row::getFileUploadCount)
                .set(fileId).equalToWhenPresent(row::getFileId)
                .set(sex).equalToWhenPresent(row::getSex)
                .set(bloodType).equalToWhenPresent(row::getBloodType)
                .set(deleteFlg).equalToWhenPresent(row::getDeleteFlg)
                .set(createDate).equalToWhenPresent(row::getCreateDate)
                .set(updateDate).equalToWhenPresent(row::getUpdateDate);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(UserInfo row) {
        return update(c ->
            c.set(sex).equalTo(row::getSex)
            .set(bloodType).equalTo(row::getBloodType)
            .set(deleteFlg).equalTo(row::getDeleteFlg)
            .set(createDate).equalTo(row::getCreateDate)
            .set(updateDate).equalTo(row::getUpdateDate)
            .where(userId, isEqualTo(row::getUserId))
            .and(fileUploadCount, isEqualTo(row::getFileUploadCount))
            .and(fileId, isEqualTo(row::getFileId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(UserInfo row) {
        return update(c ->
            c.set(sex).equalToWhenPresent(row::getSex)
            .set(bloodType).equalToWhenPresent(row::getBloodType)
            .set(deleteFlg).equalToWhenPresent(row::getDeleteFlg)
            .set(createDate).equalToWhenPresent(row::getCreateDate)
            .set(updateDate).equalToWhenPresent(row::getUpdateDate)
            .where(userId, isEqualTo(row::getUserId))
            .and(fileUploadCount, isEqualTo(row::getFileUploadCount))
            .and(fileId, isEqualTo(row::getFileId))
        );
    }
}