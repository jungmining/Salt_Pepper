package com.min.edu.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.db.SqlSessionFactoryManager;
import com.min.edu.vo.AnimalHospitalDto;

public class AnimalDaoImpl implements IAnimalDao {
	
	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
	private final String NS = "com.min.edu.model.AnimalDaoImpl.";
	private Logger logger = Logger.getLogger(this.getClass());

	@Override
	public int animalHospitalInsert(List<AnimalHospitalDto> dto) {
		logger.info("insert되는지 :"+dto.size());
		int cnt = 0;
		SqlSession session = manager.openSession();
		for(AnimalHospitalDto aDto : dto) {
			cnt += session.insert(NS+"animalInsert",aDto);
		}
		session.commit();
		logger.info("cnt 값 있는지 :"+cnt);
		return cnt;
	}

	@Override
	public int animalHospitalDelete() {
		logger.info("delete되는지 확인");
		SqlSession session = manager.openSession(true);
		return session.delete(NS+"animalDelete");
	}

}
