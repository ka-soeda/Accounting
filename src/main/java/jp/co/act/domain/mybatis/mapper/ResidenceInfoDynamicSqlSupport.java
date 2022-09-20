package jp.co.act.domain.mybatis.mapper;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class ResidenceInfoDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final ResidenceInfo residenceInfo = new ResidenceInfo();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> userId = residenceInfo.userId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> fileUploadCount = residenceInfo.fileUploadCount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> fileId = residenceInfo.fileId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> postalCode = residenceInfo.postalCode;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> address = residenceInfo.address;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> deleteFlg = residenceInfo.deleteFlg;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> createDate = residenceInfo.createDate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> updateDate = residenceInfo.updateDate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class ResidenceInfo extends AliasableSqlTable<ResidenceInfo> {
        public final SqlColumn<String> userId = column("user_id", JDBCType.VARCHAR);

        public final SqlColumn<String> fileUploadCount = column("file_upload_count", JDBCType.VARCHAR);

        public final SqlColumn<String> fileId = column("file_id", JDBCType.VARCHAR);

        public final SqlColumn<String> postalCode = column("postal_code", JDBCType.VARCHAR);

        public final SqlColumn<String> address = column("address", JDBCType.VARCHAR);

        public final SqlColumn<String> deleteFlg = column("delete_flg", JDBCType.VARCHAR);

        public final SqlColumn<LocalDateTime> createDate = column("create_date", JDBCType.TIMESTAMP);

        public final SqlColumn<LocalDateTime> updateDate = column("update_date", JDBCType.TIMESTAMP);

        public ResidenceInfo() {
            super("section_five.residence_info", ResidenceInfo::new);
        }
    }
}