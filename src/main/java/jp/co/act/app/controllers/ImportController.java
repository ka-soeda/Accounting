package jp.co.act.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jp.co.act.domain.services.ImportService;

/**
 * 取込画面Controller
 */
@Controller
public class ImportController {

	@Autowired
	ImportService service;

	/**
	 * 取込画面初期表示
	 *
	 * @param model Model
	 * @return 取込画面
	 */
	@GetMapping(value = "/import/init")
	public String init(Model model) {
		model.addAttribute("name", "テスト");
		return "/import";
	}

	@RequestMapping(value = "/import/upload", method = RequestMethod.POST)
	public String upload(@RequestParam("upload_file") MultipartFile uploadFile, Model model) {
		// ファイルが空の場合は異常終了
		if ("空ファイル.csv".equals(uploadFile.getOriginalFilename())) {
			// 異常終了時の処理
		}

		service.importCsvFile(uploadFile);

		model.addAttribute("name", "aaaa");
		return "/import";
	}

}
