package br.jus.trf2.testsigner;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.SQLException;

import com.crivano.swaggerservlet.SwaggerServlet;

import br.jus.trf2.assijus.system.api.IAssijusSystem.DocIdPdfGetRequest;
import br.jus.trf2.assijus.system.api.IAssijusSystem.DocIdPdfGetResponse;
import br.jus.trf2.assijus.system.api.IAssijusSystem.IDocIdPdfGet;

public class DocIdPdfGet implements IDocIdPdfGet {

	@Override
	public void run(DocIdPdfGetRequest req, DocIdPdfGetResponse resp) throws Exception {
		PdfData pdfd = retrievePdf(req.id, req.cpf);
		resp.inputstream = new ByteArrayInputStream(pdfd.pdf);
		resp.contenttype = req.id.equals("13") ? "text/html" : "application/pdf";
		SwaggerServlet.getHttpServletResponse().addHeader("Doc-Secret", pdfd.secret);
	}

	protected static PdfData retrievePdf(String id, String cpf) throws Exception, SQLException {
		PdfData pdfd = new PdfData();
		InputStream is = DocIdPdfGet.class.getResourceAsStream(id + (id.equals("13") ? ".html" : ".pdf"));
		pdfd.pdf = Utils.convertStreamToByteArray(is, 64000);
		pdfd.secret = Utils.makeSecret(pdfd.pdf);
		return pdfd;
	}

	@Override
	public String getContext() {
		return "visualizar documento";
	}
}
