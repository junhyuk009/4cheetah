package controller.memberpage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;

public class LoginPageAction implements Action {
   
   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

      ActionForward forward = new ActionForward();

      // 🔥 redirect → forward 로 변경 (쿼리스트링 유지)
      forward.setPath("login.jsp");
      forward.setRedirect(false);

      return forward;
   }
}
