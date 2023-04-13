package br.jus.trf2.testsigner;

import br.jus.trf2.assijus.system.api.AssijusSystemContext;
import br.jus.trf2.assijus.system.api.IAssijusSystem.IDocIdSignPut;

public class DocIdSignPut implements IDocIdSignPut {

	@Override
	public void run(Request req, Response resp, AssijusSystemContext ctx) throws Exception {
		if (req.envelope == null)
			throw new Exception("Envelope não pode ser nulo na gravação da assinatura");
		resp.status = "OK";
	}

	@Override
	public String getContext() {
		return "salvar assinatura";
	}
}