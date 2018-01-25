package com.kabank.mvc.command;

import java.util.List;

import com.kabank.mvc.domain.AttendBean;
import com.kabank.mvc.domain.FoodBean;
import com.kabank.mvc.domain.KakaoBean;
import com.kabank.mvc.domain.LottoBean;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.domain.MobileBean;
import com.kabank.mvc.enums.Action;

import lombok.Data;

@Data
public class Command{
	protected String cmd, dir, page, view, column, data, sql;
	protected Action action;
	protected MemberBean member;
	protected KakaoBean kakao;
	protected MobileBean mobile;
	protected FoodBean food;
	protected LottoBean lotto;
	protected AttendBean attend;
	protected List<MemberBean> members;
	protected List<KakaoBean> kakaos;
	protected List<MobileBean> mobiles;
	protected List<FoodBean> foods;
	protected List<LottoBean> lottos;
	protected List<AttendBean> attends;
	//상속잡을 생각이니까 protected
}
