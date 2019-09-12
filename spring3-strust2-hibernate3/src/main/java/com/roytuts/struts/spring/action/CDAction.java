package com.roytuts.struts.spring.action;

import java.util.List;

import org.apache.struts2.dispatcher.DefaultActionSupport;

import com.roytuts.struts.spring.service.CDService;
import com.roytuts.struts.spring.vo.Cd;

public class CDAction extends DefaultActionSupport {

	private static final long serialVersionUID = 1L;
	private List<Cd> cds;
	private CDService cdService;

	public List<Cd> getCds() {
		return cds;
	}

	public void setCds(List<Cd> cds) {
		this.cds = cds;
	}

	public CDService getCdService() {
		return cdService;
	}

	public void setCdService(CDService cdService) {
		this.cdService = cdService;
	}

	public String getListOfCds() {
		if (cds == null) {
			cds = cdService.getCDs();
		}
		return SUCCESS;
	}
}
