package jp.co.act.domain.mybatis.mapper;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class CreditCardInfoDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final CreditCardInfo creditCardInfo = new CreditCardInfo();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> userId = creditCardInfo.userId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> fileUploadCount = creditCardInfo.fileUploadCount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> fileId = creditCardInfo.fileId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> creditCard = creditCardInfo.creditCard;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> effectiveDate = creditCardInfo.effectiveDate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> deleteFlg = creditCardInfo.deleteFlg;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> createDate = creditCardInfo.createDate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> updateDate = creditCardInfo.updateDate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class CreditCardInfo extends AliasableSqlTable<CreditCardInfo> {
        public final SqlColumn<String> userId = column("user_id", JDBCType.VARCHAR);

        public final SqlColumn<String> fileUploadCount = column("file_upload_count", JDBCType.VARCHAR);

        public final SqlColumn<String> fileId = column("file_id", JDBCType.VARCHAR);

        public final SqlColumn<Long> creditCard = column("credit_card", JDBCType.NUMERIC);

        public final SqlColumn<String> effectiveDate = column("effective_date", JDBCType.VARCHAR);

        public final SqlColumn<String> deleteFlg = column("delete_flg", JDBCType.VARCHAR);

        public final SqlColumn<LocalDateTime> createDate = column("create_date", JDBCType.TIMESTAMP);

        public final SqlColumn<LocalDateTime> updateDate = column("update_date", JDBCType.TIMESTAMP);

        public CreditCardInfo() {
            super("section_five.credit_card_info", CreditCardInfo::new);
        }
    }
}