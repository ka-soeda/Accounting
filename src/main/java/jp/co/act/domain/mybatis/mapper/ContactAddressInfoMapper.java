package jp.co.act.domain.mybatis.mapper;

import static jp.co.act.domain.mybatis.mapper.ContactAddressInfoDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import jp.co.act.domain.mybatis.entity.ContactAddressInfo;
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
public interface ContactAddressInfoMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<ContactAddressInfo>, CommonUpdateMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(userId, fileUploadCount, fileId, mailAddress, telNo, mobileNo, deleteFlg, createDate, updateDate);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ContactAddressInfoResult", value = {
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="file_upload_count", property="fileUploadCount", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="file_id", property="fileId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="mail_address", property="mailAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel_no", property="telNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile_no", property="mobileNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="delete_flg", property="deleteFlg", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_date", property="updateDate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ContactAddressInfo> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ContactAddressInfoResult")
    Optional<ContactAddressInfo> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, contactAddressInfo, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, contactAddressInfo, completer);
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
    default int insert(ContactAddressInfo row) {
        return MyBatis3Utils.insert(this::insert, row, contactAddressInfo, c ->
            c.map(userId).toProperty("userId")
            .map(fileUploadCount).toProperty("fileUploadCount")
            .map(fileId).toProperty("fileId")
            .map(mailAddress).toProperty("mailAddress")
            .map(telNo).toProperty("telNo")
            .map(mobileNo).toProperty("mobileNo")
            .map(deleteFlg).toProperty("deleteFlg")
            .map(createDate).toProperty("createDate")
            .map(updateDate).toProperty("updateDate")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<ContactAddressInfo> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, contactAddressInfo, c ->
            c.map(userId).toProperty("userId")
            .map(fileUploadCount).toProperty("fileUploadCount")
            .map(fileId).toProperty("fileId")
            .map(mailAddress).toProperty("mailAddress")
            .map(telNo).toProperty("telNo")
            .map(mobileNo).toProperty("mobileNo")
            .map(deleteFlg).toProperty("deleteFlg")
            .map(createDate).toProperty("createDate")
            .map(updateDate).toProperty("updateDate")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(ContactAddressInfo row) {
        return MyBatis3Utils.insert(this::insert, row, contactAddressInfo, c ->
            c.map(userId).toPropertyWhenPresent("userId", row::getUserId)
            .map(fileUploadCount).toPropertyWhenPresent("fileUploadCount", row::getFileUploadCount)
            .map(fileId).toPropertyWhenPresent("fileId", row::getFileId)
            .map(mailAddress).toPropertyWhenPresent("mailAddress", row::getMailAddress)
            .map(telNo).toPropertyWhenPresent("telNo", row::getTelNo)
            .map(mobileNo).toPropertyWhenPresent("mobileNo", row::getMobileNo)
            .map(deleteFlg).toPropertyWhenPresent("deleteFlg", row::getDeleteFlg)
            .map(createDate).toPropertyWhenPresent("createDate", row::getCreateDate)
            .map(updateDate).toPropertyWhenPresent("updateDate", row::getUpdateDate)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<ContactAddressInfo> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, contactAddressInfo, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<ContactAddressInfo> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, contactAddressInfo, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<ContactAddressInfo> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, contactAddressInfo, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<ContactAddressInfo> selectByPrimaryKey(String userId_, String fileUploadCount_, String fileId_) {
        return selectOne(c ->
            c.where(userId, isEqualTo(userId_))
            .and(fileUploadCount, isEqualTo(fileUploadCount_))
            .and(fileId, isEqualTo(fileId_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, contactAddressInfo, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(ContactAddressInfo row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(userId).equalTo(row::getUserId)
                .set(fileUploadCount).equalTo(row::getFileUploadCount)
                .set(fileId).equalTo(row::getFileId)
                .set(mailAddress).equalTo(row::getMailAddress)
                .set(telNo).equalTo(row::getTelNo)
                .set(mobileNo).equalTo(row::getMobileNo)
                .set(deleteFlg).equalTo(row::getDeleteFlg)
                .set(createDate).equalTo(row::getCreateDate)
                .set(updateDate).equalTo(row::getUpdateDate);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(ContactAddressInfo row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(userId).equalToWhenPresent(row::getUserId)
                .set(fileUploadCount).equalToWhenPresent(row::getFileUploadCount)
                .set(fileId).equalToWhenPresent(row::getFileId)
                .set(mailAddress).equalToWhenPresent(row::getMailAddress)
                .set(telNo).equalToWhenPresent(row::getTelNo)
                .set(mobileNo).equalToWhenPresent(row::getMobileNo)
                .set(deleteFlg).equalToWhenPresent(row::getDeleteFlg)
                .set(createDate).equalToWhenPresent(row::getCreateDate)
                .set(updateDate).equalToWhenPresent(row::getUpdateDate);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(ContactAddressInfo row) {
        return update(c ->
            c.set(mailAddress).equalTo(row::getMailAddress)
            .set(telNo).equalTo(row::getTelNo)
            .set(mobileNo).equalTo(row::getMobileNo)
            .set(deleteFlg).equalTo(row::getDeleteFlg)
            .set(createDate).equalTo(row::getCreateDate)
            .set(updateDate).equalTo(row::getUpdateDate)
            .where(userId, isEqualTo(row::getUserId))
            .and(fileUploadCount, isEqualTo(row::getFileUploadCount))
            .and(fileId, isEqualTo(row::getFileId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(ContactAddressInfo row) {
        return update(c ->
            c.set(mailAddress).equalToWhenPresent(row::getMailAddress)
            .set(telNo).equalToWhenPresent(row::getTelNo)
            .set(mobileNo).equalToWhenPresent(row::getMobileNo)
            .set(deleteFlg).equalToWhenPresent(row::getDeleteFlg)
            .set(createDate).equalToWhenPresent(row::getCreateDate)
            .set(updateDate).equalToWhenPresent(row::getUpdateDate)
            .where(userId, isEqualTo(row::getUserId))
            .and(fileUploadCount, isEqualTo(row::getFileUploadCount))
            .and(fileId, isEqualTo(row::getFileId))
        );
    }
}