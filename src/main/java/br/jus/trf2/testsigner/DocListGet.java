package br.jus.trf2.testsigner;

import java.util.ArrayList;

import br.jus.trf2.assijus.system.api.AssijusSystemContext;
import br.jus.trf2.assijus.system.api.IAssijusSystem.Document;
import br.jus.trf2.assijus.system.api.IAssijusSystem.IDocListGet;

public class DocListGet implements IDocListGet {
	private static final String[] DOCS = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12",
			"13" };

	@Override
	public void run(Request req, Response resp, AssijusSystemContext ctx) throws Exception {
		resp.list = new ArrayList<>();

		for (String s : DOCS) {
			Document doc = new Document();

			doc.id = s;
			doc.code = "DOC/" + s;
			doc.descr = "Documento número: " + s;
			doc.kind = "Documento";
			doc.origin = "Test";
			doc.secret = DocIdPdfGet.retrievePdf(s, req.cpf).secret;
			resp.list.add(doc);
		}
	}

	@Override
	public String getContext() {
		return "listar documentos";
	}

}
