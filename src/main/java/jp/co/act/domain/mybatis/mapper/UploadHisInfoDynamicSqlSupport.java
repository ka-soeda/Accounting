package jp.co.act.domain.mybatis.mapper;

import java.math.BigDecimal;
import java.sql.JDBCType;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class UploadHisInfoDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final UploadHisInfo uploadHisInfo = new UploadHisInfo();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<BigDecimal> fileUploadCount = uploadHisInfo.fileUploadCount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> fileId = uploadHisInfo.fileId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> fileName = uploadHisInfo.fileName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> deleteFlg = uploadHisInfo.deleteFlg;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> createDate = uploadHisInfo.createDate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> updateDate = uploadHisInfo.updateDate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class UploadHisInfo extends AliasableSqlTable<UploadHisInfo> {
        public final SqlColumn<BigDecimal> fileUploadCount = column("file_upload_count", JDBCType.NUMERIC);

        public final SqlColumn<String> fileId = column("file_id", JDBCType.VARCHAR);

        public final SqlColumn<String> fileName = column("file_name", JDBCType.VARCHAR);

        public final SqlColumn<String> deleteFlg = column("delete_flg", JDBCType.VARCHAR);

        public final SqlColumn<LocalDateTime> createDate = column("create_date", JDBCType.TIMESTAMP);

        public final SqlColumn<LocalDateTime> updateDate = column("update_date", JDBCType.TIMESTAMP);

        public UploadHisInfo() {
            super("section_five.upload_his_info", UploadHisInfo::new);
        }
    }
}