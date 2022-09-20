package jp.co.act.domain.mybatis.mapper;

import static jp.co.act.domain.mybatis.mapper.UploadHisInfoDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import jp.co.act.domain.mybatis.entity.UploadHisInfo;
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
public interface UploadHisInfoMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<UploadHisInfo>, CommonUpdateMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(fileUploadCount, fileId, fileName, deleteFlg, createDate, updateDate);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="UploadHisInfoResult", value = {
        @Result(column="file_upload_count", property="fileUploadCount", jdbcType=JdbcType.NUMERIC, id=true),
        @Result(column="file_id", property="fileId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="file_name", property="fileName", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="delete_flg", property="deleteFlg", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_date", property="updateDate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<UploadHisInfo> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("UploadHisInfoResult")
    Optional<UploadHisInfo> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, uploadHisInfo, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, uploadHisInfo, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(BigDecimal fileUploadCount_, String fileId_, String fileName_) {
        return delete(c -> 
            c.where(fileUploadCount, isEqualTo(fileUploadCount_))
            .and(fileId, isEqualTo(fileId_))
            .and(fileName, isEqualTo(fileName_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(UploadHisInfo row) {
        return MyBatis3Utils.insert(this::insert, row, uploadHisInfo, c ->
            c.map(fileUploadCount).toProperty("fileUploadCount")
            .map(fileId).toProperty("fileId")
            .map(fileName).toProperty("fileName")
            .map(deleteFlg).toProperty("deleteFlg")
            .map(createDate).toProperty("createDate")
            .map(updateDate).toProperty("updateDate")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<UploadHisInfo> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, uploadHisInfo, c ->
            c.map(fileUploadCount).toProperty("fileUploadCount")
            .map(fileId).toProperty("fileId")
            .map(fileName).toProperty("fileName")
            .map(deleteFlg).toProperty("deleteFlg")
            .map(createDate).toProperty("createDate")
            .map(updateDate).toProperty("updateDate")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(UploadHisInfo row) {
        return MyBatis3Utils.insert(this::insert, row, uploadHisInfo, c ->
            c.map(fileUploadCount).toPropertyWhenPresent("fileUploadCount", row::getFileUploadCount)
            .map(fileId).toPropertyWhenPresent("fileId", row::getFileId)
            .map(fileName).toPropertyWhenPresent("fileName", row::getFileName)
            .map(deleteFlg).toPropertyWhenPresent("deleteFlg", row::getDeleteFlg)
            .map(createDate).toPropertyWhenPresent("createDate", row::getCreateDate)
            .map(updateDate).toPropertyWhenPresent("updateDate", row::getUpdateDate)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<UploadHisInfo> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, uploadHisInfo, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<UploadHisInfo> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, uploadHisInfo, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<UploadHisInfo> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, uploadHisInfo, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<UploadHisInfo> selectByPrimaryKey(BigDecimal fileUploadCount_, String fileId_, String fileName_) {
        return selectOne(c ->
            c.where(fileUploadCount, isEqualTo(fileUploadCount_))
            .and(fileId, isEqualTo(fileId_))
            .and(fileName, isEqualTo(fileName_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, uploadHisInfo, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(UploadHisInfo row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(fileUploadCount).equalTo(row::getFileUploadCount)
                .set(fileId).equalTo(row::getFileId)
                .set(fileName).equalTo(row::getFileName)
                .set(deleteFlg).equalTo(row::getDeleteFlg)
                .set(createDate).equalTo(row::getCreateDate)
                .set(updateDate).equalTo(row::getUpdateDate);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(UploadHisInfo row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(fileUploadCount).equalToWhenPresent(row::getFileUploadCount)
                .set(fileId).equalToWhenPresent(row::getFileId)
                .set(fileName).equalToWhenPresent(row::getFileName)
                .set(deleteFlg).equalToWhenPresent(row::getDeleteFlg)
                .set(createDate).equalToWhenPresent(row::getCreateDate)
                .set(updateDate).equalToWhenPresent(row::getUpdateDate);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(UploadHisInfo row) {
        return update(c ->
            c.set(deleteFlg).equalTo(row::getDeleteFlg)
            .set(createDate).equalTo(row::getCreateDate)
            .set(updateDate).equalTo(row::getUpdateDate)
            .where(fileUploadCount, isEqualTo(row::getFileUploadCount))
            .and(fileId, isEqualTo(row::getFileId))
            .and(fileName, isEqualTo(row::getFileName))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(UploadHisInfo row) {
        return update(c ->
            c.set(deleteFlg).equalToWhenPresent(row::getDeleteFlg)
            .set(createDate).equalToWhenPresent(row::getCreateDate)
            .set(updateDate).equalToWhenPresent(row::getUpdateDate)
            .where(fileUploadCount, isEqualTo(row::getFileUploadCount))
            .and(fileId, isEqualTo(row::getFileId))
            .and(fileName, isEqualTo(row::getFileName))
        );
    }
}