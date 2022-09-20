package jp.co.act.domain.services.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ImportFileDataDto {
	// 氏名(漢字)
	private String knjName;
	// 氏名（ひらがな）
	private String hiraName;
	// 氏名（カタカナ）
	private String kanaName;
	// 氏名（ローマ字）
	private String romaName;
	// 年齢
	private Short ege;
	// 生年月日
	private LocalDate birthday;
	// 性別
	private String sex;
	// 血液型
	private String bloodType;
	// メールアドレス
	private String mailAddress;
	// 電話番号
	private String telNo;
	// 携帯電話番号
	private String mobileNo;
	// 郵便番号
	private String postalCode;
	// 住所
	private String address;
	// 会社名
	private String companyNm;
	// クレジットカード
	private Long creditCard;
	// 有効期限
	private String effectiveDate;
	// マイナンバー
	private Long myNumber;
}
