package br.jus.trf2.testsigner;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import com.crivano.swaggerservlet.SwaggerServlet;
import com.crivano.swaggerservlet.SwaggerUtils;
import com.crivano.swaggerservlet.dependency.TestableDependency;

import br.jus.trf2.assijus.system.api.IAssijusSystem;

public class TestSignerServlet extends SwaggerServlet {
	private static final long serialVersionUID = -1611417120964698257L;

	@Override
	public void initialize(ServletConfig config) throws ServletException {
		setAPI(IAssijusSystem.class);
		setActionPackage("br.jus.trf2.testsigner");
		addPrivateProperty("password", null);
		setAuthorization(getProperty("password"));
	}
}
