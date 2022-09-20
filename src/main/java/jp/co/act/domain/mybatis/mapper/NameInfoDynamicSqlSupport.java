package jp.co.act.domain.mybatis.mapper;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class NameInfoDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final NameInfo nameInfo = new NameInfo();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> userId = nameInfo.userId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> fileUploadCount = nameInfo.fileUploadCount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> fileId = nameInfo.fileId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> nameId = nameInfo.nameId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> name = nameInfo.name;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> nameKbn = nameInfo.nameKbn;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> deleteFlg = nameInfo.deleteFlg;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> createDate = nameInfo.createDate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> updateDate = nameInfo.updateDate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class NameInfo extends AliasableSqlTable<NameInfo> {
        public final SqlColumn<String> userId = column("user_id", JDBCType.VARCHAR);

        public final SqlColumn<String> fileUploadCount = column("file_upload_count", JDBCType.VARCHAR);

        public final SqlColumn<String> fileId = column("file_id", JDBCType.VARCHAR);

        public final SqlColumn<String> nameId = column("name_id", JDBCType.VARCHAR);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<String> nameKbn = column("name_kbn", JDBCType.VARCHAR);

        public final SqlColumn<String> deleteFlg = column("delete_flg", JDBCType.VARCHAR);

        public final SqlColumn<LocalDateTime> createDate = column("create_date", JDBCType.TIMESTAMP);

        public final SqlColumn<LocalDateTime> updateDate = column("update_date", JDBCType.TIMESTAMP);

        public NameInfo() {
            super("section_five.name_info", NameInfo::new);
        }
    }
}