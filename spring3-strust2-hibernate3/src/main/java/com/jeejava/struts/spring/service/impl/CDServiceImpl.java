package com.jeejava.struts.spring.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.jeejava.struts.spring.dao.CDDao;
import com.jeejava.struts.spring.domain.Cds;
import com.jeejava.struts.spring.service.CDService;
import com.jeejava.struts.spring.vo.Cd;

public class CDServiceImpl implements CDService {
	private CDDao cdDao;

	public CDDao getCdDao() {
		return cdDao;
	}

	public void setCdDao(CDDao cdDao) {
		this.cdDao = cdDao;
	}

	@Override
	public List<Cd> getCDs() {
		List<Cds> cds = cdDao.getCDs();
		List<Cd> list = new ArrayList<Cd>();
		for (Cds c : cds) {
			Cd cd = new Cd();
			cd.setId(c.getId());
			cd.setTitle(c.getTitle());
			cd.setInterpret(c.getInterpret());
			list.add(cd);
		}
		return list;
	}
}
