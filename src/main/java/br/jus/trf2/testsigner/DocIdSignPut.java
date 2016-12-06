package br.jus.trf2.testsigner;

import java.io.ByteArrayInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

import br.jus.trf2.assijus.system.api.IAssijusSystem.DocIdSignPutRequest;
import br.jus.trf2.assijus.system.api.IAssijusSystem.DocIdSignPutResponse;
import br.jus.trf2.assijus.system.api.IAssijusSystem.IDocIdSignPut;

import com.crivano.swaggerservlet.SwaggerUtils;

public class DocIdSignPut implements IDocIdSignPut {

	@Override
	public void run(DocIdSignPutRequest req, DocIdSignPutResponse resp) throws Exception {
		if (req.envelope == null)
			throw new Exception("Envelope não pode ser nulo na gravação da assinatura");
		resp.status = "OK";
	}

	@Override
	public String getContext() {
		return "salvar assinatura";
	}
}