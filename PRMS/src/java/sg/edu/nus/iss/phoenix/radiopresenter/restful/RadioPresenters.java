/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.radiopresenter.restful;

import java.util.List;
import sg.edu.nus.iss.phoenix.radiopresenter.entity.RadioPresenter;

/**
 *
 * @author Raghu
 */
public class RadioPresenters {
      private List <RadioPresenter> rpList;

    public List<RadioPresenter> getRpList() {
        return rpList;
    }
 
    public void setRpList(List<RadioPresenter> rpList) {
        this.rpList = rpList;
    }
}
