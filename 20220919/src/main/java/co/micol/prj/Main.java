package co.micol.prj;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.common.Command;

public class Main implements Command {

	@Override
	public String esec(HttpServletRequest request, HttpServletResponse response) {
		return "main/main";
	}

}
