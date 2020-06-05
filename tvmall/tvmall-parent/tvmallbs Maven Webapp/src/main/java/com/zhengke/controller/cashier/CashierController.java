package com.zhengke.controller.cashier;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhengke.controller.common.BaseController;

@Controller
@RequestMapping("cashier")
public class CashierController extends BaseController {

	/**
	 * 到收银台页面
	 * @return
	 */
	@RequestMapping("toCashiermgr.do")
	public String toCashierMgr() {
		return "cashier/cashierDesk";
	}
}
