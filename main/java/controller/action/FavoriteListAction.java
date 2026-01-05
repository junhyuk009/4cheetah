package controller.action;

import javax.servlet.http.*;

import controller.common.Action;
import controller.common.ActionForward;
import model.dao.PlaceDAO;
import java.util.List;
import model.dto.PlaceDTO;

public class FavoriteListAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
        PlaceDAO dao = new PlaceDAO();
        List<PlaceDTO> list = dao.selectAll();
        request.setAttribute("list", list);

        ActionForward forward = new ActionForward();
        forward.setRedirect(false);
        forward.setPath("favoriteList.jsp");
        return forward;
    }
}
