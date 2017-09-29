/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.radiopresenter.service;

/**
 *
 * @author Raghu
 */
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import sg.edu.nus.iss.phoenix.core.dao.DAOFactoryImpl;
import sg.edu.nus.iss.phoenix.radiopresenter.dao.PresenterDAO;
import sg.edu.nus.iss.phoenix.radiopresenter.entity.RadioPresenter;

public class ReviewSelectPresenterService {
	DAOFactoryImpl factory;
	PresenterDAO rpdao;

	public ReviewSelectPresenterService() {
		super();
		// TODO Auto-generated constructor stub
		factory = new DAOFactoryImpl();
		rpdao = factory.getPresenterDAO();
	}

	public List<RadioPresenter> reviewSelectRadioPresenter() throws SQLException {
            List<RadioPresenter> data = null;
            data = rpdao.loadAll();
            return data; 
	}

}
