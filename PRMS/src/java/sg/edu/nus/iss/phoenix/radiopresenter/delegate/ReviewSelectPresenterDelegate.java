/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.radiopresenter.delegate;

/**
 *
 * @author Raghu
 */


import java.util.List;
import sg.edu.nus.iss.phoenix.radiopresenter.entity.RadioPresenter;
import sg.edu.nus.iss.phoenix.radiopresenter.service.ReviewSelectPresenterService;

public class ReviewSelectPresenterDelegate {
    private ReviewSelectPresenterService service;
    
	public ReviewSelectPresenterDelegate() {
		service = new ReviewSelectPresenterService();
	}
	
	public List<RadioPresenter> reviewSelectRadioPresenter() {
		return service.reviewSelectRadioPresenter();	
	}

}
