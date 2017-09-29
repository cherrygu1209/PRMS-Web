/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.radiopresenter.controller;

import at.nocturne.api.Action;
import at.nocturne.api.Perform;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sg.edu.nus.iss.phoenix.radiopresenter.delegate.ReviewSelectPresenterDelegate;
import sg.edu.nus.iss.phoenix.radiopresenter.entity.RadioPresenter;

/**
 *
 * @author Raghu
 */
@Action("managerp")
public class ManageRadioPresenterCmd implements Perform {
    @Override
    public String perform(String path, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        ReviewSelectPresenterDelegate del = new ReviewSelectPresenterDelegate();
        List<RadioPresenter> data = del.reviewSelectRadioPresenter();
        req.setAttribute("rps", data);
        return "/pages/crudrp.jsp";
    }
}
