package br.jus.trf2.testsigner;

import br.jus.trf2.assijus.system.api.IAssijusSystem.DocIdHashGetRequest;
import br.jus.trf2.assijus.system.api.IAssijusSystem.DocIdHashGetResponse;
import br.jus.trf2.assijus.system.api.IAssijusSystem.IDocIdHashGet;

public class DocIdHashGet implements IDocIdHashGet {
	@Override
	public void run(DocIdHashGetRequest req, DocIdHashGetResponse resp) throws Exception {
		PdfData pdfd = DocIdPdfGet.retrievePdf(req.id, req.cpf);

		// Produce response
		resp.sha1 = Utils.calcSha1(pdfd.pdf);
		resp.sha256 = Utils.calcSha256(pdfd.pdf);

		resp.doc = pdfd.pdf;
		resp.secret = pdfd.secret;
	}

	@Override
	public String getContext() {
		return "obter o hash";
	}
}
