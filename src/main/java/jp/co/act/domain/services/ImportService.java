package jp.co.act.domain.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import jp.co.act.domain.mybatis.entity.ContactAddressInfo;
import jp.co.act.domain.mybatis.entity.CreditCardInfo;
import jp.co.act.domain.mybatis.entity.EgeInfo;
import jp.co.act.domain.mybatis.entity.MyNumberInfo;
import jp.co.act.domain.mybatis.entity.NameInfo;
import jp.co.act.domain.mybatis.entity.ResidenceInfo;
import jp.co.act.domain.mybatis.entity.UploadHisInfo;
import jp.co.act.domain.mybatis.entity.UserInfo;
import jp.co.act.domain.mybatis.entity.WorkplaceInfo;
import jp.co.act.domain.mybatis.mapper.ContactAddressInfoMapper;
import jp.co.act.domain.mybatis.mapper.CreditCardInfoMapper;
import jp.co.act.domain.mybatis.mapper.EgeInfoMapper;
import jp.co.act.domain.mybatis.mapper.MyNumberInfoMapper;
import jp.co.act.domain.mybatis.mapper.NameInfoMapper;
import jp.co.act.domain.mybatis.mapper.ResidenceInfoMapper;
import jp.co.act.domain.mybatis.mapper.UploadHisInfoMapper;
import jp.co.act.domain.mybatis.mapper.UserInfoMapper;
import jp.co.act.domain.mybatis.mapper.WorkplaceInfoMapper;
import jp.co.act.domain.services.dto.ImportDto;
import jp.co.act.domain.services.dto.ImportFileDataDto;

@Service
public class ImportService {

	@Autowired
	UserInfoMapper userInfoMapper;
	@Autowired
	NameInfoMapper nameInfoMapper;
	@Autowired
	EgeInfoMapper egeInfoMapper;
	@Autowired
	ContactAddressInfoMapper contactAddressInfoMapper;
	@Autowired
	ResidenceInfoMapper residenceInfoMapper;
	@Autowired
	WorkplaceInfoMapper workplaceInfoMapper;
	@Autowired
	CreditCardInfoMapper creditCardInfoMapper;
	@Autowired
	MyNumberInfoMapper myNumberInfoMapper;
	@Autowired
	UploadHisInfoMapper uploadHisInfoMapper;

	private String fileId = "csv";
	private String deleteFlg = "0";
	private LocalDateTime createUpdateTime;

	@Transactional
	public int importCsvFile(MultipartFile uploadFile) {
		// ファイル読み込み
		List<ImportFileDataDto> fileDataList = new ArrayList<ImportFileDataDto>();
		String fileData = null;
		try {
			InputStream stream = uploadFile.getInputStream();
			Reader reader = new InputStreamReader(stream);
			BufferedReader buf = new BufferedReader(reader);

			int i = 0;
			while ((fileData = buf.readLine()) != null) {
				if (i == 0) {
					i++;
					continue;
				}
				fileDataList.add(convertImportFileDataDto(fileData.split(",")));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 読み込んだ結果をエンティティに変換
		createUpdateTime = LocalDateTime.now();

		// 最新のファイルアップロード回数を取得する
		String currentFileUploadCount = getCurrentFileUploadCount();
		// TODO
		List<ImportDto> importDtoList = generateImportDtoList(fileDataList, uploadFile.getName(),
				currentFileUploadCount);
		// アップロード履歴情報テーブル
		UploadHisInfo uploadHis = new UploadHisInfo();
		uploadHis.setFileUploadCount(new BigDecimal(currentFileUploadCount));
		uploadHis.setFileId(fileId);
		uploadHis.setFileName(uploadFile.getName());
		uploadHis.setDeleteFlg(deleteFlg);
		uploadHis.setCreateDate(createUpdateTime);
		uploadHis.setUpdateDate(createUpdateTime);

		insertImportData(importDtoList, uploadHis);

		return 0;
	}

	private ImportFileDataDto convertImportFileDataDto(String[] fileData) {
		ImportFileDataDto dto = new ImportFileDataDto();
		dto.setKnjName(fileData[0]);
		dto.setHiraName(fileData[1]);
		dto.setKanaName(fileData[2]);
		dto.setRomaName(fileData[3]);
		dto.setEge(Short.parseShort(fileData[4]));
		dto.setBirthday(LocalDate.parse(fileData[5]
				.replace("年", "-")
				.replace("月", "-")
				.replace("日", "")));

		if ("男性".equals(fileData[6])) {
			dto.setSex("1");
		} else if ("女性".equals(fileData[6])) {
			dto.setSex("2");
		} else {
			dto.setSex("3");
		}

		if ("A".equals(fileData[7])) {
			dto.setBloodType("1");
		} else if ("B".equals(fileData[7])) {
			dto.setBloodType("2");
		} else if ("O".equals(fileData[7])) {
			dto.setBloodType("3");
		} else if ("AB".equals(fileData[7])) {
			dto.setBloodType("4");
		}
		dto.setMailAddress(fileData[8]);
		dto.setTelNo(fileData[9]);
		dto.setMobileNo(fileData[10]);
		dto.setPostalCode(fileData[11]);
		dto.setAddress(fileData[12]);
		dto.setCompanyNm(fileData[13]);
		dto.setCreditCard(Long.valueOf(fileData[14]));
		dto.setEffectiveDate(fileData[15]);
		dto.setMyNumber(Long.valueOf(fileData[16]));
		return dto;
	}

	private List<ImportDto> generateImportDtoList(List<ImportFileDataDto> fileDataList,
			String fileName, String currentFileUploadCount) {

		List<ImportDto> dtoList = new ArrayList<ImportDto>();
		AtomicInteger userIdNo = new AtomicInteger();
		fileDataList.stream().forEach(e -> {
			String userId = String.valueOf(userIdNo.getAndIncrement());
			dtoList.add(generateImportDto(e, String.format("%20s", userId).replace(" ", "0"), currentFileUploadCount,
					fileName));
		});

		return dtoList;
	}

	private ImportDto generateImportDto(ImportFileDataDto fileData, String userId, String currentFileUploadCount,
			String fileName) {
		ImportDto dto = new ImportDto();

		// ユーザ情報テーブル
		UserInfo user = new UserInfo();
		user.setUserId(userId);
		user.setFileUploadCount(currentFileUploadCount);
		user.setFileId(fileId);
		user.setSex(fileData.getSex());
		user.setBloodType(fileData.getBloodType());
		user.setDeleteFlg(deleteFlg);
		user.setCreateDate(createUpdateTime);
		user.setUpdateDate(createUpdateTime);
		dto.setUserInfo(user);

		//氏名情報テーブル
		NameInfo name;
		List<NameInfo> nameList = dto.getNameInfoList();
		// 氏名（漢字）が入力されている場合
		if (!fileData.getKnjName().isBlank()) {
			name = new NameInfo();
			name.setUserId(userId);
			name.setFileUploadCount(currentFileUploadCount);
			name.setFileId(fileId);
			name.setNameId("1");
			name.setName(fileData.getKnjName());
			name.setNameKbn("1");
			name.setDeleteFlg(deleteFlg);
			name.setCreateDate(createUpdateTime);
			name.setUpdateDate(createUpdateTime);
			nameList.add(name);
		}

		// 氏名（ひらがな）が入力されている場合
		if (!fileData.getHiraName().isBlank()) {
			name = new NameInfo();
			name.setUserId(userId);
			name.setFileUploadCount(currentFileUploadCount);
			name.setFileId(fileId);
			name.setNameId("2");
			name.setName(fileData.getHiraName());
			name.setNameKbn("2");
			name.setDeleteFlg(deleteFlg);
			name.setCreateDate(createUpdateTime);
			name.setUpdateDate(createUpdateTime);
			nameList.add(name);
		}

		// 氏名（カタカナ）が入力されている場合
		if (!fileData.getKanaName().isBlank()) {
			name = new NameInfo();
			name.setUserId(userId);
			name.setFileUploadCount(currentFileUploadCount);
			name.setFileId(fileId);
			name.setNameId("3");
			name.setName(fileData.getKanaName());
			name.setNameKbn("3");
			name.setDeleteFlg(deleteFlg);
			name.setCreateDate(createUpdateTime);
			name.setUpdateDate(createUpdateTime);
			nameList.add(name);
		}

		// 氏名（ローマ字）が入力されている場合
		if (!fileData.getRomaName().isBlank()) {
			name = new NameInfo();
			name.setUserId(userId);
			name.setFileUploadCount(currentFileUploadCount);
			name.setFileId(fileId);
			name.setNameId("4");
			name.setName(fileData.getRomaName());
			name.setNameKbn("4");
			name.setDeleteFlg(deleteFlg);
			name.setCreateDate(createUpdateTime);
			name.setUpdateDate(createUpdateTime);
			nameList.add(name);
		}

		dto.setNameInfoList(nameList);

		// 年齢情報テーブル
		EgeInfo ege = new EgeInfo();
		ege.setUserId(userId);
		ege.setFileUploadCount(currentFileUploadCount);
		ege.setFileId(fileId);
		ege.setEge(fileData.getEge());
		ege.setBirthday(fileData.getBirthday());
		ege.setDeleteFlg(deleteFlg);
		ege.setCreateDate(createUpdateTime);
		ege.setUpdateDate(createUpdateTime);
		dto.setEgeInfo(ege);

		// 連絡先情報テーブル
		ContactAddressInfo contactAddress = new ContactAddressInfo();
		contactAddress.setUserId(userId);
		contactAddress.setFileUploadCount(currentFileUploadCount);
		contactAddress.setFileId(fileId);
		contactAddress.setMailAddress(fileData.getMailAddress());
		contactAddress.setTelNo(fileData.getTelNo());
		contactAddress.setMobileNo(fileData.getMobileNo());
		contactAddress.setDeleteFlg(deleteFlg);
		contactAddress.setCreateDate(createUpdateTime);
		contactAddress.setUpdateDate(createUpdateTime);
		dto.setContactAddressInfo(contactAddress);

		// 住居情報テーブル
		ResidenceInfo residence = new ResidenceInfo();
		residence.setUserId(userId);
		residence.setFileUploadCount(currentFileUploadCount);
		residence.setFileId(fileId);
		residence.setPostalCode(fileData.getPostalCode());
		residence.setAddress(fileData.getAddress());
		residence.setDeleteFlg(deleteFlg);
		residence.setCreateDate(createUpdateTime);
		residence.setUpdateDate(createUpdateTime);
		dto.setResidenceInfo(residence);

		// 勤務先情報テーブル
		WorkplaceInfo workplace = new WorkplaceInfo();
		workplace.setUserId(userId);
		workplace.setFileUploadCount(currentFileUploadCount);
		workplace.setFileId(fileId);
		workplace.setCompanyNm(fileData.getCompanyNm());
		workplace.setDeleteFlg(deleteFlg);
		workplace.setCreateDate(createUpdateTime);
		workplace.setUpdateDate(createUpdateTime);
		dto.setWorkplaceInfo(workplace);

		// クレジットカード情報テーブル
		CreditCardInfo creditCard = new CreditCardInfo();
		creditCard.setUserId(userId);
		creditCard.setFileUploadCount(currentFileUploadCount);
		creditCard.setFileId(fileId);
		creditCard.setCreditCard(fileData.getCreditCard());
		creditCard.setEffectiveDate(fileData.getEffectiveDate());
		creditCard.setDeleteFlg(deleteFlg);
		creditCard.setCreateDate(createUpdateTime);
		creditCard.setUpdateDate(createUpdateTime);
		dto.setCreditCardInfo(creditCard);

		// マイナンバー情報テーブル
		MyNumberInfo myNumber = new MyNumberInfo();
		myNumber.setUserId(userId);
		myNumber.setFileUploadCount(currentFileUploadCount);
		myNumber.setFileId(fileId);
		myNumber.setMyNumber(fileData.getMyNumber());
		myNumber.setDeleteFlg(deleteFlg);
		myNumber.setCreateDate(createUpdateTime);
		myNumber.setUpdateDate(createUpdateTime);
		dto.setMyNumberInfo(myNumber);

		//		// アップロード履歴情報テーブル
		//		UploadHisInfo uploadHis = new UploadHisInfo();
		//		uploadHis.setFileUploadCount(new BigDecimal(currentFileUploadCount));
		//		uploadHis.setFileId(fileId);
		//		uploadHis.setFileName(fileName);
		//		uploadHis.setDeleteFlg(deleteFlg);
		//		uploadHis.setCreateDate(createUpdateTime);
		//		uploadHis.setUpdateDate(createUpdateTime);
		//		dto.setUploadHisInfo(uploadHis);

		return dto;
	}

	private String getCurrentFileUploadCount() {
		List<UserInfo> userInfoList = userInfoMapper
				.select(c -> c);
		Long maxFileUploadCount = Long.parseLong(userInfoList.stream()
				.max(Comparator.comparing(UserInfo::getFileUploadCount))
				.get().getFileUploadCount());
		return String.valueOf(maxFileUploadCount + 1);
	}

	private void insertImportData(List<ImportDto> importDtoList, UploadHisInfo uploadHis) {
		// 氏名情報テーブルを集約
		List<NameInfo> nameInfoList = new ArrayList<NameInfo>();
		importDtoList.stream().flatMap(e -> e.getNameInfoList().stream()).forEach(e -> {
			nameInfoList.add(e);
		});

		userInfoMapper.delete(c -> c);
		List<UserInfo> userInfoList = importDtoList.stream().map(e -> e.getUserInfo()).collect(Collectors.toList());
		userInfoMapper.insertMultiple(userInfoList);
		nameInfoMapper.delete(c -> c);
		nameInfoMapper.insertMultiple(nameInfoList);
		egeInfoMapper.delete(c -> c);
		egeInfoMapper.insertMultiple(importDtoList.stream().map(e -> e.getEgeInfo()).collect(Collectors.toList()));
		contactAddressInfoMapper.delete(c -> c);
		contactAddressInfoMapper.insertMultiple(
				importDtoList.stream().map(e -> e.getContactAddressInfo()).collect(Collectors.toList()));
		residenceInfoMapper.delete(c -> c);
		residenceInfoMapper
				.insertMultiple(importDtoList.stream().map(e -> e.getResidenceInfo()).collect(Collectors.toList()));
		workplaceInfoMapper.delete(c -> c);
		workplaceInfoMapper
				.insertMultiple(importDtoList.stream().map(e -> e.getWorkplaceInfo()).collect(Collectors.toList()));
		creditCardInfoMapper.delete(c -> c);
		creditCardInfoMapper
				.insertMultiple(importDtoList.stream().map(e -> e.getCreditCardInfo()).collect(Collectors.toList()));
		myNumberInfoMapper.delete(c -> c);
		myNumberInfoMapper
				.insertMultiple(importDtoList.stream().map(e -> e.getMyNumberInfo()).collect(Collectors.toList()));

		uploadHisInfoMapper.delete(c -> c);
		uploadHisInfoMapper
				.insert(uploadHis);

	}
}
