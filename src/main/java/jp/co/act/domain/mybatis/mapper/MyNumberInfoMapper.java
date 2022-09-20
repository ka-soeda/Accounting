package jp.co.act.domain.mybatis.mapper;

import static jp.co.act.domain.mybatis.mapper.MyNumberInfoDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import jp.co.act.domain.mybatis.entity.MyNumberInfo;
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
public interface MyNumberInfoMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<MyNumberInfo>, CommonUpdateMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(userId, fileUploadCount, fileId, myNumber, deleteFlg, createDate, updateDate);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="MyNumberInfoResult", value = {
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="file_upload_count", property="fileUploadCount", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="file_id", property="fileId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="my_number", property="myNumber", jdbcType=JdbcType.NUMERIC),
        @Result(column="delete_flg", property="deleteFlg", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_date", property="updateDate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<MyNumberInfo> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("MyNumberInfoResult")
    Optional<MyNumberInfo> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, myNumberInfo, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, myNumberInfo, completer);
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
    default int insert(MyNumberInfo row) {
        return MyBatis3Utils.insert(this::insert, row, myNumberInfo, c ->
            c.map(userId).toProperty("userId")
            .map(fileUploadCount).toProperty("fileUploadCount")
            .map(fileId).toProperty("fileId")
            .map(myNumber).toProperty("myNumber")
            .map(deleteFlg).toProperty("deleteFlg")
            .map(createDate).toProperty("createDate")
            .map(updateDate).toProperty("updateDate")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<MyNumberInfo> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, myNumberInfo, c ->
            c.map(userId).toProperty("userId")
            .map(fileUploadCount).toProperty("fileUploadCount")
            .map(fileId).toProperty("fileId")
            .map(myNumber).toProperty("myNumber")
            .map(deleteFlg).toProperty("deleteFlg")
            .map(createDate).toProperty("createDate")
            .map(updateDate).toProperty("updateDate")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(MyNumberInfo row) {
        return MyBatis3Utils.insert(this::insert, row, myNumberInfo, c ->
            c.map(userId).toPropertyWhenPresent("userId", row::getUserId)
            .map(fileUploadCount).toPropertyWhenPresent("fileUploadCount", row::getFileUploadCount)
            .map(fileId).toPropertyWhenPresent("fileId", row::getFileId)
            .map(myNumber).toPropertyWhenPresent("myNumber", row::getMyNumber)
            .map(deleteFlg).toPropertyWhenPresent("deleteFlg", row::getDeleteFlg)
            .map(createDate).toPropertyWhenPresent("createDate", row::getCreateDate)
            .map(updateDate).toPropertyWhenPresent("updateDate", row::getUpdateDate)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<MyNumberInfo> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, myNumberInfo, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<MyNumberInfo> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, myNumberInfo, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<MyNumberInfo> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, myNumberInfo, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<MyNumberInfo> selectByPrimaryKey(String userId_, String fileUploadCount_, String fileId_) {
        return selectOne(c ->
            c.where(userId, isEqualTo(userId_))
            .and(fileUploadCount, isEqualTo(fileUploadCount_))
            .and(fileId, isEqualTo(fileId_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, myNumberInfo, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(MyNumberInfo row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(userId).equalTo(row::getUserId)
                .set(fileUploadCount).equalTo(row::getFileUploadCount)
                .set(fileId).equalTo(row::getFileId)
                .set(myNumber).equalTo(row::getMyNumber)
                .set(deleteFlg).equalTo(row::getDeleteFlg)
                .set(createDate).equalTo(row::getCreateDate)
                .set(updateDate).equalTo(row::getUpdateDate);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(MyNumberInfo row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(userId).equalToWhenPresent(row::getUserId)
                .set(fileUploadCount).equalToWhenPresent(row::getFileUploadCount)
                .set(fileId).equalToWhenPresent(row::getFileId)
                .set(myNumber).equalToWhenPresent(row::getMyNumber)
                .set(deleteFlg).equalToWhenPresent(row::getDeleteFlg)
                .set(createDate).equalToWhenPresent(row::getCreateDate)
                .set(updateDate).equalToWhenPresent(row::getUpdateDate);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(MyNumberInfo row) {
        return update(c ->
            c.set(myNumber).equalTo(row::getMyNumber)
            .set(deleteFlg).equalTo(row::getDeleteFlg)
            .set(createDate).equalTo(row::getCreateDate)
            .set(updateDate).equalTo(row::getUpdateDate)
            .where(userId, isEqualTo(row::getUserId))
            .and(fileUploadCount, isEqualTo(row::getFileUploadCount))
            .and(fileId, isEqualTo(row::getFileId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(MyNumberInfo row) {
        return update(c ->
            c.set(myNumber).equalToWhenPresent(row::getMyNumber)
            .set(deleteFlg).equalToWhenPresent(row::getDeleteFlg)
            .set(createDate).equalToWhenPresent(row::getCreateDate)
            .set(updateDate).equalToWhenPresent(row::getUpdateDate)
            .where(userId, isEqualTo(row::getUserId))
            .and(fileUploadCount, isEqualTo(row::getFileUploadCount))
            .and(fileId, isEqualTo(row::getFileId))
        );
    }
}