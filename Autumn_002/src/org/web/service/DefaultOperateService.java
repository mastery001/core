package org.web.service;

import org.web.exception.DBException;
import org.web.exception.ErrorException;

import tool.mastery.log.Logger;

public class DefaultOperateService extends OperateService {

	public static final Logger LOG = Logger.getLogger(DefaultOperateService.class);
	
	@Override
	protected void save() throws ErrorException {
		String errorMessage = "";
		for (int i = 0; i < list.size(); i++) {
			try {
				dao.save(list.get(i));
			} catch (DBException e) {
				LOG.debug(e.getMessage() , e);
				errorMessage += e.getMessage();
			}
		}
		if (!errorMessage.equals("")) {
			throw new ErrorException(errorMessage);
		}
	}

	@Override
	protected void update() throws ErrorException {
		String errorMessage = "";
		for (int i = 0; i < list.size(); i++) {
			try {
				dao.update(list.get(i));
			} catch (DBException e) {
				LOG.debug(e.getMessage() , e);
				errorMessage += e.getMessage();
			}
		}
		if (!errorMessage.equals("")) {
			throw new ErrorException(errorMessage);
		}
	}

	@Override
	protected void delete() throws ErrorException {
		String errorMessage = "";
		for (int i = 0; i < list.size(); i++) {
			try {
				dao.delete(list.get(i));
			} catch (DBException e) {
				LOG.debug(e.getMessage() , e);
				errorMessage += e.getMessage();
			}
		}
		if (!errorMessage.equals("")) {
			throw new ErrorException(errorMessage);
		}
	}
}
