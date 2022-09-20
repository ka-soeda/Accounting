package jp.co.act.domain.services.dto;

import java.util.ArrayList;
import java.util.List;

import jp.co.act.domain.mybatis.entity.ContactAddressInfo;
import jp.co.act.domain.mybatis.entity.CreditCardInfo;
import jp.co.act.domain.mybatis.entity.EgeInfo;
import jp.co.act.domain.mybatis.entity.MyNumberInfo;
import jp.co.act.domain.mybatis.entity.NameInfo;
import jp.co.act.domain.mybatis.entity.ResidenceInfo;
import jp.co.act.domain.mybatis.entity.UserInfo;
import jp.co.act.domain.mybatis.entity.WorkplaceInfo;
import lombok.Data;

@Data
public class ImportDto {

	// ユーザ情報テーブル（マスタ）
	UserInfo userInfo;
	// 氏名情報テーブル
	List<NameInfo> nameInfoList = new ArrayList<>();
	// 年齢情報テーブル
	EgeInfo egeInfo;
	// 連絡先情報テーブル
	ContactAddressInfo contactAddressInfo;
	// 住居情報テーブル
	ResidenceInfo residenceInfo;
	// 勤務先情報テーブル
	WorkplaceInfo workplaceInfo;
	// クレジットカード情報テーブル
	CreditCardInfo creditCardInfo;
	// マイナンバー情報テーブル
	MyNumberInfo myNumberInfo;
}
