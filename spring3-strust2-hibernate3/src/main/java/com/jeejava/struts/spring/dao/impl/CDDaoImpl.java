package com.jeejava.struts.spring.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.jeejava.struts.spring.dao.CDDao;
import com.jeejava.struts.spring.domain.Cds;

public class CDDaoImpl extends HibernateDaoSupport implements CDDao {

	@Override
	@SuppressWarnings("unchecked")
	public List<Cds> getCDs() {
		List<Cds> cds = getHibernateTemplate().find("from Cds");
		return cds;
	}

}
