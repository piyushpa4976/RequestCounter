package spring.RequestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.dao.RequestDao;

@Service
@Transactional(readOnly = true)
public class Request_ServiceImp implements Request_Service {

	@Autowired
	private RequestDao requestDao;

	
	@Override
	public long getRequestCount() {
		// TODO Auto-generated method stub
		return requestDao.getRequestCount();
	}

	@Transactional
	@Override
	public void setRequestCount() {
		// TODO Auto-generated method stub
		requestDao.setRequestCount();
		
	}

	@Transactional
	@Override
	public void resetcount() {
		// TODO Auto-generated method stub
		requestDao.resetcount();
		
	}


}
