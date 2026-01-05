package controller.action;

import javax.servlet.http.*;

import controller.common.Action;
import controller.common.ActionForward;
import model.dao.PlaceDAO;
import model.dto.PlaceDTO;

public class AddFavoriteAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response)throws Exception {

        String name = request.getParameter("name");
        String address = request.getParameter("address");
        double lat = Double.parseDouble(request.getParameter("lat"));
        double lng = Double.parseDouble(request.getParameter("lng"));

        PlaceDAO dao = new PlaceDAO();
        PlaceDTO dto = new PlaceDTO();

        // PLACE 테이블 ID 증가 (단순 MAX+1)
        int newId = dao.selectAll().size() + 1;
        dto.setId(newId);
        dto.setName(name);
        dto.setAddress(address);
        dto.setLat(lat);
        dto.setLng(lng);

        dao.insert(dto);

        ActionForward forward = new ActionForward();
        forward.setRedirect(true);
        forward.setPath("index.jsp");
        return forward;
    }
}
